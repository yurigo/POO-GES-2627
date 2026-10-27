public class Perro extends Domestico{


    public Perro(String nombre){
        // new Domestico()

        // this.nombre = nombre; // esto no lo puedo hacer porque no veo el nombre.
        // es animal quien debería asignar el nombre

        super(nombre);
    }


    public void habla(){
        System.out.println("guau guau");
    }
}
