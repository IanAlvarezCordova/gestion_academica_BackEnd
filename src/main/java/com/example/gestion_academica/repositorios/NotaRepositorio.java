package com.example.gestion_academica.repositorios;

import com.example.gestion_academica.modelos.Nota;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NotaRepositorio extends JpaRepository<Nota, Long> {
}
