package ch.bedag.a6z.sipvalidator.controller;

import java.io.File;

import ch.bedag.a6z.sipvalidator.exception.module1.Validation1aZipException;
import ch.bedag.a6z.sipvalidator.exception.module1.Validation1bFolderStructureException;
import ch.bedag.a6z.sipvalidator.exception.module1.Validation1cNamingException;
import ch.bedag.a6z.sipvalidator.exception.module1.Validation1dMetadataException;
import ch.bedag.a6z.sipvalidator.exception.module1.Validation1eSipTypeException;
import ch.bedag.a6z.sipvalidator.exception.module1.Validation1fPrimaryDataException;
import ch.bedag.a6z.sipvalidator.exception.module2.Validation2aFileIntegrityException;
import ch.bedag.a6z.sipvalidator.exception.module2.Validation2bChecksumException;
import ch.bedag.a6z.sipvalidator.exception.module2.Validation2cSurplusFilesException;
import ch.bedag.a6z.sipvalidator.exception.module2.Validation2dGeverFileIntegrityException;
import ch.bedag.a6z.sipvalidator.exception.module3.Validation3aFormatRecognitionException;
import ch.bedag.a6z.sipvalidator.exception.module3.Validation3bUnspecifiedFormatException;
import ch.bedag.a6z.sipvalidator.exception.module3.Validation3cFormatValidationException;
import ch.bedag.a6z.sipvalidator.exception.module3.Validation3dPeriodException;
import ch.bedag.a6z.sipvalidator.logging.Logger;
import ch.bedag.a6z.sipvalidator.logging.MessageConstants;
import ch.bedag.a6z.sipvalidator.service.TextResourceService;
import ch.bedag.a6z.sipvalidator.validation.module1.Validation1aZipModule;
import ch.bedag.a6z.sipvalidator.validation.module1.Validation1bFolderStructureModule;
import ch.bedag.a6z.sipvalidator.validation.module1.Validation1cNamingModule;
import ch.bedag.a6z.sipvalidator.validation.module1.Validation1dMetadataModule;
import ch.bedag.a6z.sipvalidator.validation.module1.Validation1eSipTypeModule;
import ch.bedag.a6z.sipvalidator.validation.module1.Validation1fPrimaryDataModule;
import ch.bedag.a6z.sipvalidator.validation.module2.Validation2aFileIntegrityModule;
import ch.bedag.a6z.sipvalidator.validation.module2.Validation2bChecksumModule;
import ch.bedag.a6z.sipvalidator.validation.module2.Validation2cSurplusFilesModule;
import ch.bedag.a6z.sipvalidator.validation.module2.Validation2dGeverFileIntegrityModule;
import ch.bedag.a6z.sipvalidator.validation.module3.Validation3aFormatRecognitionModule;
import ch.bedag.a6z.sipvalidator.validation.module3.Validation3bUnspecifiedFormatModule;
import ch.bedag.a6z.sipvalidator.validation.module3.Validation3cFormatValidationModule;
import ch.bedag.a6z.sipvalidator.validation.module3.Validation3dPeriodModule;

/**
 * 
 * Der Controller ruft die ben�tigten Module zur Validierung des SIP-Archivs in
 * der ben�tigten Reihenfolge auf.
 * 
 * Die Validierungs-Module werden mittels Spring-Dependency-Injection
 * eingebunden.
 * 
 * @author razm Daniel Ludin, Bedag AG @version 2.0
 * 
 */
public class Controller implements MessageConstants {

    private static final Logger LOGGER = new Logger(Controller.class);

    private Validation1aZipModule validation1aZipModule;

    private Validation1bFolderStructureModule validation1bFolderStructureModule;

    private Validation1cNamingModule validation1cNamingModule;

    private Validation1dMetadataModule validation1dMetadataModule;

    private Validation1eSipTypeModule validation1eSipTypeModule;

    private Validation1fPrimaryDataModule validation1fPrimaryDataModule;

    private Validation2aFileIntegrityModule validation2aFileIntegrityModule;

    private Validation2bChecksumModule validation2bChecksumModule;

    private Validation2cSurplusFilesModule validation2cSurplusFilesModule;

    private Validation2dGeverFileIntegrityModule validation2dGeverFileIntegrityModule;

    private Validation3aFormatRecognitionModule validation3aFormatRecognitionModule;

    private Validation3bUnspecifiedFormatModule validation3bUnspecifiedFormatModule;

    private Validation3cFormatValidationModule validation3cFormatValidationModule;

    private Validation3dPeriodModule validation3dPeriodModule;

    private TextResourceService textResourceService;


    public Validation1aZipModule getValidation1aZipModule() {
        return validation1aZipModule;
    }

    public void setValidation1aZipModule(Validation1aZipModule validation1aZipModule) {
        this.validation1aZipModule = validation1aZipModule;
    }

    public Validation1bFolderStructureModule getValidation1bFolderStructureModule() {
        return validation1bFolderStructureModule;
    }

    public void setValidation1bFolderStructureModule(Validation1bFolderStructureModule validation1bFolderStructureModule) {
        this.validation1bFolderStructureModule = validation1bFolderStructureModule;
    }

    public Validation1cNamingModule getValidation1cNamingModule() {
        return validation1cNamingModule;
    }

    public void setValidation1cNamingModule(Validation1cNamingModule validation1cNamingModule) {
        this.validation1cNamingModule = validation1cNamingModule;
    }

    public Validation1dMetadataModule getValidation1dMetadataModule() {
        return validation1dMetadataModule;
    }

    public void setValidation1dMetadataModule(Validation1dMetadataModule validation1dMetadataModule) {
        this.validation1dMetadataModule = validation1dMetadataModule;
    }

    public Validation1eSipTypeModule getValidation1eSipTypeModule() {
        return validation1eSipTypeModule;
    }

    public void setValidation1eSipTypeModule(Validation1eSipTypeModule validation1eSipTypeModule) {
        this.validation1eSipTypeModule = validation1eSipTypeModule;
    }

    public Validation1fPrimaryDataModule getValidation1fPrimaryDataModule() {
        return validation1fPrimaryDataModule;
    }

    public void setValidation1fPrimaryDataModule(Validation1fPrimaryDataModule validation1fPrimaryDataModule) {
        this.validation1fPrimaryDataModule = validation1fPrimaryDataModule;
    }

    public Validation2aFileIntegrityModule getValidation2aFileIntegrityModule() {
        return validation2aFileIntegrityModule;
    }

    public void setValidation2aFileIntegrityModule(Validation2aFileIntegrityModule validation2aFileIntegrityModule) {
        this.validation2aFileIntegrityModule = validation2aFileIntegrityModule;
    }

    public Validation2bChecksumModule getValidation2bChecksumModule() {
        return validation2bChecksumModule;
    }

    public void setValidation2bChecksumModule(Validation2bChecksumModule validation2bChecksumModule) {
        this.validation2bChecksumModule = validation2bChecksumModule;
    }

    public Validation2cSurplusFilesModule getValidation2cSurplusFilesModule() {
        return validation2cSurplusFilesModule;
    }

    public void setValidation2cSurplusFilesModule(Validation2cSurplusFilesModule validation2cSurplusFilesModule) {
        this.validation2cSurplusFilesModule = validation2cSurplusFilesModule;
    }

    public Validation2dGeverFileIntegrityModule getValidation2dGeverFileIntegrityModule() {
        return validation2dGeverFileIntegrityModule;
    }

    public void setValidation2dGeverFileIntegrityModule(
            Validation2dGeverFileIntegrityModule validation2dGeverFileIntegrityModule) {
        this.validation2dGeverFileIntegrityModule = validation2dGeverFileIntegrityModule;
    }

    public Validation3aFormatRecognitionModule getValidation3aFormatRecognitionModule() {
        return validation3aFormatRecognitionModule;
    }

    public void setValidation3aFormatRecognitionModule(
            Validation3aFormatRecognitionModule validation3aFormatRecognitionModule) {
        this.validation3aFormatRecognitionModule = validation3aFormatRecognitionModule;
    }

    public Validation3bUnspecifiedFormatModule getValidation3bUnspecifiedFormatModule() {
        return validation3bUnspecifiedFormatModule;
    }

    public void setValidation3bUnspecifiedFormatModule(
            Validation3bUnspecifiedFormatModule validation3bUnspecifiedFormatModule) {
        this.validation3bUnspecifiedFormatModule = validation3bUnspecifiedFormatModule;
    }

    public Validation3cFormatValidationModule getValidation3cFormatValidationModule() {
        return validation3cFormatValidationModule;
    }

    public void setValidation3cFormatValidationModule(
            Validation3cFormatValidationModule validation3cFormatValidationModule) {
        this.validation3cFormatValidationModule = validation3cFormatValidationModule;
    }

    public Validation3dPeriodModule getValidation3dPeriodModule() {
        return validation3dPeriodModule;
    }

    public void setValidation3dPeriodModule(Validation3dPeriodModule validation3dPeriodModule) {
        this.validation3dPeriodModule = validation3dPeriodModule;
    }

    public TextResourceService getTextResourceService() {
        return textResourceService;
    }

    public void setTextResourceService(TextResourceService textResourceService) {
        this.textResourceService = textResourceService;
    }

    
    public boolean executeMandatory(File sipDatei) {
        boolean valid = true;
        /* */

        /*
        File inputzipfile = new File("C:\\ludin\\A6Z-SIP-Validator\\SIP-Beispiele 20110112\\SIP_20101018_RIS_4.zip");
        File targetdir = new File("C:\\ludin\\tmp9\\SIP_20101018_RIS_4");
        try {
            Decompress.decompress(inputzipfile, targetdir);
        } catch (SipValidatorException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        }*/
        
        // Validation Step Aa
        try {
            if (this.getValidation1aZipModule().validate(sipDatei)) {
                LOGGER.logInfo(getTextResourceService().getText(MESSAGE_MODULE_VALID,
                        getTextResourceService().getText(MESSAGE_MODULE_Aa)));
                this.getValidation1aZipModule().getMessageService().print();
            } else {
                LOGGER.logInfo(getTextResourceService().getText(MESSAGE_MODULE_INVALID,
                        getTextResourceService().getText(MESSAGE_MODULE_Aa))
                        + getTextResourceService().getText(MESSAGE_STEPERGEBNIS_Aa));
                // Ein negatives Validierungsresultat in diesem Schritt f�hrt
                // zum Abbruch der weiteren Verarbeitung
                this.getValidation1aZipModule().getMessageService().print();
                return false;
            }

        } catch (Validation1aZipException e) {
            LOGGER.logInfo(getTextResourceService().getText(MESSAGE_MODULE_INVALID_2ARGS,
                    getTextResourceService().getText(MESSAGE_MODULE_Aa), e.getMessage()));
            this.getValidation1aZipModule().getMessageService().print();
            return false;
            
        } catch (Exception e) {          
            LOGGER.logInfo(getTextResourceService().getText(ERROR_UNKNOWN));
            LOGGER.logError(e.getMessage());
            return false;
        }

        // Validation Step Ab
        try {
            if (this.getValidation1bFolderStructureModule().validate(sipDatei)) {
                LOGGER.logInfo(getTextResourceService().getText(MESSAGE_MODULE_VALID,
                        getTextResourceService().getText(MESSAGE_MODULE_Ab)));
                this.getValidation1bFolderStructureModule().getMessageService().print();
            } else {
                LOGGER.logInfo(getTextResourceService().getText(MESSAGE_MODULE_INVALID,
                        getTextResourceService().getText(MESSAGE_MODULE_Ab))
                        + getTextResourceService().getText(MESSAGE_STEPERGEBNIS_Ab));
                // Ein negatives Validierungsresultat in diesem Schritt f�hrt
                // zum Abbruch der weiteren Verarbeitung
                this.getValidation1bFolderStructureModule().getMessageService().print();
                return false;
            }
        } catch (Validation1bFolderStructureException e) {
            LOGGER.logInfo(getTextResourceService().getText(MESSAGE_MODULE_INVALID_2ARGS,
                    getTextResourceService().getText(MESSAGE_MODULE_Ab), e.getMessage()));
            this.getValidation1bFolderStructureModule().getMessageService().print();
            return false;
        } catch (Exception e) {          
            LOGGER.logInfo(getTextResourceService().getText(ERROR_UNKNOWN));
            LOGGER.logError(e.getMessage());
            return false;
        }


        // Validation Step Ac
        try {
            if (this.getValidation1cNamingModule().validate(sipDatei)) {
                LOGGER.logInfo(getTextResourceService().getText(MESSAGE_MODULE_VALID,
                        getTextResourceService().getText(MESSAGE_MODULE_Ac)));
                this.getValidation1cNamingModule().getMessageService().print();
            } else {
                LOGGER.logInfo(getTextResourceService().getText(MESSAGE_MODULE_INVALID,
                        getTextResourceService().getText(MESSAGE_MODULE_Ac))
                        + getTextResourceService().getText(MESSAGE_STEPERGEBNIS_Ac));
                this.getValidation1cNamingModule().getMessageService().print();
                // Ein negatives Validierungsresultat in diesem Schritt f�hrt
                // zum Abbruch der weiteren Verarbeitung
                return false;
            }
        } catch (Validation1cNamingException e) {
            LOGGER.logInfo(getTextResourceService().getText(MESSAGE_MODULE_INVALID_2ARGS,
                    getTextResourceService().getText(MESSAGE_MODULE_Ac), e.getMessage()));
            this.getValidation1cNamingModule().getMessageService().print();
            return false;
        } catch (Exception e) {          
            LOGGER.logInfo(getTextResourceService().getText(ERROR_UNKNOWN));
            LOGGER.logError(e.getMessage());
            return false;
        }


        // Validation Step Ad
        try {
            if (this.getValidation1dMetadataModule().validate(sipDatei)) {
                LOGGER.logInfo(getTextResourceService().getText(MESSAGE_MODULE_VALID,
                        getTextResourceService().getText(MESSAGE_MODULE_Ad)));
                this.getValidation1dMetadataModule().getMessageService().print();
            } else {
                LOGGER.logInfo(getTextResourceService().getText(MESSAGE_MODULE_INVALID,
                        getTextResourceService().getText(MESSAGE_MODULE_Ad))
                        + getTextResourceService().getText(MESSAGE_STEPERGEBNIS_Ad));
                this.getValidation1dMetadataModule().getMessageService().print();
                // Ein negatives Validierungsresultat in diesem Schritt f�hrt
                // zum Abbruch der weiteren Verarbeitung
                return false;
            }
        } catch (Validation1dMetadataException e) {
            LOGGER.logInfo(getTextResourceService().getText(MESSAGE_MODULE_INVALID_2ARGS,
                    getTextResourceService().getText(MESSAGE_MODULE_Ad), e.getMessage()));
            this.getValidation1dMetadataModule().getMessageService().print();
            return false;
        } catch (Exception e) {          
            LOGGER.logInfo(getTextResourceService().getText(ERROR_UNKNOWN));
            LOGGER.logError(e.getMessage());
            return false;
        }

        
        
        return valid;
        
    }
    
    
    
    public boolean executeOptional(File sipDatei) {
        boolean valid = true;
        /* */

        
        // Validation Step Ae
        try {
            if (this.getValidation1eSipTypeModule().validate(sipDatei)) {
                LOGGER.logInfo(getTextResourceService().getText(MESSAGE_MODULE_VALID,
                        getTextResourceService().getText(MESSAGE_MODULE_Ae)));
                this.getValidation1eSipTypeModule().getMessageService().print();
            } else {
                LOGGER.logInfo(getTextResourceService().getText(MESSAGE_MODULE_INVALID,
                        getTextResourceService().getText(MESSAGE_MODULE_Ae))
                        + getTextResourceService().getText(MESSAGE_STEPERGEBNIS_Ae));
                this.getValidation1eSipTypeModule().getMessageService().print();
                valid = false;
            }
        } catch (Validation1eSipTypeException e) {
            LOGGER.logInfo(getTextResourceService().getText(MESSAGE_MODULE_INVALID_2ARGS,
                    getTextResourceService().getText(MESSAGE_MODULE_Ae), e.getMessage()));
            this.getValidation1eSipTypeModule().getMessageService().print();
            valid = false;
        } catch (Exception e) {          
            LOGGER.logInfo(getTextResourceService().getText(ERROR_UNKNOWN));
            LOGGER.logError(e.getMessage());
            return false;
        }


        // Validation Step Af
        try {
            if (this.getValidation1fPrimaryDataModule().validate(sipDatei)) {
                LOGGER.logInfo(getTextResourceService().getText(MESSAGE_MODULE_VALID,
                        getTextResourceService().getText(MESSAGE_MODULE_Af)));
                this.getValidation1fPrimaryDataModule().getMessageService().print();
            } else {
                LOGGER.logInfo(getTextResourceService().getText(MESSAGE_MODULE_INVALID,
                        getTextResourceService().getText(MESSAGE_MODULE_Af))
                        + getTextResourceService().getText(MESSAGE_STEPERGEBNIS_Af));
                this.getValidation1fPrimaryDataModule().getMessageService().print();
                valid = false;
            }
        } catch (Validation1fPrimaryDataException e) {
            LOGGER.logInfo(getTextResourceService().getText(MESSAGE_MODULE_INVALID_2ARGS,
                    getTextResourceService().getText(MESSAGE_MODULE_Ab), e.getMessage()));
            this.getValidation1fPrimaryDataModule().getMessageService().print();
            valid = false;
        } catch (Exception e) {          
            LOGGER.logInfo(getTextResourceService().getText(ERROR_UNKNOWN));
            LOGGER.logError(e.getMessage());
            return false;
        }


        // Validation Step Ba
        try {
            if (this.getValidation2aFileIntegrityModule().validate(sipDatei)) {
                LOGGER.logInfo(getTextResourceService().getText(MESSAGE_MODULE_VALID,
                        getTextResourceService().getText(MESSAGE_MODULE_Ba)));
                this.getValidation2aFileIntegrityModule().getMessageService().print();
            } else {
                LOGGER.logInfo(getTextResourceService().getText(MESSAGE_MODULE_INVALID,
                        getTextResourceService().getText(MESSAGE_MODULE_Ba))
                        + getTextResourceService().getText(MESSAGE_STEPERGEBNIS_Ba));
                this.getValidation2aFileIntegrityModule().getMessageService().print();
                valid = false;
            }
        } catch (Validation2aFileIntegrityException e) {
            LOGGER.logInfo(getTextResourceService().getText(MESSAGE_MODULE_INVALID_2ARGS,
                    getTextResourceService().getText(MESSAGE_MODULE_Ba), e.getMessage()));
            this.getValidation2aFileIntegrityModule().getMessageService().print();
            valid = false;
        } catch (Exception e) {          
            LOGGER.logInfo(getTextResourceService().getText(ERROR_UNKNOWN));
            LOGGER.logError(e.getMessage());
            return false;
        }


        // Validation Step Bb
        try {
            if (this.getValidation2bChecksumModule().validate(sipDatei)) {
                LOGGER.logInfo(getTextResourceService().getText(MESSAGE_MODULE_VALID,
                        getTextResourceService().getText(MESSAGE_MODULE_Bb)));
                this.getValidation2bChecksumModule().getMessageService().print();
            } else {
                LOGGER.logInfo(getTextResourceService().getText(MESSAGE_MODULE_INVALID,
                        getTextResourceService().getText(MESSAGE_MODULE_Bb))
                        + getTextResourceService().getText(MESSAGE_STEPERGEBNIS_Bb));
                this.getValidation2bChecksumModule().getMessageService().print();
                valid = false;
            }
        } catch (Validation2bChecksumException e) {
            LOGGER.logInfo(getTextResourceService().getText(MESSAGE_MODULE_INVALID_2ARGS,
                    getTextResourceService().getText(MESSAGE_MODULE_Bb), e.getMessage()));
            this.getValidation2bChecksumModule().getMessageService().print();
            valid = false;
        } catch (Exception e) {          
            LOGGER.logInfo(getTextResourceService().getText(ERROR_UNKNOWN));
            LOGGER.logError(e.getMessage());
            return false;
        }


        // Validation Step Bc
        try {
            if (this.getValidation2cSurplusFilesModule().validate(sipDatei)) {
                LOGGER.logInfo(getTextResourceService().getText(MESSAGE_MODULE_VALID,
                        getTextResourceService().getText(MESSAGE_MODULE_Bc)));
                this.getValidation2cSurplusFilesModule().getMessageService().print();
            } else {
                LOGGER.logInfo(getTextResourceService().getText(MESSAGE_MODULE_INVALID,
                        getTextResourceService().getText(MESSAGE_MODULE_Bc))
                        + getTextResourceService().getText(MESSAGE_STEPERGEBNIS_Bc));
                this.getValidation2cSurplusFilesModule().getMessageService().print();
                valid = false;
            }
        } catch (Validation2cSurplusFilesException e) {
            LOGGER.logInfo(getTextResourceService().getText(MESSAGE_MODULE_INVALID_2ARGS,
                    getTextResourceService().getText(MESSAGE_MODULE_Bc), e.getMessage()));
            this.getValidation2cSurplusFilesModule().getMessageService().print();
            valid = false;
        } catch (Exception e) {          
            LOGGER.logInfo(getTextResourceService().getText(ERROR_UNKNOWN));
            LOGGER.logError(e.getMessage());
            return false;
        }


        // Validation Step Bd
        try {
            if (this.getValidation2dGeverFileIntegrityModule().validate(sipDatei)) {
                LOGGER.logInfo(getTextResourceService().getText(MESSAGE_MODULE_VALID,
                        getTextResourceService().getText(MESSAGE_MODULE_Bd)));
                this.getValidation2dGeverFileIntegrityModule().getMessageService().print();
            } else {
                LOGGER.logInfo(getTextResourceService().getText(MESSAGE_MODULE_INVALID,
                        getTextResourceService().getText(MESSAGE_MODULE_Bd))
                        + getTextResourceService().getText(MESSAGE_STEPERGEBNIS_Bd));
                this.getValidation2dGeverFileIntegrityModule().getMessageService().print();
                valid = false;
            }
        } catch (Validation2dGeverFileIntegrityException e) {
            LOGGER.logInfo(getTextResourceService().getText(MESSAGE_MODULE_INVALID_2ARGS,
                    getTextResourceService().getText(MESSAGE_MODULE_Bd), e.getMessage()));
            this.getValidation2dGeverFileIntegrityModule().getMessageService().print();
            valid = false;
        } catch (Exception e) {          
            LOGGER.logInfo(getTextResourceService().getText(ERROR_UNKNOWN));
            LOGGER.logError(e.getMessage());
            return false;
        }


        // Validation Step Ca
        try {
            if (this.getValidation3aFormatRecognitionModule().validate(sipDatei)) {
                LOGGER.logInfo(getTextResourceService().getText(MESSAGE_MODULE_VALID,
                        getTextResourceService().getText(MESSAGE_MODULE_Ca)));
                this.getValidation3aFormatRecognitionModule().getMessageService().print();
            } else {
                LOGGER.logInfo(getTextResourceService().getText(MESSAGE_MODULE_INVALID,
                        getTextResourceService().getText(MESSAGE_MODULE_Ca))
                        + getTextResourceService().getText(MESSAGE_STEPERGEBNIS_Ca));
                this.getValidation3aFormatRecognitionModule().getMessageService().print();
                valid = false;
            }
        } catch (Validation3aFormatRecognitionException e) {
            LOGGER.logInfo(getTextResourceService().getText(MESSAGE_MODULE_INVALID_2ARGS,
                    getTextResourceService().getText(MESSAGE_MODULE_Ca), e.getMessage()));
            this.getValidation3aFormatRecognitionModule().getMessageService().print();
            valid = false;
        } catch (Exception e) {          
            LOGGER.logInfo(getTextResourceService().getText(ERROR_UNKNOWN));
            LOGGER.logError(e.getMessage());
            return false;
        }


        // Validation Step Cb
        try {
            if (this.getValidation3bUnspecifiedFormatModule().validate(sipDatei)) {
                LOGGER.logInfo(getTextResourceService().getText(MESSAGE_MODULE_VALID,
                        getTextResourceService().getText(MESSAGE_MODULE_Cb)));
                this.getValidation3bUnspecifiedFormatModule().getMessageService().print();
            } else {
                LOGGER.logInfo(getTextResourceService().getText(MESSAGE_MODULE_INVALID,
                        getTextResourceService().getText(MESSAGE_MODULE_Cb))
                        + getTextResourceService().getText(MESSAGE_STEPERGEBNIS_Cb));
                valid = false;
                this.getValidation3bUnspecifiedFormatModule().getMessageService().print();
            }
        } catch (Validation3bUnspecifiedFormatException e) {
            LOGGER.logInfo(getTextResourceService().getText(MESSAGE_MODULE_INVALID_2ARGS,
                    getTextResourceService().getText(MESSAGE_MODULE_Cb), e.getMessage()));
            this.getValidation3bUnspecifiedFormatModule().getMessageService().print();
            valid = false;
        } catch (Exception e) {          
            LOGGER.logInfo(getTextResourceService().getText(ERROR_UNKNOWN));
            LOGGER.logError(e.getMessage());
            return false;
        }


        return valid;

    }
    
    
    public boolean execute3c(File sipDatei) {
        boolean valid = true;

        // Validation Step 3c
        try {
            if (this.getValidation3cFormatValidationModule().validate(sipDatei)) {
                LOGGER.logInfo(getTextResourceService().getText(MESSAGE_MODULE_VALID,
                        getTextResourceService().getText(MESSAGE_MODULE_Cc)));
                this.getValidation3cFormatValidationModule().getMessageService().print();
            } else {
                LOGGER.logInfo(getTextResourceService().getText(MESSAGE_MODULE_INVALID,
                        getTextResourceService().getText(MESSAGE_MODULE_Cc))
                        + getTextResourceService().getText(MESSAGE_STEPERGEBNIS_Cc));
                this.getValidation3cFormatValidationModule().getMessageService().print();
                valid = false;
            }

        } catch (Validation3cFormatValidationException e) {
            LOGGER.logInfo(getTextResourceService().getText(MESSAGE_MODULE_INVALID_2ARGS,
                    getTextResourceService().getText(MESSAGE_MODULE_Cc), e.getMessage()));
            this.getValidation3cFormatValidationModule().getMessageService().print();
            return false;
        } catch (Exception e) {          
            LOGGER.logInfo(getTextResourceService().getText(ERROR_UNKNOWN));
            LOGGER.logError(e.getMessage());
            return false;
        }


        return valid;

    }
    
    
    public boolean execute3d(File sipDatei) {
        boolean valid = true;

        // Validation Step 3d
        try {
            if (this.getValidation3dPeriodModule().validate(sipDatei)) {
                LOGGER.logInfo(getTextResourceService().getText(MESSAGE_MODULE_VALID,
                        getTextResourceService().getText(MESSAGE_MODULE_Cd)));
                this.getValidation3dPeriodModule().getMessageService().print();
            } else {
                LOGGER.logInfo(getTextResourceService().getText(MESSAGE_MODULE_INVALID,
                        getTextResourceService().getText(MESSAGE_MODULE_Cd))
                        + getTextResourceService().getText(MESSAGE_STEPERGEBNIS_Cd));
                this.getValidation3dPeriodModule().getMessageService().print();
                valid = false;
            }

        } catch (Validation3dPeriodException e) {
            LOGGER.logInfo(getTextResourceService().getText(MESSAGE_MODULE_INVALID_2ARGS,
                    getTextResourceService().getText(MESSAGE_MODULE_Cd), e.getMessage()));
            this.getValidation3dPeriodModule().getMessageService().print();
            return false;
        } catch (Exception e) {          
            LOGGER.logInfo(getTextResourceService().getText(ERROR_UNKNOWN));
            LOGGER.logError(e.getMessage());
            return false;
        }


        return valid;

    }
    
    
    
}
