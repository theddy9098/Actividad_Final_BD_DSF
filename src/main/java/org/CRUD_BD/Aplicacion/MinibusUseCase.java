package org.CRUD_BD.Aplicacion;

import org.CRUD_BD.Domain.Entity.Minibus;

import java.sql.SQLException;
import java.util.List;

public interface MinibusUseCase {

    void insertarMinibus(Minibus minibus) throws SQLException;

   Minibus buscarMinibus(String placa) throws SQLException;

    void actualizarMinibus(Minibus minibus) throws SQLException;

    void eliminarMinibus(String placa) throws SQLException;
}
