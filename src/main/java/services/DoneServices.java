package services;


import model.dto.DoneDTO;
import model.dto.Response;
import model.dto.ToDoDTO;
import model.provider.DoneProvider;
import model.provider.ToDoProvider;

import javax.ejb.Stateless;
import javax.ws.rs.*;
import java.util.ArrayList;

@Stateless
@Path("done")
public class DoneServices {

    @POST
    @Consumes("application/json")
    @Path("create")
    public Response createTarea(DoneDTO doneDTO){
        DoneProvider doneProvider = new DoneProvider();
        doneProvider.insertTarea(doneProvider.mapFromDTO(doneDTO));
        return new Response("Operacion Exitosa");
    }

    @GET
    @Consumes("application/json")
    @Path("allDone")
    @Produces("application/json")
    public ArrayList<DoneDTO> getAllDone(){
        DoneProvider doneProvider = new DoneProvider();
        ArrayList<DoneDTO> done = doneProvider.getAllDone();
        return done;
    }


    @DELETE
    @Produces("application/json")
    @Path("delete/{id}")
    public Response deleteDoneID(@PathParam("id") String id ){
        DoneProvider doneProvider = new DoneProvider();
        boolean success = doneProvider.deleteDone(id);
        if(success)return  new Response("operacion Exitosa");
        else return new Response("operacion fallida");
    }
}
