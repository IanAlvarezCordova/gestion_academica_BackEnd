//File: /src/main/java/com/example/gestion_academica/repositorios/AsignaturaRepositorio.java
package com.example.gestion_academica.repositorios;

import com.example.gestion_academica.modelos.Asignatura;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AsignaturaRepositorio extends JpaRepository<Asignatura, Long> {
}