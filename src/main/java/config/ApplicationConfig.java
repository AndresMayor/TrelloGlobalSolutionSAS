package config;


import entity.Doing;
import services.CreateDBServices;
import services.DoingServices;
import services.DoneServices;
import services.ToDoServices;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;
import java.util.HashSet;
import java.util.Set;

@ApplicationPath("api")
public class ApplicationConfig extends Application {


    //metodo para agregar cada servicio
    @Override
    public Set<Class<?>> getClasses() {

        Set<Class<?>> resources = new HashSet<>();
        resources.add(CreateDBServices.class);
        resources.add(DoneServices.class);
        resources.add(DoingServices.class);
        resources.add(ToDoServices.class);
        //clases de nuestros recursos


        return  resources;
    }
}
