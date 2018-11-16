package edu.upc.eetac.dsa;

import edu.upc.eetac.dsa.*;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.apache.log4j.Logger;

import javax.ws.rs.*;
import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/*@Api(value="/orders", description = "Endpoint to Order Service")
@Path("/orders")*/
public class BikeService {

    final static Logger log = Logger.getLogger(BikeService.class.getName());

    private MyBike mybike;

    public BikeService() {
        this.mybike = MyBikeImpl.getInstance();

    }
    @POST
    @Path("/adduser/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response addUser(@PathParam("id") String id, String name, String surname){
        mybike.addUser(id, name, surname);

        return Response.status(201).build();
    }


}
