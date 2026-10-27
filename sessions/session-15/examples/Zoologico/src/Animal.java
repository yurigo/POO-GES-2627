import java.util.Date;

public abstract class Animal {
    private String nombre;
    private Date fechaNacimiento;
    private Float peso;
    private Character sexo;

public Animal(String nombre){
    this.nombre = nombre;
}


    public Float getPeso() {
        return peso;
    }

    public Character getSexo() {
        return sexo;
    }

    abstract public void habla();

    public void setNombre(String nombre){
        this.nombre = nombre;
    }

    public String toString(){
        return "El animal se llama: " + this.nombre;
    }
}
