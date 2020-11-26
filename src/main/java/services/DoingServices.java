package services;


import entity.Doing;
import model.dto.DoingDTO;
import model.dto.DoneDTO;
import model.dto.Response;
import model.provider.DoingProvider;
import model.provider.DoneProvider;
import model.provider.ToDoProvider;

import javax.ejb.Stateless;
import javax.ws.rs.*;
import java.util.ArrayList;

@Stateless
@Path("Doing")
public class DoingServices {


    @POST
    @Consumes("application/json")
    @Path("create")
    public Response createTarea(DoingDTO doingDTO){
        DoingProvider doingProvider = new DoingProvider();
        doingProvider.insertTarea(doingProvider.mapFromDTO(doingDTO));
        return new Response("Operacion Exitosa");
    }

    @GET
    @Consumes("application/json")
    @Path("allDoing")
    @Produces("application/json")
    public ArrayList<DoingDTO> getAllDone(){
        DoingProvider doingProvider = new DoingProvider();
        ArrayList<DoingDTO> doingDTOS = doingProvider.getAllDoing();
        return doingDTOS;
    }

    @DELETE
    @Produces("application/json")
    @Path("delete/{id}")
    public Response deleteToDobyID(@PathParam("id") String id ){
        DoingProvider doingProvider = new DoingProvider();
        boolean success = doingProvider.deleteDoing(id);
        if(success)return  new Response("operacion Exitosa");
        else return new Response("operacion fallida");
    }




}
