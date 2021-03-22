package org.hattrick.models.avatars;

import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

@Root(strict = false, name = "Layer")
public class Layer {

    @Attribute
    private int x;

    @Attribute
    private int y;

    @Element
    private String Image;

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public String getImage() {
        return Image;
    }

}
