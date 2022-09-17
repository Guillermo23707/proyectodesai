package com.isil.sesion1;

import javax.print.attribute.standard.ReferenceUriSchemesSupported;
import java.sql.*;

public class MainApp {

    public static void main(String[] args) throws Exception {

        //1. Cargar driver
       Class.forName("com.mysql.cj.jdbc.Driver");

       //2. Crear conexion
        Connection con = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/TESTD",
                "root",
                ""
        );

        //3. Crear statement
        //3.1 Statement mantenimiento
        Statement stCreate = con.createStatement();
        int filasAfectadas=
                stCreate.executeUpdate("update Users set name='Juan' where idUser=1");
        System.out.println("Filas afectadas:" + filasAfectadas);

        // 3.2 Statement consulta
        PreparedStatement preparedStatement =
             con.prepareStatement("select * from Users where idUser=? ");

        preparedStatement.setInt(1,1);

        //4. Ejecutar query
        ResultSet resultSet2 = preparedStatement.executeQuery();

        //5. Recorrer Resultados
        while(resultSet2.next()){
            System.out.println(resultSet2.getString("name") + "\n"+
                    resultSet2.getString("phone") + "\n"+
                   resultSet2.getString("city"));
        }

        //6. Cerrar conexion
        con.close();
    }


}
