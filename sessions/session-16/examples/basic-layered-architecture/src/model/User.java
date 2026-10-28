package model;

public class User {

    private String nombre;

    public User(String nombre){
        this.nombre = nombre;
    }

    public String toString(){
        return "nombre: " + this.nombre;
    }
}
