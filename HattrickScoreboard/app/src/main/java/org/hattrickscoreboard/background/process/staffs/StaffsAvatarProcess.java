package org.hattrickscoreboard.background.process.staffs;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.util.Log;

import org.hattrick.constants.Hattrick;
import org.hattrick.models.avatar.Avatar;
import org.hattrick.models.avatar.Layer;
import org.hattrick.models.avatar.StaffAvatar;
import org.hattrick.models.avatar.StaffsAvatar;
import org.hattrick.providers.params.HQuery;
import org.hattrickscoreboard.application.utils.graphics.statics.ImageToFile;
import org.hattrickscoreboard.background.constant.Background;
import org.hattrickscoreboard.background.process.HProcess;
import org.hattrickscoreboard.background.providers.IParams;
import org.hattrickscoreboard.background.providers.IRequest;

import java.io.File;
import java.io.IOException;

/**
 * Direct download object without save into database or other, used by
 * AvatarTask for exemple.
 *
 * @author Khips
 * @since 7 aot 2014
 */
public class StaffsAvatarProcess extends HProcess {

    static final String TAG = (StaffsAvatarProcess.class).getSimpleName();

    public void perform(IRequest request, IParams params) {
        super.perform();

        HQuery obj = (HQuery) params.getObjectParam();

        params.setResultClass(StaffsAvatar.class);

        // Do request
        request.setParams(params);

        StaffsAvatar res;

        // Get file
        try {
            res = request.get();
        } catch (IOException e) {
            e.printStackTrace();
            fireError(Background.RESULT_ERROR_CONN);
            return;
        }

        // Foreach player
        for (StaffAvatar player : res.getStaff()) {

            /**
             * How to work: - if avatar exist -> continue; - else create avatar:
             * - if background exist -> use it - else download, use and save
             * background - foreach layout (part of avatar): - same work like
             * background, if exist use else download, use and save
             */

            // Set directories
            File dirAvatar = setUpCacheDir("avatars");
            File dirLayer = setUpCacheDir("layers");

            // For custom dress
            File dirKits = setUpCacheDir("kits");

            // Avatar name
            // TODO get creation time to know if need update?
            String filename = "staff_" + player.getStaffID() + ".png";

            // If exist -> continue
            Bitmap fileCache = fileExistInCache(dirAvatar, filename);
            if (fileCache != null) {
                Log.i(TAG, filename + " return from cache.");
                continue;
            }

            // Create avatar

            // Avatar infos
            Avatar avatar = player.getAvatar();

            Log.i(TAG, "======" + player.getStaffID() + "=");

            // Prepare bitmap and create canvas to draw in
            Bitmap bm = Bitmap.createBitmap(110, 155, Config.ARGB_8888);
            Canvas canvas = new Canvas(bm);

            // Get name of background layer
            int indexOf = avatar.getBackgroundImage().lastIndexOf('/');
            String bgname = avatar.getBackgroundImage().substring(indexOf + 1);

            // If background exist -> use-it
            Bitmap bg = fileExistInCache(dirLayer, bgname);
            if (bg != null) {
                Log.i(TAG, "background: '" + filename + "' from cache.");

            } else {

                // Download
                ImageToFile.inputStreamToFile(
                        Hattrick.URL + avatar.getBackgroundImage(), dirLayer
                                + "/" + bgname);

                bg = fileExistInCache(dirLayer, bgname);
                if (bg != null) {
                    Log.i(TAG, "background: '" + filename
                            + "' from download cache.");
                }
            }

            // Draw background
            canvas.drawBitmap(bg, 0, 0, null);

            // Now get layers
            for (Layer layer : avatar.getLayers()) {

                Log.i(TAG, "Layer: x " + layer.getX() + " y:" + layer.getY()
                        + " img: " + layer.getImage());

                // Filtering images

                // no number
                if (layer.getImage().contains("numbers")) {
                    continue;
                }

                // No transfer, card, injury...
                if (layer.getImage().contains("misc"))
                    continue;

                indexOf = layer.getImage().lastIndexOf('/');
                String layername = layer.getImage().substring(indexOf + 1);

                boolean customKit = (layer.getImage()
                        .contains("res.hattrick.org")) ? true : false;

                Bitmap ly = null;
                if (customKit) {
                    ly = fileExistInCache(dirKits, "kit_" + obj.getTeamID()
                            + "_" + layername);
                } else {
                    ly = fileExistInCache(dirLayer, layername);
                }

                if (ly != null) {
                    Log.i(TAG, "layer: '" + layername + "' from cache.");

                } else {

                    // Download
                    if (customKit) {
                        ImageToFile.inputStreamToFile(layer.getImage(), dirKits
                                + "/kit_" + obj.getTeamID() + "_" + layername);
                        ly = fileExistInCache(dirKits, "kit_" + obj.getTeamID()
                                + "_" + layername);
                    } else {
                        ImageToFile.inputStreamToFile(
                                Hattrick.URL + layer.getImage(), dirLayer + "/"
                                        + layername);
                        ly = fileExistInCache(dirLayer, layername);
                    }

                    if (ly != null) {
                        Log.i(TAG, "layer: '" + layername
                                + "' from download cache.");
                    }
                }

                // Draw layer
                if (ly != null && layer != null) {
                    canvas.drawBitmap(ly, layer.getX(), layer.getY(), null);
                }
            }

            // Save avatar
            ImageToFile.bitmapToFile(bm, dirAvatar + "/" + filename);

        }

        fireSuccess();

    }

    /**
     * Create (if not exist) and return path to Cache folder
     *
     * @param subfolder
     * @return
     */
    protected File setUpCacheDir(String subfolder) {

        if (context != null) {
            if (context.getCacheDir() != null) {
                File myDir = new File(context.getCacheDir(), subfolder);
                myDir.mkdir();
                return myDir;
            }
        }
        return null;
    }

    /**
     * Check if file exist in cache folder
     *
     * @param dir
     * @param filename
     * @return
     */
    protected Bitmap fileExistInCache(File dir, String filename) {
        // S'il existe return
        File f = new File(dir, filename);
        if (f.exists()) {
            Log.v(TAG, "Return file \"" + filename + "\" from cache.");
            Bitmap bm = BitmapFactory.decodeFile(f.getAbsolutePath());
            return bm;
        }
        return null;

    }
}
