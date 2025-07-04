package com.example.gestion_academica.servicios;

import com.example.gestion_academica.modelos.Alumno;
import com.example.gestion_academica.repositorios.AlumnoRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AlumnoServicio {
    @Autowired
    private AlumnoRepositorio repositorio;

    public List<Alumno> obtenerTodos() {
        return repositorio.findAll();
    }

    public Alumno guardar(Alumno alumno) {
        return repositorio.save(alumno);
    }

    public Alumno obtenerPorId(Long id) {
        return repositorio.findById(id).orElse(null);
    }

    public Alumno actualizar(Long id, Alumno alumno) {
        Alumno existente = repositorio.findById(id).orElse(null);
        if (existente != null) {
            existente.setNombre(alumno.getNombre());
            existente.setApellido(alumno.getApellido());
            existente.setEmail(alumno.getEmail());
            return repositorio.save(existente);
        }
        return null;
    }

    public void eliminar(Long id) {
        repositorio.deleteById(id);
    }
}