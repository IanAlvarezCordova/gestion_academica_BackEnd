package com.example.gestion_academica.servicios;

import com.example.gestion_academica.modelos.Nota;
import com.example.gestion_academica.repositorios.NotaRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NotaServicio {
    @Autowired
    private NotaRepositorio repositorio;

    public List<Nota> obtenerTodos() {
        return repositorio.findAll();
    }

    public Nota guardar(Nota nota) {
        return repositorio.save(nota);
    }

    public Nota obtenerPorId(Long id) {
        return repositorio.findById(id).orElse(null);
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