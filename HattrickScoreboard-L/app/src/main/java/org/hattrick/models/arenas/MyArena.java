package org.hattrick.models.arenas;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Path;
import org.simpleframework.xml.Root;

/**
 * Supporters Only
 */
@Root(strict = false)
public class MyArena {

    @Element
    @Path("MyArena")
    int ArenaID;

    @Element
    @Path("MyArena")
    int NumberOfMatches;

    @Element(name = "Terraces")
    @Path("MyArena/VisitorsAverage")
    int AverageTerraces;

    @Element(name = "Basic")
    @Path("MyArena/VisitorsAverage")
    int AverageBasic;

    @Element(name = "Roof")
    @Path("MyArena/VisitorsAverage")
    int AverageRoof;

    @Element(name = "VIP")
    @Path("MyArena/VisitorsAverage")
    int AverageVIP;

    @Element(name = "Total")
    @Path("MyArena/VisitorsAverage")
    int AverageTotal;

    @Element(name = "Terraces")
    @Path("MyArena/VisitorsMost")
    int MostTerraces;

    @Element(name = "Basic")
    @Path("MyArena/VisitorsMost")
    int MostBasic;

    @Element(name = "Roof")
    @Path("MyArena/VisitorsMost")
    int MostRoof;

    @Element(name = "VIP")
    @Path("MyArena/VisitorsMost")
    int MostVIP;

    @Element(name = "Total")
    @Path("MyArena/VisitorsMost")
    int MostTotal;

    @Element(name = "Terraces")
    @Path("MyArena/VisitorsLeast")
    int LeastTerraces;

    @Element(name = "Basic")
    @Path("MyArena/VisitorsLeast")
    int LeastBasic;

    @Element(name = "Roof")
    @Path("MyArena/VisitorsLeast")
    int LeastRoof;

    @Element(name = "VIP")
    @Path("MyArena/VisitorsLeast")
    int LeastVIP;

    @Element(name = "Total")
    @Path("MyArena/VisitorsLeast")
    int LeastTotal;

    public int getArenaID() {
        return ArenaID;
    }

    public int getNumberOfMatches() {
        return NumberOfMatches;
    }

    public int getAverageTerraces() {
        return AverageTerraces;
    }

    public int getAverageBasic() {
        return AverageBasic;
    }

    public int getAverageRoof() {
        return AverageRoof;
    }

    public int getAverageVIP() {
        return AverageVIP;
    }

    public int getAverageTotal() {
        return AverageTotal;
    }

    public int getMostTerraces() {
        return MostTerraces;
    }

    public int getMostBasic() {
        return MostBasic;
    }

    public int getMostRoof() {
        return MostRoof;
    }

    public int getMostVIP() {
        return MostVIP;
    }

    public int getMostTotal() {
        return MostTotal;
    }

    public int getLeastTerraces() {
        return LeastTerraces;
    }

    public int getLeastBasic() {
        return LeastBasic;
    }

    public int getLeastRoof() {
        return LeastRoof;
    }

    public int getLeastVIP() {
        return LeastVIP;
    }

    public int getLeastTotal() {
        return LeastTotal;
    }
}
