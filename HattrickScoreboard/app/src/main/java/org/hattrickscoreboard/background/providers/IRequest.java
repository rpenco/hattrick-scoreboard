package org.hattrickscoreboard.background.providers;

import java.io.IOException;

public interface IRequest {

    void setParams(IParams params);

    void init(Object obj);

    <T> T get() throws IOException;

}
