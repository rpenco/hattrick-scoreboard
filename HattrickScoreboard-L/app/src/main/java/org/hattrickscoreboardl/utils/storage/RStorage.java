package org.hattrickscoreboardl.utils.storage;

import android.content.Context;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * Raw Storage Helper
 *
 * @author Khips
 * @since 19 mars 2014
 */
public class RStorage extends Storage {

    /**
     * Read a text/html (String) file in raw folder.
     *
     * @param resourceID raw id. R.raw.*
     * @return
     * @throws java.io.IOException
     */
    public static String readRawFile(Context ctx, int resourceID) throws IOException {
        return getRawBytes(ctx, resourceID).toString();
    }

    /**
     * Read a data (byte[]) file in raw folder.
     *
     * @param resourceID raw id. R.raw.*
     * @return
     * @throws java.io.IOException
     */
    public static byte[] getRawBytes(Context ctx, int resourceID)
            throws IOException {
        InputStream raw = ctx.getResources().openRawResource(resourceID);
        ByteArrayOutputStream stream = new ByteArrayOutputStream();
        int i;

        i = raw.read();
        while (i != -1) {
            stream.write(i);
            i = raw.read();
        }
        raw.close();

        return stream.toByteArray();
    }

}
