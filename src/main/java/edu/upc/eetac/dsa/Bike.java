package edu.upc.eetac.dsa;

public class Bike {
    String idBike;
    String description;
    double kms;
    String idStation;

    public Bike(String idBike, String description, double kms, String idStation)
    {
        this.idBike=idBike;
        this.description=description;
        this.kms=kms;
        this.idStation=idStation;

    }
    public double GetKM()
    {
        return kms;
    }
    public String getBikeId()
    {
        return idBike;
    }
    public double getKms()
    {
        return kms;
    }
}

