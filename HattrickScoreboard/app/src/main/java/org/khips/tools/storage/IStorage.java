package org.khips.tools.storage;

import android.content.Context;

import org.khips.tools.KStorage;

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
 * @since 19 march 2014
 */
public class IStorage extends KStorage {



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
