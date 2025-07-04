//File: /src/main/java/com/example/gestion_academica/controladores/AsignaturaControlador.java
package com.example.gestion_academica.controladores;

import com.example.gestion_academica.dto.AsignaturaDTO;
import com.example.gestion_academica.modelos.Asignatura;
import com.example.gestion_academica.servicios.AsignaturaServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/asignaturas")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class AsignaturaControlador {
    @Autowired
    private AsignaturaServicio servicio;

    @GetMapping
    public List<AsignaturaDTO> obtenerTodos() {
        return servicio.obtenerTodos();
    }

    @PostMapping
    public ResponseEntity<AsignaturaDTO> crear(@RequestBody AsignaturaDTO asignaturaDTO) {
        Asignatura asignatura = new Asignatura(asignaturaDTO.getNombre());
        Asignatura guardada = servicio.guardar(asignatura);
        return ResponseEntity.ok(new AsignaturaDTO(guardada.getId(), guardada.getNombre()));
    }

    @GetMapping("/{id}")
    public ResponseEntity<AsignaturaDTO> obtenerPorId(@PathVariable Long id) {
        AsignaturaDTO asignatura = servicio.obtenerPorId(id);
        return asignatura != null ? ResponseEntity.ok(asignatura) : ResponseEntity.notFound().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<AsignaturaDTO> actualizar(@PathVariable Long id, @RequestBody AsignaturaDTO asignaturaDTO) {
        AsignaturaDTO actualizado = servicio.actualizar(id, asignaturaDTO);
        return actualizado != null ? ResponseEntity.ok(actualizado) : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        servicio.eliminar(id);
        return ResponseEntity.noContent().build();
    }
}