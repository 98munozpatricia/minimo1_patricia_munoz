package edu.upc.eetac.dsa;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Stations {
    String idStation;
    String description;
    int max;
    double latitud;
    double longitud;
    public LinkedList<Bike> lbikes = new LinkedList<>();
    public Stations(String idStation, String description, int max, double lat, double lon)
    {
        this.idStation=idStation;
        this.description=description;
        this.max=max;
        this.latitud=lat;
        this.longitud=lon;
    }
    public List<Bike> getBikesStatioin()
    {
        return lbikes;
    }
}
