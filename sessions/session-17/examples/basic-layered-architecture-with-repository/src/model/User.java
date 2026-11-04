package model;

public class User {
    private String nombre;

    public User(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    @Override
    public String toString() {
        return "nombre: " + nombre;
    }
}
