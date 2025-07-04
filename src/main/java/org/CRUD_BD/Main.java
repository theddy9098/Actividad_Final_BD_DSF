package org.CRUD_BD;

import org.CRUD_BD.Domain.Entity.Minibus;
import org.CRUD_BD.Infraestructura.Persistente.MinibusRepositoryImp;

import java.sql.SQLException;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        MinibusRepositoryImp repo = new MinibusRepositoryImp();
        Scanner sc = new Scanner(System.in);
        int opcion;

        do {
            System.out.println("\n--- CRUD Minibus ---");
            System.out.println("1. Insertar minibus");
            System.out.println("2. Buscar minibus por placa");
            System.out.println("3. Actualizar minibus");
            System.out.println("4. Eliminar minibus");
            System.out.println("0. Salir");
            System.out.print("Opción: ");
            opcion = sc.nextInt();
            sc.nextLine();

            try {
                switch (opcion) {
                    case 1:
                        System.out.print("Placa: ");
                        String placa = sc.nextLine();
                        System.out.print("Capacidad: ");
                        String capacidad = sc.nextLine();
                        System.out.print("Estado: ");
                        String estado = sc.nextLine();
                        System.out.print("Kilometraje: ");
                        String kilometraje = sc.nextLine();
                        Date hoy = new Date();
                        Minibus nuevo = new Minibus(placa, capacidad, estado, kilometraje, new java.sql.Date(hoy.getTime()));
                        repo.insertarMinibus(nuevo);
                        System.out.println("Minibus insertado.");
                        break;
                    case 2:
                        System.out.print("Placa a buscar: ");
                        placa = sc.nextLine();
                        Minibus buscado = repo.buscarMinibus(placa);
                        if (buscado != null) {
                            System.out.println(buscado);
                        } else {
                            System.out.println("No encontrado.");
                        }
                        break;
                    case 3:
                        System.out.print("Placa a actualizar: ");
                        placa = sc.nextLine();
                        Minibus actualizar = repo.buscarMinibus(placa);
                        if (actualizar != null) {
                            System.out.print("Nueva capacidad: ");
                            actualizar.setCapacidad(sc.nextLine());
                            System.out.print("Nuevo estado: ");
                            actualizar.setEstado(sc.nextLine());
                            System.out.print("Nuevo kilometraje: ");
                            actualizar.setKilometraje(sc.nextLine());
                            actualizar.setUltimoMantenimiento(new java.sql.Date(new Date().getTime()));
                            repo.actualizarMinibus(actualizar);
                            System.out.println("Minibus actualizado.");
                        } else {
                            System.out.println("No encontrado.");
                        }
                        break;
                    case 4:
                        System.out.print("Placa a eliminar: ");
                        placa = sc.nextLine();
                        repo.eliminarMinibus(placa);
                        System.out.println("Minibus eliminado.");
                        break;

                }
            } catch (SQLException e) {
                System.out.println("Error: " + e.getMessage());
            }
        } while (opcion != 0);

        sc.close();
    }
}