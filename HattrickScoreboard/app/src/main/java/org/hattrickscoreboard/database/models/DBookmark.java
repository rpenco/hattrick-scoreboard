package org.hattrickscoreboard.database.models;

public class DBookmark extends DModel {

    long _id;
    int BookmarkID;
    int BookmarkTypeID;
    String Text;
    String Text2;
    int ObjectID;
    int ObjectID2;
    int ObjectID3;
    String Comment;

    public long getId() {
        return _id;
    }

    public void setId(long _id) {
        this._id = _id;
    }

    public int getBookmarkID() {
        return BookmarkID;
    }

    public void setBookmarkID(int bookmarkID) {
        BookmarkID = bookmarkID;
    }

    public int getBookmarkTypeID() {
        return BookmarkTypeID;
    }

    public void setBookmarkTypeID(int bookmarkTypeID) {
        BookmarkTypeID = bookmarkTypeID;
    }

    public String getText() {
        return Text;
    }

    public void setText(String text) {
        Text = text;
    }

    public String getText2() {
        return Text2;
    }

    public void setText2(String text2) {
        Text2 = text2;
    }

    public int getObjectID() {
        return ObjectID;
    }

    public void setObjectID(int objectID) {
        ObjectID = objectID;
    }

    public int getObjectID2() {
        return ObjectID2;
    }

    public void setObjectID2(int objectID2) {
        ObjectID2 = objectID2;
    }

    public int getObjectID3() {
        return ObjectID3;
    }

    public void setObjectID3(int objectID3) {
        ObjectID3 = objectID3;
    }

    public String getComment() {
        return Comment;
    }

    public void setComment(String comment) {
        Comment = comment;
    }

}
