package org.khips.tools;

import java.io.File;
import java.text.DecimalFormat;

/**
 * Main Storage
 *
 * @author Khips
 * @since 19 march 2014
 */
public class KStorage {

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
}
