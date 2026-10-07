import java.util.ArrayList;

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

        ArrayList<Animal> animales = new ArrayList<>();

        Pato psyduck = new Pato();
        Gato luke = new Gato();
        Perro snoopy = new Perro();
        Capibara capi = new Capibara();
        Mosquito mosqui = new Mosquito();

        animales.add(psyduck);
        animales.add(luke);
        animales.add(snoopy);
        animales.add(capi);
        animales.add(mosqui);

//        for (int i = 0; i<animales.size(); i++){
//            animales.get(i).habla();
//        }

        for(Animal a : animales){
            a.habla();
        }




    }
        }