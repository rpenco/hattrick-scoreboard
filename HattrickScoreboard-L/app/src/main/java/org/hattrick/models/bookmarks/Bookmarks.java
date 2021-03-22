package org.hattrick.models.bookmarks;

import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.Root;

import java.util.List;

@Root(strict = false)
public class Bookmarks {

    @ElementList
    List<Bookmark> BookmarkList;

    public List<Bookmark> getBookmarkList() {
        return BookmarkList;
    }

}
