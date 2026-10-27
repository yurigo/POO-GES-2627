import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

public class Main{
    public static void main(String[] args){
        // TODO: hacer el algoritmo...

        // Capibara c = new Capibara();

        // quiero modelar un zoo:

//        Capibara[] capibaras = new Capibara[100];
//        Pato[] patos = new Pato[100];
//        Perro[] perros = new Perro[100];
//        Gato[] gatos = new Gato[100];

//        ArrayList<Capibara> capibaras = new ArrayList<>();
//        ArrayList<Pato> patos = new ArrayList<>();
//        ArrayList<Gato> gatos = new ArrayList<>();
//        ArrayList<Perro> perros = new ArrayList<>();

        List<Animal> animales = new Vector<>();

        Pato psyduck = new Pato("Psyduck");
        Gato luke = new Gato("Luke");
        Perro snoopy = new Perro("Snoopy");
        Capibara capi = new Capibara("Captain Capybara" , 314);
        Mosquito mosqui = new Mosquito("Dracula");

        animales.add(psyduck);
        animales.add(luke);
        animales.add(snoopy);
        animales.add(capi);
        animales.add(mosqui);

//        for (int i = 0; i<animales.size(); i++){
//            animales.get(i).habla();
//        }

//        for(Animal a : animales){
//            a.setNombre("Animal");
//        }

        for(Animal a : animales){
            System.out.println(a);
            a.habla();
        }




    }
        }