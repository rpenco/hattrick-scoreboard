package org.hattrickscoreboardl.utils.storage;

import android.content.Context;

import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * Internal Storage Helper
 *
 * @author Khips
 * @since 19 mars 2014
 */
public class IStorage extends Storage {

    // Internal functions

    public static String internalPathDirectory(Context ctx) {
        return ctx.getApplicationContext().getFilesDir().getAbsolutePath();
    }

    public static boolean internalFileExist(Context ctx, String FILENAME) {
        String file = ctx.getFilesDir() + "/" + FILENAME;
        File f = new File(file);
        return (f.exists());
    }

    public static String internalReadFileString(Context ctx, String FILENAME)
            throws IOException {

        BufferedReader bufferedReader = internalReadFile(ctx, FILENAME);

        StringBuilder sb = new StringBuilder();
        String line;
        while ((line = bufferedReader.readLine()) != null) {
            sb.append(line);
        }

        return sb.toString();

    }

    public static BufferedReader internalReadFile(Context ctx, String FILENAME)
            throws FileNotFoundException {

        FileInputStream in = ctx.openFileInput(FILENAME);
        InputStreamReader inputStreamReader = new InputStreamReader(in);
        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
        return bufferedReader;

    }

    public static void internalWriteFileString(Context ctx, String FILENAME,
                                               String value) throws IOException {
        internalWriteFile(ctx, FILENAME, value.getBytes());

    }

    public static void internalWriteFile(Context ctx, String FILENAME,
                                         byte[] value) throws IOException {
        FileOutputStream fos = ctx.openFileOutput(FILENAME,
                Context.MODE_PRIVATE);
        fos.write(value);
        fos.close();
    }

    public static boolean internalRemoveFile(Context ctx, String FILENAME) {
        File dir = ctx.getFilesDir();
        File file = new File(dir, FILENAME);
        return file.delete();
    }

    public static boolean internalClearFiles(Context ctx) {
        File dir = ctx.getFilesDir();
        if (dir.isDirectory()) {
            String[] children = dir.list();
            for (int i = 0; i < children.length; i++) {
                new File(dir, children[i]).delete();
            }
            return true;
        }
        return false;
    }

    public static List<File> internalListFiles(Context ctx, String startWith) {

        ArrayList<File> files = new ArrayList<File>();

        File dir = ctx.getFilesDir();
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

    /**
     * Read a text/html (String) file in raw folder.
     *
     * @param resourceID raw id. R.raw.*
     * @return
     */
    public static String readRawFile(Context context, int resourceID) {
        InputStream raw = context.getResources().openRawResource(resourceID);
        ByteArrayOutputStream stream = new ByteArrayOutputStream();
        int i;
        try {
            i = raw.read();
            while (i != -1) {
                stream.write(i);
                i = raw.read();
            }
            raw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return stream.toString();
    }

    /**
     * Read a data (byte[]) file in raw folder.
     *
     * @param resourceID raw id. R.raw.*
     * @return
     */
    public static byte[] getRawBytes(Context context, int resourceID) {
        InputStream raw = context.getResources().openRawResource(resourceID);
        ByteArrayOutputStream stream = new ByteArrayOutputStream();
        int i;
        try {
            i = raw.read();
            while (i != -1) {
                stream.write(i);
                i = raw.read();
            }
            raw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return stream.toByteArray();
    }

    public static void deleteInternalStorage(Context ctx) {
        deleteRecursive(ctx.getFilesDir().getParentFile());
    }

    public static void deleteRecursive(File fileOrDirectory) {
        if (fileOrDirectory == null)
            return;

        if (fileOrDirectory.isDirectory())
            for (File child : fileOrDirectory.listFiles())
                deleteRecursive(child);
        fileOrDirectory.delete();
    }
}
