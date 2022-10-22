package com.crud.deportes.service;

import com.crud.deportes.dto.EquipoDto;
import com.crud.deportes.entity.Equipo;
import com.crud.deportes.utils.response.ApiResponse;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface EquipoService {
   Equipo crearEquipo(Equipo equipo);

    ResponseEntity<ApiResponse<EquipoDto>> obtenerEquipoPorId(Long id);
    List<Equipo> obtenerTodos();
    void eliminarEquipo(Long id);

    Equipo modificarEquipo(Equipo equipo);
}
