package com.isil.sesion1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class MainApp {

    public static void main(String[] args) throws Exception {

       Class.forName("com.mysql.cj.jdbc.Driver");

        Connection con = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/TESTD",
                "root",
                ""
        );

        Statement Stmt = con.createStatement();

        //int resultUpdate = Stmt.executeUpdate("update Users set phone='444444449' where name='Mesi'");
        ResultSet result = Stmt.executeQuery("select * from Users");

        while(result.next()){
            System.out.println(result.getString("idUser"));
            System.out.println(result.getString("name"));
            System.out.println(result.getString("phone"));
            System.out.println(result.getString("city"));
        }


    }


}
