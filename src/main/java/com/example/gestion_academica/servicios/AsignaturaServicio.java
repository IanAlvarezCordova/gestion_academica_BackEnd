package com.example.gestion_academica.servicios;

import com.example.gestion_academica.modelos.Asignatura;
import com.example.gestion_academica.repositorios.AsignaturaRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AsignaturaServicio {
    @Autowired
    private AsignaturaRepositorio repositorio;

    public List<Asignatura> obtenerTodos() {
        return repositorio.findAll();
    }

    public Asignatura guardar(Asignatura asignatura) {
        return repositorio.save(asignatura);
    }

    public Asignatura obtenerPorId(Long id) {
        return repositorio.findById(id).orElse(null);
    }

    public Asignatura actualizar(Long id, Asignatura asignatura) {
        Asignatura existente = repositorio.findById(id).orElse(null);
        if (existente != null) {
            existente.setNombre(asignatura.getNombre());
            return repositorio.save(existente);
        }
        return null;
    }

    public void eliminar(Long id) {
        repositorio.deleteById(id);
    }
}