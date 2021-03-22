package org.hattrick.providers;

import android.content.Context;
import android.util.Log;

import org.hattrick.chpp.CHPPResult;
import org.hattrick.providers.exceptions.CHPPException;
import org.hattrick.providers.exceptions.HParamsProcessException;
import org.hattrick.providers.exceptions.SerializerException;
import org.hattrick.providers.params.HattrickParams;
import org.hattrickscoreboard.background.providers.IParams;
import org.hattrickscoreboard.background.providers.IRequest;

import java.io.IOException;

/**
 * @author Khips
 * @since 28 march 2014
 */
public class HattrickRequest implements IRequest {

    static final String TAG = (HattrickRequest.class).getSimpleName();

    private HattrickParams params;
    private HattrickConnection connection;

    @Override
    public void setParams(IParams params) {
        this.params = (HattrickParams) params;
    }

    @Override
    public void init(Object obj) {
        connection = new HattrickConnection((Context) obj);
    }

    @SuppressWarnings("unchecked")
    @Override
    public <T> T get() throws IOException {

        try {
            // Do request
            connection.setParam(params);
            CHPPResult result = (CHPPResult) connection.get();
            Log.v(TAG, result.getBody());

            if (result != null) {
                // Error in params probably...
                if (result.getBody().contains(
                        "<FileName>chpperror.xml</FileName>")) {
                    throw new CHPPException(params.processParam());
                } else {

                    // Send to parser
                    T obj = (T) HattrickParser.parseFrom(
                            params.getResultClass(), result.getBody());
                    return obj;
                }
            }

        } catch (SerializerException e) {
            throw new IOException();
        } catch (CHPPException e) {
            throw new IOException();
        } catch (HParamsProcessException e) {
            throw new IOException();
        }
        return null;

    }
}
