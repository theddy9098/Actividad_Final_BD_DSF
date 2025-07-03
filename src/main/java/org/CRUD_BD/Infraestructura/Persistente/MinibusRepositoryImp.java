package org.CRUD_BD.Infraestructura.Persistente;

import org.CRUD_BD.Aplicacion.MinibusResitory;
import org.CRUD_BD.Domain.Entity.Minibus;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MinibusRepositoryImp implements MinibusResitory {

    private static final String URL = "jdbc:postgresql://localhost:5432/ruta_escolar";
    private static final String USUARIO = "Teddy_xyz";
    private static final String CONTRASENA = "1111";

    private Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USUARIO, CONTRASENA);
    }

    @Override
    public void insertarMinibus(Minibus minibus) throws SQLException {
        String sql = "INSERT INTO minibus (placa, capacidad, estado, kilometraje, ultimo_mantenimiento) VALUES (?, ?, ?, ?, ?)";
        try (Connection conn = getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, minibus.getPlaca());
            stmt.setString(2, minibus.getCapacidad());
            stmt.setString(3, minibus.getEstado());
            stmt.setString(4, minibus.getKilometraje());
            stmt.setDate(5, new java.sql.Date(minibus.getUltimoMantenimiento().getTime()));
            stmt.executeUpdate();
        }
    }

    @Override
    public List<Minibus> buscarMinibuses() throws SQLException {
        List<Minibus> lista = new ArrayList<>();
        String sql = "SELECT * FROM minibus";
        try (Connection conn = getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                Minibus m = new Minibus(
                    rs.getString("placa"),
                    rs.getString("capacidad"),
                    rs.getString("estado"),
                    rs.getString("kilometraje"),
                    rs.getDate("ultimo_mantenimiento")
                );
                lista.add(m);
            }
        }
        return lista;
    }

    @Override
    public void actualizarMinibus(Minibus minibus) throws SQLException {
        String sql = "UPDATE minibus SET capacidad = ?, estado = ?, kilometraje = ?, ultimo_mantenimiento = ? WHERE placa = ?";
        try (Connection conn = getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, minibus.getCapacidad());
            stmt.setString(2, minibus.getEstado());
            stmt.setString(3, minibus.getKilometraje());
            stmt.setDate(4, new java.sql.Date(minibus.getUltimoMantenimiento().getTime()));
            stmt.setString(5, minibus.getPlaca());
            stmt.executeUpdate();
        }
    }

    @Override
    public void eliminarMinibus(String placa) throws SQLException {
        String sql = "DELETE FROM minibus WHERE placa = ?";
        try (Connection conn = getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, placa);
            stmt.executeUpdate();
        }
    }
}




