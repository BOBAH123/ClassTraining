package com.company;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;


public class DatabaseHandler extends Configs {
    Connection dbConnection;

    public Connection getDbConnection() throws ClassNotFoundException, SQLException{
        String connectionString = "jdbc:mysql://" + dbHost + ":" + dbPort + "/" + dbName + "?useUnicode=true&serverTimezone=UTC";


        //Class.forName("com.mysql.cj.jdbc.Driver");
        dbConnection = DriverManager.getConnection(connectionString, dbUser, dbPass);


        return dbConnection;
    }
    public void signUpUser(Home home) {
        String insert = "INSERT INTO " + Const.USER_TABLE + "(" + Const.USER_TYPE + "," + Const.USER_SQWARE + "," + Const.USER_ADRESS +
                "," + Const.USER_NUMBEROFLIVERS + "," + Const.USER_OWNERNAME + ")" + "VALUES(?,?,?,?,?)";
        try {
            PreparedStatement prSt = getDbConnection().prepareStatement(insert);
            prSt.setString(1, home.getType());
            prSt.setDouble(2, home.getSqware());
            prSt.setString(3, home.getAdress());
            prSt.setInt(4, home.getNumberOfLivers());
            prSt.setString(5, home.getOwnerName());
            prSt.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

    }
    public void deleteUser(Home home) {
        String delete = "DELETE FROM " + Const.USER_TABLE + " WHERE " + Const.USER_OWNERNAME + " = ?";
        try {
            PreparedStatement prSt = getDbConnection().prepareStatement(delete);
            prSt.setString(1, home.getOwnerName());
            prSt.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

    }
    public ResultSet getInfo(Home home) {
        ResultSet resSet = null;
        ResultSet res = null;

        String select = "SELECT * FROM " + Const.USER_TABLE + " WHERE " + Const.USER_OWNERNAME + "=?";

        try {
            PreparedStatement prSt = getDbConnection().prepareStatement(select);
            prSt.setString(1, home.getOwnerName());

            resSet = prSt.executeQuery();
            res = resSet;
            while (res.next()){
                System.out.println("Owner: "+res.getString(6));
                System.out.println("ID: "+res.getInt(1));
                System.out.println("Type: "+res.getString(2));
                System.out.println("Sqware: "+res.getDouble(3));
                System.out.println("Adress: "+res.getString(4));
                System.out.println("Number of livers: "+res.getInt(5));
                System.out.println();
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        return resSet;
    }
}

