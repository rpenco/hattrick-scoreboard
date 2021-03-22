package org.khips.tools.storage;

import android.content.Context;

import org.khips.tools.KStorage;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * Cache Storage Helper
 *
 * @author Khips
 * @since 19 march 2014
 */
public class CStorage extends KStorage {


    public static List<File> cacheListFiles(Context ctx, File dir,
                                            String startWith) {

        ArrayList<File> files = new ArrayList<File>();

        if (dir.isDirectory()) {
            String[] children = dir.list();
            for (int i = 0; i < children.length; i++) {
                File f = new File(dir, children[i]);
                if (f.getName().startsWith(startWith)) {
                    files.add(f);
                }
            }
            return files;
        }
        return files;
    }

}
