package model.provider;

import db.MySQLConnection;
import entity.Done;
import entity.ToDo;
import model.dto.DoneDTO;
import model.dto.ToDoDTO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class ToDoProvider {



    public ToDo mapFromDTO(ToDoDTO dto) {
        Date date = new Date();
        ToDo toDo = new ToDo();
        toDo.setFecha(date.getTime());
        toDo.setDescripccion(dto.getDescripccion());
        return toDo;
    }
    public ToDoDTO mapFrom(ToDo toDo){

        Date date = new Date(toDo.getFecha());
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MM-yyyy");
        String dateactual = simpleDateFormat.format(date);
        ToDoDTO toDoDTO = new ToDoDTO();
        toDoDTO.setFecha(dateactual);
        toDoDTO.setDescripccion(toDo.getDescripccion());
        toDoDTO.setId(toDo.getId());

        return toDoDTO;

    }

    public void insertToDo(ToDo toDo) {
        MySQLConnection conection = new MySQLConnection();
        String sql = "INSERT INTO toDoJaimeMayor(descripccion,fecha) VALUES ('$descripccion','$fecha')";
        sql = sql.replace("$descripccion", toDo.getDescripccion());
        sql = sql.replace("$fecha", "" +toDo.getFecha());
        conection.executeSQL(sql);
    }


    public ArrayList<ToDoDTO> getAllToDo() {
        MySQLConnection conection = new MySQLConnection();
        ArrayList<ToDoDTO> toDoDTOS = new ArrayList<>();
        try{

            String sql = "SELECT id,descripccion,fecha FROM toDoJaimeMayor";
            ResultSet resultSet=conection.query(sql);

            while (resultSet.next()){

                ToDo toDo = new ToDo(resultSet.getInt(1),resultSet.getString(2),resultSet.getLong(3));
                toDoDTOS.add(mapFrom(toDo));
            }

        }catch (SQLException e){
            e.printStackTrace();
        }
    return  toDoDTOS;
    }

    public boolean deleteToDo(String id) {
        MySQLConnection connection = new MySQLConnection();
        String sql = "DELETE FROM toDoJaimeMayor WHERE id=" + id;
        return connection.executeSQL(sql);
    }
}
