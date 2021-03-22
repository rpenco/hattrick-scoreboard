package org.hattrick.models.avatar;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.Root;

import java.util.List;

@Root(strict = false, name = "Avatar")
public class Avatar {

    @Element
    private String BackgroundImage;

    @ElementList(inline = true, name = "Layer")
    private List<Layer> Layers;

    public String getBackgroundImage() {
        return BackgroundImage;
    }

    public List<Layer> getLayers() {
        return Layers;
    }


}
