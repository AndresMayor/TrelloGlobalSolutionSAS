package db;

import java.sql.*;

public class MySQLConnection {


    private Connection connection;


    public MySQLConnection() {

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

    }



    public void conect() {
        try {
            //"jdbc:mysql://localhost:3306/dbmovies", "root", ""
            //"jdbc:mysql://200.3.193.22:3306/P09728_1_11", "P09728_1_11", "ZCSaQGZU"
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/tareas", "root", "");

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

    }


    public boolean createDB() {
        boolean create = false;
        conect();
        try {
            Statement statement = connection.createStatement();
            statement.execute("CREATE TABLE IF NOT EXISTS toDoJaimeMayor(id INT PRIMARY KEY AUTO_INCREMENT ,descripccion VARCHAR (100),fecha decimal(50,0))");
            statement.execute("CREATE TABLE IF NOT EXISTS doingJaimeMayor(id INT PRIMARY KEY AUTO_INCREMENT ,descripccion VARCHAR (100),fecha decimal(50,0))");
            statement.execute("CREATE TABLE IF NOT EXISTS doneJaimeMayor(id INT PRIMARY KEY AUTO_INCREMENT ,descripccion VARCHAR (100),fecha decimal(50,0))");
            create = true;

        } catch (SQLException throwables) {
            throwables.printStackTrace();
            create = false;
        } finally {
            disconect();
        }
        return create;
    }


    public void disconect() {
        try {
            connection.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }



    //para realizar las acciones el CRUD De cada provedor
    public boolean executeSQL(String sql) {
        boolean success  = false;
        conect();
        try {
            Statement statement = connection.createStatement();
            statement.execute(sql);
            success = true;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            success= false;
        } finally {
            disconect();
        }

        return success;
    }

    public ResultSet query(String sql) {
        ResultSet output =null;
        conect();
        try {

            Statement statement = connection.createStatement();
            output = statement.executeQuery(sql);

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return output;
    }








}
