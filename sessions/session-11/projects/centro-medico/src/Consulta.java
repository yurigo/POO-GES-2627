public class Consulta {


    private int numero;
    private int planta;

    private Camilla camilla;

    public Consulta(int numero, int planta, String serieCamilla){
        this.numero = numero;
        this.planta = planta;

        this.camilla = new Camilla(serieCamilla);

    }


//    public int getNumero() {
//        return numero;
//    }
//
//    public int getPlanta() {
//        return planta;
//    }
//
//    public Camilla getCamilla() {
//        return camilla;
//    }


    public void showYourInfo() {
        System.out.println("Soy una consulta");
        System.out.println(" ---> numero: " + this.numero);
        System.out.println(" ---> planta: " + this.planta);
        System.out.println(" ---> y tengo la camilla: ");

        camilla.showYourInfo();
    }

}
