package org.hattrickscoreboardl.utils.storage;

import java.io.File;
import java.text.DecimalFormat;

/**
 * Main Storage
 *
 * @author Khips
 * @since 19 mars 2014
 */
public class Storage {

    /**
     * File size
     * @param dir
     * @return
     */
    public static long size(File dir) {
        if (dir.exists()) {
            long result = 0;
            File[] fileList = dir.listFiles();
            for (int i = 0; i < fileList.length; i++) {
                // Recursive call if it's a directory
                if (fileList[i].isDirectory()) {
                    result += size(fileList[i]);
                } else {
                    // Sum the file size in bytes
                    result += fileList[i].length();
                }
            }
            return result; // return the file size
        }
        return 0;
    }

    /**
     * Size to String xx KB
     * @param size
     * @param units
     * @return
     */
    public static String toStringSize(long size, String[] units) {
        if (size <= 0)
            return "0";
        int digitGroups = (int) (Math.log10(size) / Math.log10(1024));
        return new DecimalFormat("#,##0.#").format(size
                / Math.pow(1024, digitGroups))
                + " " + units[digitGroups];
    }


}
