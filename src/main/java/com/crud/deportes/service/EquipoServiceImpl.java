package com.crud.deportes.service;

import com.crud.deportes.dto.EquipoDto;
import com.crud.deportes.entity.Equipo;
import com.crud.deportes.repository.EquipoRepository;
import com.crud.deportes.utils.constants.Constants;
import com.crud.deportes.utils.response.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EquipoServiceImpl implements EquipoService{

    @Autowired
    EquipoRepository equipoRepository;

    @Override
    public Equipo crearEquipo(Equipo equipo) {
        return equipoRepository.save(equipo);
    }

    @Override
    public ResponseEntity<ApiResponse<EquipoDto>> obtenerEquipoPorId(Long id) {
        ApiResponse<EquipoDto> apiResponse = new ApiResponse<>();
        EquipoDto equipoDto = new EquipoDto();
        try{
           Equipo equipo = equipoRepository.findById(id).orElse(null);
           if(equipo == null){
               apiResponse.setGlosa(Constants.EQUIPO_NO_ENCONTRADO);
               apiResponse.setDetailMsg("El equipo con el ID: " + id + " no existe. Por favor prueba con otro ID.");
               return ResponseEntity.ok().body(apiResponse);
           }
           equipoDto.setEmail(equipo.getEmail());
           equipoDto.setCiudad(equipo.getCiudad());
           equipoDto.setNombre(equipo.getNombre());
           apiResponse.setGlosa("Equipo encontrado");
           apiResponse.setDetailMsg("Se encontro el equipo con el ID: " + id);
           apiResponse.setData(equipoDto);
           return ResponseEntity.ok().body(apiResponse);
        }catch (Exception exception){
            apiResponse.setGlosa(Constants.ERROR_DATABASE);
            apiResponse.setDetailMsg(exception.getMessage());
            return ResponseEntity.status(HttpStatus.CONFLICT).body(apiResponse);
        }
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
    public  Equipo modificarEquipo(Equipo equipo) {
        Equipo equipoModificado = equipoRepository.findById(equipo.getId()).orElse(null);
        equipoModificado.setCiudad(equipo.getCiudad());
        equipoModificado.setNombre(equipo.getNombre());
        return equipoRepository.save(equipoModificado);
    }
}
