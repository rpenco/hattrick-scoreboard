package org.hattrick.models.alliances;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.Root;

import java.util.ArrayList;

@Root(strict = false)
public class Alliances {

    @Element
    int Pages;

    @Element
    int PageIndex;

    @ElementList
    ArrayList<Alliance> Alliances;

    public ArrayList<Alliance> getAlliances() {
        return (Alliances.size() == 0)? null:Alliances;
    }

    public int getPages() {
        return Pages;
    }

    public int getPageIndex(){
        return PageIndex;
    }

}
