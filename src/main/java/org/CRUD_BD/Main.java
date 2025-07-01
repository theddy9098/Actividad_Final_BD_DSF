package org.CRUD_BD;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        // Parámetros de conexión
            String url = "jdbc:postgresql://localhost:5432/crud_bd";
            String usuario = "Teddy_xyz";
            String password = "1111";

            try {
                // Intentar establecer la conexión
                Connection conexion = DriverManager.getConnection(url, usuario, password);
                System.out.println("¡Conexión exitosa a la base de datos!");



            } catch (SQLException e) {
                System.out.println("Error al conectar a la base de datos");
                e.printStackTrace();
            }
        }
}