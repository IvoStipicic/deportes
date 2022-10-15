package com.crud.deportes.controller;

import com.crud.deportes.entity.Equipo;
import com.crud.deportes.service.EquipoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class EquipoController {

    @Autowired
    EquipoService equipoService;

    @PostMapping("/equipo/crear")
    public Equipo crearEquipo(@RequestBody Equipo equipo){
        return equipoService.crearEquipo(equipo);
    }

    @GetMapping("/equipos")
    public List<Equipo> obtenerEquipos(){
        return equipoService.obtenerTodos();
    }

    @GetMapping("/equipo/{id}")
    public Equipo obtenerEquipos(@PathVariable Long id){
        return equipoService.obtenerEquipoPorId(id);
    }

    @DeleteMapping("/equipo/eliminar/{id}")
    public void eliminarEquipoPorID(@PathVariable Long id){
        equipoService.eliminarEquipo(id);
    }

    @PutMapping("/equipo/actualizar")
    public Equipo modificarEquipo(@RequestBody Equipo equipo){
        return equipoService.modificarEquipo(equipo);
    }

}
