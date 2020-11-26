package model.provider;

import db.MySQLConnection;
import entity.Doing;
import entity.Done;
import model.dto.DoingDTO;
import model.dto.DoneDTO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class DoingProvider {

    public Doing mapFromDTO(DoingDTO dto) {
        Doing doing = new Doing();

        try {

            String myDate =dto.getFecha();
            SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
            Date date = sdf.parse(myDate);
            long millis = date.getTime();
            doing.setDescripccion(dto.getDescripccion());
            doing.setFecha(millis);

        } catch (ParseException e) {
            e.printStackTrace();
        }


        return doing;
    }


    public DoingDTO mapFrom(Doing doing){

        Date date = new Date(doing.getFecha());
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MM-yyyy");
        String dateactual = simpleDateFormat.format(date);
        DoingDTO doingDTO = new DoingDTO();
        doingDTO.setId(doing.getId());
        doingDTO.setDescripccion(doing.getDescripccion());
        doingDTO.setFecha(dateactual);

        return doingDTO;

    }

    public void insertTarea(Doing doing) {
        MySQLConnection conection = new MySQLConnection();
        String sql = "INSERT INTO doingJaimeMayor(descripccion,fecha) VALUES ('$descripccion','$fecha')";
        sql = sql.replace("$descripccion", doing.getDescripccion());
        sql = sql.replace("$fecha", "" +doing.getFecha());
        conection.executeSQL(sql);
    }

    public ArrayList<DoingDTO> getAllDoing() {

        MySQLConnection conection = new MySQLConnection();
        ArrayList<DoingDTO> doingDTOS = new ArrayList<>();
        try{

            String sql = "SELECT id,descripccion,fecha FROM doingJaimeMayor";
            ResultSet resultSet=conection.query(sql);

            while (resultSet.next()){

                Doing done = new Doing(resultSet.getInt(1),resultSet.getString(2),resultSet.getLong(3));
                doingDTOS.add(mapFrom(done));
            }

        }catch (SQLException e){
            e.printStackTrace();
        }
        return  doingDTOS;
    }

    public boolean deleteDoing(String id) {
        MySQLConnection connection = new MySQLConnection();
        String sql = "DELETE FROM doingJaimeMayor WHERE id=" + id;
        return connection.executeSQL(sql);
    }


}
