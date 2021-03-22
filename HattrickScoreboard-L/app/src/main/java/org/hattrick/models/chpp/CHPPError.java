package org.hattrick.models.chpp;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

/**
 * Created by romain
 * on 02/11/2014.
 */
@Root(strict = false)
public class CHPPError {

    @Element
    String FileName;

    @Element
    String Version;
    @Element
    int UserID;

    @Element
    String FetchedDate;

    @Element
    String Error;

    @Element
    int ErrorCode;

    @Element
    String ErrorGUID;

    @Element
    String Server;

    @Element
    String Request;

    public String getFileName() {
        return FileName;
    }

    public String getVersion() {
        return Version;
    }

    public int getUserID() {
        return UserID;
    }

    public String getFetchedDate() {
        return FetchedDate;
    }

    public String getError() {
        return Error;
    }

    public int getErrorCode() {
        return ErrorCode;
    }

    public String getErrorGUID() {
        return ErrorGUID;
    }

    public String getServer() {
        return Server;
    }

    public String getRequest() {
        return Request;
    }
}
