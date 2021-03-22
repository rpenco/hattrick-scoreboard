package org.hattrickscoreboardl.utils.storage;

import android.content.Context;

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
 * @since 19 mars 2014
 */
public class CStorage extends Storage {

    public static String cachePathDirectory(Context ctx) {
        return ctx.getExternalCacheDir().toString();
    }

    public static boolean cacheFileExist(Context ctx, String FILENAME) {
        String file = cachePathDirectory(ctx) + "/" + FILENAME;
        File f = new File(file);
        return (f.exists());
    }

    public static String cacheReadFileString(Context ctx, String FILENAME)
            throws IOException {

        BufferedReader bufferedReader = cacheReadFile(ctx, FILENAME);

        StringBuilder sb = new StringBuilder();
        String line;
        while ((line = bufferedReader.readLine()) != null) {
            sb.append(line);
        }

        return sb.toString();

    }

    public static BufferedReader cacheReadFile(Context ctx, String FILENAME)
            throws FileNotFoundException {
        // TODO
        FileInputStream in = ctx.openFileInput(FILENAME);
        InputStreamReader inputStreamReader = new InputStreamReader(in);
        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
        return bufferedReader;

    }

    public static void cacheWriteFileString(Context ctx, String FILENAME,
                                            String value) throws IOException {
        cacheWriteFile(ctx, FILENAME, value.getBytes());

    }

    public static void cacheWriteFile(Context ctx, String FILENAME, byte[] value)
            throws IOException {
        // TODO
        FileOutputStream fos = ctx.openFileOutput(FILENAME,
                Context.MODE_PRIVATE);
        fos.write(value);
        fos.close();
    }

    public static boolean cacheRemoveFile(Context ctx, String FILENAME) {
        File file = new File(cachePathDirectory(ctx), FILENAME);
        return file.delete();
    }

    public static boolean cacheClearFiles(Context ctx) {
        File dir = new File(cachePathDirectory(ctx));
        if (dir.isDirectory()) {
            String[] children = dir.list();
            for (int i = 0; i < children.length; i++) {
                new File(dir, children[i]).delete();
            }
            return true;
        }
        return false;
    }

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
