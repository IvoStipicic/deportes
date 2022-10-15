package com.crud.deportes.service;

import com.crud.deportes.entity.Equipo;

import java.util.ArrayList;
import java.util.List;

public interface EquipoService {
    Equipo crearEquipo(Equipo equipo);

    Equipo obtenerEquipoPorId(Long id);
    List<Equipo> obtenerTodos();
    void eliminarEquipo(Long id);

    Equipo modificarEquipo(Equipo equipo);
}
