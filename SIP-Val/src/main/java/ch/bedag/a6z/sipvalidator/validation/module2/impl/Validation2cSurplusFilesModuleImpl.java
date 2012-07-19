package ch.bedag.a6z.sipvalidator.validation.module2.impl;

import java.io.BufferedInputStream;
import java.io.File;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.apache.xpath.XPathAPI;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.w3c.dom.traversal.NodeIterator;

import ch.bedag.a6z.sipvalidator.exception.module2.Validation2cSurplusFilesException;
import ch.bedag.a6z.sipvalidator.validation.ValidationModuleImpl;
import ch.bedag.a6z.sipvalidator.validation.module2.Validation2cSurplusFilesModule;
import ch.enterag.utils.zip.EntryInputStream;
import ch.enterag.utils.zip.FileEntry;
import ch.enterag.utils.zip.Zip64File;

public class Validation2cSurplusFilesModuleImpl extends ValidationModuleImpl implements Validation2cSurplusFilesModule {

    @SuppressWarnings("unchecked")
    @Override
    public boolean validate(File sipDatei) throws Validation2cSurplusFilesException {

        String toplevelDir = sipDatei.getName();
        int lastDotIdx = toplevelDir.lastIndexOf(".");
        toplevelDir = toplevelDir.substring(0, lastDotIdx);


        boolean valid = true;
        FileEntry metadataxml = null;
        Map<String, String> filesInSipFile = new HashMap<String, String>();
        Map<String, String> filesInMetadata = new HashMap<String, String>();
        
        
        try {
            Zip64File zipfile = new Zip64File(sipDatei);
            List<FileEntry> fileEntryList = zipfile.getListFileEntries();
            for (FileEntry fileEntry : fileEntryList) {
                
                //System.out.println(fileEntry.getName());

                if (fileEntry.getName().equals("header/" + METADATA) || 
                        fileEntry.getName().equals(toplevelDir + "/header/" + METADATA)) {
                    metadataxml = fileEntry;
                }
                
                if (!fileEntry.isDirectory()) {
                    if (!fileEntry.getName().equals("header/" + METADATA) && 
                        !fileEntry.getName().equals(toplevelDir + "/header/" + METADATA)) {
                        
                        String fileName = fileEntry.getName();
                        String toReplace = toplevelDir + "/";
                        fileName = fileName.replace(toReplace, "");
                        
                        filesInSipFile.put(fileName, fileName);
                        //filesInSipFile.put(fileEntry.getName(), fileEntry.getName());
                        
                    }
                }

            }
            
            // keine metadata.xml in der SIP-Datei gefunden
            if (metadataxml == null) {
                getMessageService().logError(
                        getTextResourceService().getText(MESSAGE_MODULE_Bc) + 
                        getTextResourceService().getText(MESSAGE_DASHES) + 
                        getTextResourceService().getText(ERROR_MODULE_AE_NOMETADATAFOUND));                                
                return false;

            }
            
            EntryInputStream eis = zipfile.openEntryInputStream(metadataxml.getName());
            BufferedInputStream is = new BufferedInputStream(eis);

            try {
                DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
                DocumentBuilder db = dbf.newDocumentBuilder();
                Document doc = db.parse(is);
                doc.normalize();
                NodeList nodeLst = doc.getElementsByTagName("datei");

                for (int s = 0; s < nodeLst.getLength(); s++) {
                    Node dateiNode = nodeLst.item(s);

                    NodeIterator nl = XPathAPI.selectNodeIterator(dateiNode, "name");
                    Node nameNode = nl.nextNode();
                    String path = nameNode.getTextContent();
                                       
                    boolean topReached = false;

                    while (!topReached) {

                        Node parentNode = dateiNode.getParentNode();
                        if (parentNode.getNodeName().equals("inhaltsverzeichnis")) {
                            topReached = true;
                            break;
                        }

                        NodeList childrenNodes = parentNode.getChildNodes();
                        for (int x = 0; x < childrenNodes.getLength(); x++) {
                            Node childNode = childrenNodes.item(x);

                            if (childNode.getNodeName().equals("name")) {
                                path = childNode.getTextContent() + "/" + path;
                                if (dateiNode.getParentNode() != null) {
                                    dateiNode = dateiNode.getParentNode();
                                }
                                break;
                            }
                        }
                    }

                    filesInMetadata.put(path, path);
                    path = "";

                }
            } catch (Exception e) {
                getMessageService().logError(
                    getTextResourceService().getText(MESSAGE_MODULE_Bc) + 
                    getTextResourceService().getText(MESSAGE_DASHES) + 
                    e.getMessage());                                
                return false;
            }

            Set<String> keysInMetadata = filesInMetadata.keySet();
            for (Iterator<String> iterator = keysInMetadata.iterator(); iterator.hasNext();) {
                String keyMetadata = iterator.next();
                filesInSipFile.remove(keyMetadata);
            }

            Set<String> keysInSipfile = filesInSipFile.keySet();
            for (Iterator<String> iterator = keysInSipfile.iterator(); iterator.hasNext();) {
                String keySipfile = iterator.next();
                getMessageService().logError(
                        getTextResourceService().getText(MESSAGE_MODULE_Bc) + 
                        getTextResourceService().getText(MESSAGE_DASHES) + keySipfile);
                valid = false;                
            }
            
            zipfile.close();
            is.close();
            
            
        } catch (Exception e) {
            getMessageService().logError(
                    getTextResourceService().getText(MESSAGE_MODULE_Bc) + 
                    getTextResourceService().getText(MESSAGE_DASHES) + 
                    e.getMessage());                                
                return false;
        }

        return valid;
    
    
    }

}