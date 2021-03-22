package org.hattrick.models.world;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.Root;

import java.util.ArrayList;

@Root(name = "HattrickData", strict = false)
public class WorldLanguage {

    @Element
    String FileName;

    @ElementList
    ArrayList<Language> LanguageList;

    public String getFileName() {
        return FileName;
    }

    public ArrayList<Language> getLanguageList() {
        return LanguageList;
    }


}
