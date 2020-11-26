package services;
import model.dto.Response;
import model.dto.ToDoDTO;
import model.provider.ToDoProvider;
import javax.ejb.Stateless;
import javax.ws.rs.*;
import java.util.ArrayList;

@Path("toDo")
@Stateless
public class ToDoServices {

    @POST
    @Consumes("application/json")
    @Path("createTarea")
    public Response createTarea(ToDoDTO toDoDTO){
        ToDoProvider toDoProvider = new ToDoProvider();
        toDoProvider.insertToDo(toDoProvider.mapFromDTO(toDoDTO));
        return new Response("Operacion Exitosa");
    }


    @GET
    @Consumes("application/json")
    @Path("allToDo")
    @Produces("application/json")
    public ArrayList<ToDoDTO> getAllToDo(){
        ToDoProvider toDoProvider = new ToDoProvider();
        ArrayList<ToDoDTO> toDo = toDoProvider.getAllToDo();
        return toDo;
    }

    @DELETE
    @Produces("application/json")
    @Path("delete/{id}")
    public Response deleteToDobyID(@PathParam("id") String id ){
        ToDoProvider toDoProvider = new ToDoProvider();
        boolean success = toDoProvider.deleteToDo(id);
        if(success)return  new Response("operacion Exitosa");
        else return new Response("operacion fallida");
    }





}
