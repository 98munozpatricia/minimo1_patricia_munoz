package edu.upc.eetac.dsa;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Users {
    String id;
    String name;
    String surname;
    public LinkedList<Bike> lbikes = new LinkedList<>();

    public Users(String id, String name, String surname)
    {
        this.id= id;
        this.name=name;
        this.surname=surname;

    }
    public List<Bike> getBikesUser()
    {
        return lbikes;
    }
}
