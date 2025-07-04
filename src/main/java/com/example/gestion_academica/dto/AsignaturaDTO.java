<<<<<<< Updated upstream
//File: /src/main/java/com/example/gestion_academica/dto/AsignaturaDTO.java
package com.example.gestion_academica.dto;
import java.util.List;

public class AsignaturaDTO {
    private Long id;
    private String nombre;
    private List<NotaDTO> notas;

    public AsignaturaDTO() {}

    public AsignaturaDTO(Long id, String nombre, List<NotaDTO> notas) {
        this.id = id;
        this.nombre = nombre;
        this.notas = notas;
    }

    public AsignaturaDTO(Long id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }


    // Getters y Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }
    public List<NotaDTO> getNotas() { return notas; }
    public void setNotas(List<NotaDTO> notas) { this.notas = notas; }
}
=======
package com.example.gestion_academica.dto;

public class AsignaturaDTO {
}
>>>>>>> Stashed changes
