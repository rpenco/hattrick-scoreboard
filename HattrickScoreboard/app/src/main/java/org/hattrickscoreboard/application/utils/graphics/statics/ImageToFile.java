package org.hattrickscoreboard.application.utils.graphics.statics;

import android.graphics.Bitmap;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * Image from URL to file and input stream
 *
 * @author Khips
 * @since 7 august 2014
 */
public class ImageToFile {

    /**
     * Save image from URL to file
     *
     * @param inPath  path to the image
     * @param outPath directory and filename to save file
     */
    public static void inputStreamToFile(String inPath, String outPath) {
        InputStream inputStream = null;
        OutputStream outputStream = null;

        try {
            // read this file into InputStream
            inputStream = new java.net.URL(inPath).openStream();

            // write the inputStream to a FileOutputStream
            outputStream = new FileOutputStream(new File(outPath));

            int read = 0;
            byte[] bytes = new byte[1024];

            while ((read = inputStream.read(bytes)) != -1) {
                outputStream.write(bytes, 0, read);
            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (outputStream != null) {
                try {
                    // outputStream.flush();
                    outputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }
        }
    }

    /**
     * Save InputStream to file
     *
     * @param inputStream input (raw data)
     * @param outPath     directory and filename to save file
     */
    public static void inputStreamToFile(InputStream inputStream, String outPath) {

        OutputStream outputStream = null;

        try {
            // read this file into InputStream

            // write the inputStream to a FileOutputStream
            outputStream = new FileOutputStream(new File(outPath));

            int read = 0;
            byte[] bytes = new byte[1024];

            while ((read = inputStream.read(bytes)) != -1) {
                outputStream.write(bytes, 0, read);
            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (outputStream != null) {
                try {
                    // outputStream.flush();
                    outputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }
        }
    }

    /**
     * Save bitmap to file
     *
     * @param bm
     * @param path
     */
    public static void bitmapToFile(Bitmap bm, String path) {
        try {
            File file = new File(path);
            FileOutputStream out = new FileOutputStream(file);
            bm.compress(Bitmap.CompressFormat.PNG, 90, out);
            out.close();
        } catch (IOException e) {
            e.printStackTrace();

        }
    }
}
