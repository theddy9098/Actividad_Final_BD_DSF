package org.CRUD_BD.Domain.Entity;

import java.util.Date;

public class Minibus {

    private  String Placa;
    private String Capacidad;
    private String Estado;
    private String Kilometraje;
    private Date UltimoMantenimiento;

    public Minibus(String placa, String capacidad, String estado, String kilometraje, Date ultimoMantenimiento) {
        Placa = placa;
        Capacidad = capacidad;
        Estado = estado;
        Kilometraje = kilometraje;
        UltimoMantenimiento = ultimoMantenimiento;
    }

    public String getPlaca() {
        return Placa;
    }

    public void setPlaca(String placa) {
        Placa = placa;
    }
    public String getCapacidad() {
        return Capacidad;
    }
    public void setCapacidad(String capacidad) {
        Capacidad = capacidad;
    }
    public String getEstado() {
        return Estado;
    }
    public void setEstado(String estado) {
        Estado = estado;
    }
    public String getKilometraje() {
        return Kilometraje;
    }
    public void setKilometraje(String kilometraje) {
        Kilometraje = kilometraje;
    }
    public Date getUltimoMantenimiento() {
        return UltimoMantenimiento;
    }
    public void setUltimoMantenimiento(Date ultimoMantenimiento) {
        UltimoMantenimiento = ultimoMantenimiento;
    }
}
