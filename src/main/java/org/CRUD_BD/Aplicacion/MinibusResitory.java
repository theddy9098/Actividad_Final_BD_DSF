package org.CRUD_BD.Aplicacion;

import org.CRUD_BD.Domain.Entity.Minibus;

import java.sql.SQLException;
import java.util.List;

public interface MinibusResitory {

    void insertarMinibus(Minibus minibus) throws SQLException;

    List<Minibus> buscarMinibuses() throws SQLException;

    void actualizarMinibus(Minibus minibus) throws SQLException;

    void eliminarMinibus(String placa) throws SQLException;
}
