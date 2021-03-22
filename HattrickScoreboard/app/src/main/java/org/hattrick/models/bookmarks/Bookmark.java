package org.hattrick.models.bookmarks;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

@Root(strict = false)
public class Bookmark {

    @Element
    int BookmarkID;

    @Element
    int BookmarkTypeID;

    @Element
    String Text;

    @Element(required = false)
    String Text2;

    @Element
    int ObjectID;

    @Element(required = false)
    int ObjectID2;

    @Element(required = false)
    int ObjectID3;

    @Element(required = false)
    String Comment;

    public int getBookmarkID() {
        return BookmarkID;
    }

    public int getBookmarkTypeID() {
        return BookmarkTypeID;
    }

    public String getText() {
        return Text;
    }

    public String getText2() {
        return Text2;
    }

    public int getObjectID() {
        return ObjectID;
    }

    public int getObjectID2() {
        return ObjectID2;
    }

    public int getObjectID3() {
        return ObjectID3;
    }

    public String getComment() {
        return Comment;
    }

}
