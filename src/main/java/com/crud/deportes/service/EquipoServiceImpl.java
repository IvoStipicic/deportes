package com.crud.deportes.service;

import com.crud.deportes.entity.Equipo;
import com.crud.deportes.repository.EquipoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.query.FluentQuery;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;

@Service
public class EquipoServiceImpl implements EquipoService{

    @Autowired
    EquipoRepository equipoRepository;

    @Override
    public Equipo crearEquipo(Equipo equipo) {
        return equipoRepository.save(equipo);
    }

    @Override
    public Equipo obtenerEquipoPorId(Long id) {
        return equipoRepository.findById(id).orElse(null);
    }

    @Override
    public List<Equipo> obtenerTodos() {
        return equipoRepository.findAll();
    }

    @Override
    public void eliminarEquipo(Long id) {
        equipoRepository.deleteById(id);
    }

    @Override
    public Equipo modificarEquipo(Equipo equipo) {
        Equipo equipoModificado = equipoRepository.findById(equipo.getId()).orElse(null);
        equipoModificado.setCiudad(equipo.getCiudad());
        equipoModificado.setNombre(equipo.getNombre());
        return equipoRepository.save(equipoModificado);
    }
}
