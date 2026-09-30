public class Consulta {

    private int numero;
    private int planta;

    private Camilla camilla;

    public Consulta(int numero, int planta, String serieCamilla){
        this.numero = numero;
        this.planta = planta;

        this.camilla = new Camilla(serieCamilla);

    }

}
