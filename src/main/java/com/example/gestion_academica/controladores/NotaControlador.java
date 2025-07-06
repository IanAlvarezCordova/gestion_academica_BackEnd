//File: /src/main/java/com/example/gestion_academica/controladores/NotaControlador.java
package com.example.gestion_academica.controladores;


import com.example.gestion_academica.dto.NotaDTO;
import com.example.gestion_academica.modelos.Nota;
import com.example.gestion_academica.servicios.NotaServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/notas")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class NotaControlador {
    @Autowired
    private NotaServicio servicio;

    @GetMapping
    public List<NotaDTO> obtenerTodos() {
        return servicio.obtenerTodos();
    }

    @PostMapping
    public ResponseEntity<NotaDTO> crear(@RequestBody NotaDTO notaDTO) {
        Nota nota = servicio.crearDesdeDTO(notaDTO);
        return ResponseEntity.ok(new NotaDTO(
                nota.getId(),
                nota.getCalificacion(),
                nota.getAlumno() != null ? nota.getAlumno().getId() : null,
                nota.getAsignatura() != null ? nota.getAsignatura().getId() : null
                , nota.getDescripcion(),
                nota.getFecha()
        ));
    }

    @GetMapping("/{id}")
    public ResponseEntity<NotaDTO> obtenerPorId(@PathVariable Long id) {
        NotaDTO nota = servicio.obtenerPorId(id);
        return nota != null ? ResponseEntity.ok(nota) : ResponseEntity.notFound().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<NotaDTO> actualizar(@PathVariable Long id, @RequestBody NotaDTO notaDTO) {
        NotaDTO actualizado = servicio.actualizar(id, notaDTO);
        return actualizado != null ? ResponseEntity.ok(actualizado) : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        servicio.eliminar(id);
        return ResponseEntity.noContent().build();
    }
}