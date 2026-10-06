import java.sql.SQLOutput;

class Main{
    public static void main(String[] args){

        System.out.println("Hola! Bienvenido a la gestion del centro medico");

        String nombre = "La Salle Health Center";
        String codigo = "LSHC";

        System.out.println("Creo el centro médico");
        CentroMedico cm = new CentroMedico(codigo, nombre);
        cm.showYourInfo();

        System.out.println("Creo la consulta 1");
        Consulta consulta = new Consulta(1,2,"camilla1");
        System.out.println("Creo la consulta 2");
        Consulta consulta2 = new Consulta(3,4,"camilla2");
        System.out.println("Creo la consulta 3");
        Consulta consulta3 = new Consulta(5,6,"camilla3");
        System.out.println("Creo la consulta 4");
        Consulta consulta4 = new Consulta(7,8,"camilla4");

        System.out.println("Añado la consulta 1 al centro");
        cm.añadirConsulta(consulta);
        System.out.println("Añado la consulta 2 al centro");
        cm.añadirConsulta(consulta2);
        System.out.println("Añado la consulta 3 al centro");
        cm.añadirConsulta(consulta3);
        System.out.println("Añado la consulta 4 al centro");
        cm.añadirConsulta(consulta4);

        System.out.println("Añado la consulta que creo al vuelo (consulta 5");
        cm.añadirConsulta(new Consulta(8,9,"camilla cabello"));


//        ArrayList<Consulta> consultas =  cm.getConsultas();
//        for( int i = 0; i < consultas.length; i++){
//            System.out.println(consultas.get(i));
//        }

        cm.ShowYourConsultas();

    }
}