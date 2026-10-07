import java.util.Date;

public class Animal {
    private String nombre;
    private Date fechaNacimiento;
    private Float peso;
    private Character sexo;

//    public Animal(){
//
//    }


    public Float getPeso() {
        return peso;
    }

    public Character getSexo() {
        return sexo;
    }

    public void habla(){
        System.out.println("El animal habla");
    }
}
