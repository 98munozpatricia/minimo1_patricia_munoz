package edu.upc.eetac.dsa;

import org.apache.log4j.Logger;

import java.util.*;

public class MyBikeImpl implements MyBike {

    private static MyBike instance;
    final static Logger log = Logger.getLogger(MyBikeImpl.class.getName());
    //Atributes
    private List<Stations> lstations;
    private LinkedList<Bike> lbikesstation;
    private HashMap<String, Users> usuarios;
    private LinkedList<Bike> lbikeuser;

    private MyBikeImpl(){
        lstations = new ArrayList<>();
        lbikesstation = new LinkedList<>();
        usuarios = new HashMap<>();
        lbikeuser = new LinkedList<>();
    }

    public static MyBike getInstance() {
        if(instance==null) instance = new MyBikeImpl();
        return instance;
    }


    public void addUser(String id, String name, String surname)
    {
        usuarios.put(id, new Users(id, name, surname));

    }

    public void addStation(String idStation, String description, int max, double lat, double lon)
    {
        Stations station = new Stations(idStation, description, max, lat, lon);
        lstations.add(station);
    }
    public void addBike(String idBike, String description, double kms, String idStation)
    {
        log.info("Bike: " + idBike);
        Bike bike= new Bike(idBike, description, kms, idStation);
        for(int x=0;x<lstations.size();x++) {
            if(lstations.get(x).idStation.equals(idStation)) {
                lstations.get(x).lbikes.add(bike);
                log.info("Station: " + lstations.get(x).idStation);
            }

        }


    }


    public List<Bike> bikesByStationOrderByKms(String idStation) throws StationNotFoundException {
        log.info("Lista bicis: " + lbikesstation);
        for(int x=0; x<lstations.size();x++)
        {
            if(lstations.get(x).idStation.equals(idStation))
            {
                lbikesstation=lstations.get(x).lbikes;

            }
            else
                throw new StationNotFoundException();
        }



        Collections.sort(lbikesstation, new Comparator<Bike>() {

            @Override
            public int compare(Bike bike1, Bike bike2) {
                return (-1)*((int)(bike1.GetKM()-bike2.GetKM()));
            }
        });
        log.info("Lista bicis: " + lbikesstation);
        return lbikesstation;
    }


    @Override
    public Bike getBike(String stationId, String userId) throws UserNotFoundException, StationNotFoundException {

        Bike b = lbikeuser.get(0);
        Users usuario = this.usuarios.get(userId);
        if(usuario!=null){
            log.info("User: " + usuario);
            for(int x=0;x<usuario.lbikes.size();x++) {
                if (usuario.lbikes.get(x).idStation.equals(stationId))
                {
                    log.info("Station: " + usuario.lbikes.get(x).idStation);
                    b=usuario.lbikes.get(x);

                }
                else {
                    throw new StationNotFoundException();

                }
                log.info("Bike: " +b);
            }

        }
        else {

            throw new UserNotFoundException();

        }
        log.info("Bike: " +b);
        return b;

    }

    @Override
    public List<Bike> bikesByUser(String userId) throws UserNotFoundException {
        log.info("Lista bicis: " + lbikeuser);
        lbikeuser= usuarios.get(userId).lbikes;
        log.info("Lista bicis: " + lbikesstation);
        return  lbikeuser;
    }

    @Override
    public int numUsers() {
        return usuarios.size();
    }

    @Override
    public int numStations() {
        log.info("Numero estaciones: " + lbikesstation.size());
        return lstations.size();

    }

    @Override
    public int numBikes(String idStation) throws StationNotFoundException {
        log.info("Bikes: " +lbikesstation.size());
        int i;
        for(int x=0;x<lstations.size();x++) {
            if (lstations.get(x).idStation.equals(idStation))
            {
                lbikesstation=lstations.get(x).lbikes;
                i=x;
                x=lstations.size();
            }
            else {
                throw new StationNotFoundException();

            }

        }
        log.info("Bikes: " +lbikesstation.size());
        return lbikesstation.size();
    }

    @Override
    public void clear() {

    }
}
