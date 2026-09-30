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
}
