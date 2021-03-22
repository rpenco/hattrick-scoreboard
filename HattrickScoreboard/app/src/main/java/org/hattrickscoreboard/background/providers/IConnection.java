package org.hattrickscoreboard.background.providers;

import java.io.IOException;

public interface IConnection {

    Object get() throws IOException;

    public void setParam(IParams params);
}
