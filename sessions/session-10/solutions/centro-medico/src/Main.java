class Main{
    public static void main(String[] args){

        System.out.println("Hola! Bienvenido a la gestion del centro medico");

        String nombre = "La Salle Health Center";
        String codigo = "LSHC";

        CentroMedico cm = new CentroMedico(codigo, nombre);

        Consulta consulta = new Consulta(1,2,"camilla1");
        Consulta consulta2 = new Consulta(3,4,"camilla2");
        Consulta consulta3 = new Consulta(5,6,"camilla3");
        Consulta consulta4 = new Consulta(7,8,"camilla4");

        cm.añadirConsulta(consulta);
        cm.añadirConsulta(consulta2);
        cm.añadirConsulta(consulta3);
        cm.añadirConsulta(consulta4);

        cm.añadirConsulta(new Consulta(8,9,"camilla cabello"));


    }
}