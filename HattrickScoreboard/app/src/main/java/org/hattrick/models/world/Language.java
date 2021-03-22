package org.hattrick.models.world;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

@Root(strict = false)
public class Language {

    @Element
    int LanguageID;

    @Element
    String LanguageName;

    public int getLanguageID() {
        return LanguageID;
    }

    public String getLanguageName() {
        return LanguageName;
    }

}
