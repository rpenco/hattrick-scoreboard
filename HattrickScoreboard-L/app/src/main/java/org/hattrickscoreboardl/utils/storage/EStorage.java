package org.hattrickscoreboardl.utils.storage;

import android.content.Context;
import android.os.Environment;

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
 * External Storage Helper
 *
 * @author Khips
 * @since 19 mars 2014
 */
public class EStorage extends Storage {

    public static String externalPathDirectory(Context ctx) {
        return Environment.getExternalStorageDirectory().toString();
    }

    public static boolean externalFileExist(Context ctx, String FILENAME) {
        String file = externalPathDirectory(ctx) + "/" + FILENAME;
        File f = new File(file);
        return (f.exists());
    }

    public static String externalReadFileString(Context ctx, String FILENAME)
            throws IOException {

        BufferedReader bufferedReader = externalReadFile(ctx, FILENAME);

        StringBuilder sb = new StringBuilder();
        String line;
        while ((line = bufferedReader.readLine()) != null) {
            sb.append(line);
        }

        return sb.toString();

    }

    public static BufferedReader externalReadFile(Context ctx, String FILENAME)
            throws FileNotFoundException {
        // TODO
        FileInputStream in = ctx.openFileInput(FILENAME);
        InputStreamReader inputStreamReader = new InputStreamReader(in);
        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
        return bufferedReader;

    }

    public static void externalWriteFileString(Context ctx, String FILENAME,
                                               String value) throws IOException {
        externalWriteFile(ctx, FILENAME, value.getBytes());

    }

    public static void externalWriteFile(Context ctx, String FILENAME,
                                         byte[] value) throws IOException {
        // TODO
        FileOutputStream fos = ctx.openFileOutput(FILENAME,
                Context.MODE_PRIVATE);
        fos.write(value);
        fos.close();
    }

    public static boolean externalRemoveFile(Context ctx, String FILENAME) {

        File file = new File(externalPathDirectory(ctx), FILENAME);
        return file.delete();
    }

    public static boolean externalClearFiles(Context ctx) {
        File dir = new File(externalPathDirectory(ctx));
        if (dir.isDirectory()) {
            String[] children = dir.list();
            for (int i = 0; i < children.length; i++) {
                new File(dir, children[i]).delete();
            }
            return true;
        }
        return false;
    }

    public static List<File> externalListFiles(Context ctx, String startWith) {

        ArrayList<File> files = new ArrayList<File>();

        File dir = new File(externalPathDirectory(ctx));
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

    public static boolean externalCacheFileExist(Context ctx, String FILENAME) {
        String file = externalPathDirectory(ctx) + "/" + FILENAME;
        File f = new File(file);
        return (f.exists());
    }

}
