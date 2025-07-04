//File: /src/main/java/com/example/gestion_academica/servicios/AsignaturaServicio.java
package com.example.gestion_academica.servicios;

import com.example.gestion_academica.dto.AsignaturaDTO;
import com.example.gestion_academica.dto.NotaDTO;
import com.example.gestion_academica.modelos.Asignatura;
import com.example.gestion_academica.repositorios.AsignaturaRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AsignaturaServicio {
    @Autowired
    private AsignaturaRepositorio repositorio;

    public List<AsignaturaDTO> obtenerTodos() {
        return repositorio.findAll().stream()
                .map(asignatura -> new AsignaturaDTO(
                        asignatura.getId(),
                        asignatura.getNombre(),
                        asignatura.getNotas().stream()
                                .map(nota -> new NotaDTO(
                                        nota.getId(),
                                        nota.getCalificacion(),
                                        nota.getAlumno() != null ? nota.getAlumno().getId() : null,
                                        nota.getAsignatura() != null ? nota.getAsignatura().getId() : null
                                ))
                                .collect(Collectors.toList())
                ))
                .collect(Collectors.toList());
    }


    public Asignatura guardar(Asignatura asignatura) {
        return repositorio.save(asignatura);
    }

    public AsignaturaDTO obtenerPorId(Long id) {
        Asignatura asignatura = repositorio.findById(id).orElse(null);
        if (asignatura != null) {
            return new AsignaturaDTO(
                    asignatura.getId(),
                    asignatura.getNombre(),
                    asignatura.getNotas().stream()
                            .map(nota -> new NotaDTO(
                                    nota.getId(),
                                    nota.getCalificacion(),
                                    nota.getAlumno() != null ? nota.getAlumno().getId() : null,
                                    nota.getAsignatura() != null ? nota.getAsignatura().getId() : null
                            ))
                            .collect(Collectors.toList())
            );
        }
        return null;
    }


    public AsignaturaDTO actualizar(Long id, AsignaturaDTO asignaturaDTO) {
        Asignatura existente = repositorio.findById(id).orElse(null);
        if (existente != null) {
            existente.setNombre(asignaturaDTO.getNombre());
            Asignatura actualizado = repositorio.save(existente);
            return new AsignaturaDTO(actualizado.getId(), actualizado.getNombre());
        }
        return null;
    }

    public void eliminar(Long id) {
        repositorio.deleteById(id);
    }
}