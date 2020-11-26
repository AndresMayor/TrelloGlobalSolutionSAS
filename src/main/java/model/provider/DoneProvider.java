package model.provider;

import db.MySQLConnection;
import entity.Doing;
import entity.Done;
import entity.ToDo;
import model.dto.DoingDTO;
import model.dto.DoneDTO;
import model.dto.ToDoDTO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class DoneProvider {





    public Done mapFromDTO(DoneDTO dto) {
        Done done = new Done();

        try {

            String myDate =dto.getFecha();
            SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
            Date date = sdf.parse(myDate);
            long millis = date.getTime();
            done.setDescripccion(dto.getDescripccion());
            done.setFecha(millis);

        } catch (ParseException e) {
            e.printStackTrace();
        }


        return done;
    }

    public DoneDTO mapFrom(Done done){

        Date date = new Date(done.getFecha());
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MM-yyyy");
        String dateactual = simpleDateFormat.format(date);
        DoneDTO doneDTO = new DoneDTO();
        doneDTO.setId(done.getId());
        doneDTO.setDescripccion(done.getDescripccion());
        doneDTO.setFecha(dateactual);

        return doneDTO;

    }


    public void insertTarea(Done done) {

        MySQLConnection conection = new MySQLConnection();
        String sql = "INSERT INTO doneJaimeMayor(descripccion,fecha) VALUES ('$descripccion','$fecha')";
        sql = sql.replace("$descripccion", done.getDescripccion());
        sql = sql.replace("$fecha", "" +done.getFecha());
        conection.executeSQL(sql);

    }

    public ArrayList<DoneDTO> getAllDone() {
        MySQLConnection conection = new MySQLConnection();
        ArrayList<DoneDTO> doneDTOS = new ArrayList<>();
        try{

            String sql = "SELECT id,descripccion,fecha FROM doneJaimeMayor";
            ResultSet resultSet=conection.query(sql);

            while (resultSet.next()){

                Done done = new Done(resultSet.getInt(1),resultSet.getString(2),resultSet.getLong(3));
                doneDTOS.add(mapFrom(done));
            }

        }catch (SQLException e){
            e.printStackTrace();
        }
        return  doneDTOS;

    }

    public boolean deleteDone(String id) {
        MySQLConnection connection = new MySQLConnection();
        String sql = "DELETE FROM doneJaimeMayor WHERE id=" + id;
        return connection.executeSQL(sql);
    }


}
