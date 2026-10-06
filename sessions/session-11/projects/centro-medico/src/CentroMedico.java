import java.util.ArrayList;

public class CentroMedico {
    private String codigo;
    private String nombre;

    // private Consulta[] consultas;
    private ArrayList<Consulta> consultas;


    public CentroMedico(String codigo, String nombre){
        this.codigo = codigo;
        this.nombre = nombre;

        // this.consultas = new Consulta[10];
        this.consultas = new ArrayList<Consulta>();
    }

    public void añadirConsulta(Consulta c){
        // this.consultas[0] = c;  <-- esto solo guarda 1

//        for (int i = 0; i < consultas.length; i++){
//            if (consultas[i] == null){
//                this.consultas[i] = c;
//                System.out.println("insertado!! en" + i);
//                return;
//                // break;
//            }
//        }
// System.out.println("Te has pasao de frenada...");

        consultas.add(c);
    }

    public void showYourInfo(){
        System.out.println("Soy el centro: " + this.codigo + ", " + this.nombre);
    }

//    public ArrayList<Consulta> getConsultas() {
//        return consultas;
//    }

    public void ShowYourConsultas(){

        // funcionar funciona... pero meh.
//        for( int i = 0; i < this.consultas.size(); i++){
//            // System.out.println(consultas.get(i));
//            System.out.println("numero: " + consultas.get(i).getNumero());
//            System.out.println("planta: " + consultas.get(i).getPlanta());
//            System.out.println("serie camilla: " + consultas.get(i).getCamilla().getNumeroSerie());
//        }

        for( int i = 0; i < this.consultas.size(); i++){
            consultas.get(i).showYourInfo();
        }

        // consultas.showYourInfo();

    }
}

