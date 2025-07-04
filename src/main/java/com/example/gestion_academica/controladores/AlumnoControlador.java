//File: /src/main/java/com/example/gestion_academica/controladores/AlumnoControlador.java
package com.example.gestion_academica.controladores;

import com.example.gestion_academica.dto.AlumnoDTO;
import com.example.gestion_academica.modelos.Alumno;
import com.example.gestion_academica.servicios.AlumnoServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/alumnos")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class AlumnoControlador {
    @Autowired
    private AlumnoServicio servicio;

    @GetMapping
    public List<AlumnoDTO> obtenerTodos() {
        return servicio.obtenerTodos();
    }

    @PostMapping
    public ResponseEntity<AlumnoDTO> crear(@RequestBody AlumnoDTO alumnoDTO) {
        Alumno alumno = new Alumno(alumnoDTO.getNombre(), alumnoDTO.getApellido(), alumnoDTO.getEmail());
        Alumno guardado = servicio.guardar(alumno);
        return ResponseEntity.ok(new AlumnoDTO(guardado.getId(), guardado.getNombre(), guardado.getApellido(), guardado.getEmail()));
    }

    @GetMapping("/{id}")
    public ResponseEntity<AlumnoDTO> obtenerPorId(@PathVariable Long id) {
        AlumnoDTO alumno = servicio.obtenerPorId(id);
        return alumno != null ? ResponseEntity.ok(alumno) : ResponseEntity.notFound().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<AlumnoDTO> actualizar(@PathVariable Long id, @RequestBody AlumnoDTO alumnoDTO) {
        AlumnoDTO actualizado = servicio.actualizar(id, alumnoDTO);
        return actualizado != null ? ResponseEntity.ok(actualizado) : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        servicio.eliminar(id);
        return ResponseEntity.noContent().build();
    }
}