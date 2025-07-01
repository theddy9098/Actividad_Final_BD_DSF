package org.CRUD_BD.Infraestructura.Confi_BD;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion_BD {
    private static final String URL = "jdbc:postgresql://localhost:5432/ruta_escolar";
    private static final String USUARIO = "Teddy_xyz";
    private static final String CONTRASENA = "1111";

    public static Connection getConnection() {
        Connection connection = null;
        try {
            Class.forName("org.postgresql.Driver");
            connection = DriverManager.getConnection(URL, USUARIO, CONTRASENA);
        } catch (ClassNotFoundException | SQLException e) {
            System.err.println("Error al conectar a la base de datos: " + e.getMessage());
        }
        return connection;
    }
}
