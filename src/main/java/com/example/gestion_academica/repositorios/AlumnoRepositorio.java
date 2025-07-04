package com.example.gestion_academica.repositorios;

import com.example.gestion_academica.modelos.Alumno;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AlumnoRepositorio extends JpaRepository<Alumno, Long> {
}