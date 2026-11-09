package habitracker;

import java.util.UUID;

public class Habito {
    private String id;
    private String nombre;
    private String descripcion;
    private String color;

    public Habito(String nombre, String descripcion, String color) {
        this.id = UUID.randomUUID().toString(); // Genera un ID único
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.color = color;
    }

    // Constructor extra para cuando carguemos desde JSON
    public Habito(String id, String nombre, String descripcion, String color) {
        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.color = color;
    }
    // Getters
    public String getId() {
        return id;
    }
    public String getNombre() {
        return nombre;
    }
    public String getDescripcion() {
        return descripcion;
    }
    public String getColor() {
        return color;
    }

    //Setters

    /*El set id no tiene sentido agregarlo cualquier parte del progrma podria acceder
    y cambairlo perdiendo toda la progresion de ese habito registrada*/
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    public void setColor(String color) {
        this.color = color;
    }


    @Override
    public String toString() {
        return """
                nombre: %s
                descripcion: %s
                """.formatted(nombre,descripcion);
    }
}
