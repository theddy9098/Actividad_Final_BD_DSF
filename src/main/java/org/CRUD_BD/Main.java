package org.CRUD_BD;

import org.CRUD_BD.Infraestructura.Confi_BD.Conexion_BD;

import java.sql.Connection;



public class Main {
    public static void main(String[] args) {
            Connection conexion = Conexion_BD.getConnection();
            if (conexion != null) {
                System.out.println("¡Conexión exitosa a la base de datos!");
            } else {
                System.out.println("No se pudo conectar a la base de datos.");
            }
        }
}