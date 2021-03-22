package org.hattrick.models.ladders;

import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.Root;

import java.util.ArrayList;

/**
 * Created by romain on 30/10/2014.
 * ERROR ON CHPP API !! NOT WORKING
 */
@Root(strict = false)
public class Ladders {

    @ElementList(inline = true)
    ArrayList<Ladder> Ladders;

}
