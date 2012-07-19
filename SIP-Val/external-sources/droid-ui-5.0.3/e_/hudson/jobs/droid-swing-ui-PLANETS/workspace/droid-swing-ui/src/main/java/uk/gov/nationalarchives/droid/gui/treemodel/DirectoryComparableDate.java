/**
 * <p>Copyright (c) The National Archives 2005-2010.  All rights reserved.
 * See Licence.txt for full licence details.
 * <p/>
 *
 * <p>DROID DCS Profile Tool
 * <p/>
 */
package uk.gov.nationalarchives.droid.gui.treemodel;

import java.text.DateFormat;
import java.util.Date;

/**
 * @author rflitcroft
 *
 */
public class DirectoryComparableDate extends DirectoryComparableObject<Date> {

    /**
     * @param source the source Date
     * @param directory if the date represented a directory
     */
    public DirectoryComparableDate(Date source, boolean directory) {
        super(source, directory);
    }
    
    /**
     * Formats the date as a String.
     * @return a formatted date.
     */
    @Override
    public String toString() {
        return getSource() == null ? "" : DateFormat.getInstance().format(getSource());
    }
    
}
