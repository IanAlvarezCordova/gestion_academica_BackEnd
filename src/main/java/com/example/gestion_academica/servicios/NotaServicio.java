//File: /src/main/java/com/example/gestion_academica/servicios/NotaServicio.java
package com.example.gestion_academica.servicios;

import com.example.gestion_academica.dto.NotaDTO;
import com.example.gestion_academica.modelos.Alumno;
import com.example.gestion_academica.modelos.Asignatura;
import com.example.gestion_academica.modelos.Nota;
import com.example.gestion_academica.repositorios.AlumnoRepositorio;
import com.example.gestion_academica.repositorios.AsignaturaRepositorio;
import com.example.gestion_academica.repositorios.NotaRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class NotaServicio {
    @Autowired
    private NotaRepositorio repositorio;
    @Autowired
    private AlumnoRepositorio alumnoRepositorio;
    @Autowired
    private AsignaturaRepositorio asignaturaRepositorio;

    public Nota crearDesdeDTO(NotaDTO notaDTO) {
        Nota nota = new Nota();
        nota.setCalificacion(notaDTO.getCalificacion());
        if (notaDTO.getAlumnoId() != null) {
            Alumno alumno = alumnoRepositorio.findById(notaDTO.getAlumnoId())
                    .orElseThrow(() -> new RuntimeException("Alumno no encontrado"));
            nota.setAlumno(alumno);
        }
        if (notaDTO.getAsignaturaId() != null) {
            Asignatura asignatura = asignaturaRepositorio.findById(notaDTO.getAsignaturaId())
                    .orElseThrow(() -> new RuntimeException("Asignatura no encontrada"));
            nota.setAsignatura(asignatura);
        }
        nota.setDescripcion(notaDTO.getDescripcion());
        nota.setFecha(notaDTO.getFecha());

        return repositorio.save(nota);
    }

    public NotaDTO actualizar(Long id, NotaDTO notaDTO) {
        Nota existente = repositorio.findById(id).orElse(null);
        if (existente != null) {
            if (notaDTO.getCalificacion() != null) {
                existente.setCalificacion(notaDTO.getCalificacion());
            }
            if (notaDTO.getAlumnoId() != null) {
                Alumno alumno = alumnoRepositorio.findById(notaDTO.getAlumnoId())
                        .orElseThrow(() -> new RuntimeException("Alumno no encontrado"));
                existente.setAlumno(alumno);
            }
            if (notaDTO.getAsignaturaId() != null) {
                Asignatura asignatura = asignaturaRepositorio.findById(notaDTO.getAsignaturaId())
                        .orElseThrow(() -> new RuntimeException("Asignatura no encontrada"));
                existente.setAsignatura(asignatura);
            }
            if (notaDTO.getDescripcion() != null) {
                existente.setDescripcion(notaDTO.getDescripcion());
            }
            if (notaDTO.getFecha() != null) {
                existente.setFecha(notaDTO.getFecha());
            }

            Nota actualizado = repositorio.save(existente);
            return new NotaDTO(
                    actualizado.getId(),
                    actualizado.getCalificacion(),
                    actualizado.getAlumno() != null ? actualizado.getAlumno().getId() : null,
                    actualizado.getAsignatura() != null ? actualizado.getAsignatura().getId() : null,
                    actualizado.getDescripcion(),
                    actualizado.getFecha()
            );
        }
        return null;
    }
    public List<NotaDTO> obtenerTodos() {
        return repositorio.findAll().stream()
                .map(nota -> new NotaDTO(
                        nota.getId(),
                        nota.getCalificacion(),
                        nota.getAlumno() != null ? nota.getAlumno().getId() : null,
                        nota.getAsignatura() != null ? nota.getAsignatura().getId() : null,
                        nota.getDescripcion(),
                        nota.getFecha()
                ))
                .collect(Collectors.toList());
    }

    public Nota guardar(Nota nota) {
        return repositorio.save(nota);
    }

    public NotaDTO obtenerPorId(Long id) {
        Nota nota = repositorio.findById(id).orElse(null);
        if (nota != null) {
            return new NotaDTO(
                    nota.getId(),
                    nota.getCalificacion(),
                    nota.getAlumno() != null ? nota.getAlumno().getId() : null,
                    nota.getAsignatura() != null ? nota.getAsignatura().getId() : null,
                    nota.getDescripcion(),
                    nota.getFecha()
            );
        }
        return null;
    }

    public Nota actualizar(Long id, Nota nota) {
        Nota existente = repositorio.findById(id).orElse(null);
        if (existente != null) {
            existente.setCalificacion(nota.getCalificacion());
            existente.setAlumno(nota.getAlumno());
            existente.setAsignatura(nota.getAsignatura());
            return repositorio.save(existente);
        }
        return null;
    }

    public void eliminar(Long id) {
        repositorio.deleteById(id);
    }
}