//File: /src/main/java/com/example/gestion_academica/servicios/AlumnoServicio.java
package com.example.gestion_academica.servicios;

import com.example.gestion_academica.dto.AlumnoDTO;
import com.example.gestion_academica.modelos.Alumno;
import com.example.gestion_academica.repositorios.AlumnoRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AlumnoServicio {
    @Autowired
    private AlumnoRepositorio repositorio;

    public List<AlumnoDTO> obtenerTodos() {
        return repositorio.findAll().stream()
                .map(alumno -> new AlumnoDTO(
                        alumno.getId(),
                        alumno.getNombre(),
                        alumno.getApellido(),
                        alumno.getEmail()
                ))
                .collect(Collectors.toList());
    }

    public Alumno guardar(Alumno alumno) {
        return repositorio.save(alumno);
    }

    public AlumnoDTO obtenerPorId(Long id) {
        Alumno alumno = repositorio.findById(id).orElse(null);
        if (alumno != null) {
            return new AlumnoDTO(
                    alumno.getId(),
                    alumno.getNombre(),
                    alumno.getApellido(),
                    alumno.getEmail()
            );
        }
        return null;
    }

    public AlumnoDTO actualizar(Long id, AlumnoDTO alumnoDTO) {
        Alumno existente = repositorio.findById(id).orElse(null);
        if (existente != null) {
            existente.setNombre(alumnoDTO.getNombre());
            existente.setApellido(alumnoDTO.getApellido());
            existente.setEmail(alumnoDTO.getEmail());
            Alumno actualizado = repositorio.save(existente);
            return new AlumnoDTO(
                    actualizado.getId(),
                    actualizado.getNombre(),
                    actualizado.getApellido(),
                    actualizado.getEmail()
            );
        }
        return null;
    }

    public void eliminar(Long id) {
        repositorio.deleteById(id);
    }
}