public class Camilla {

    private String numeroSerie;

    public Camilla(String serie){
        this.numeroSerie = serie;
    }

//    public String getNumeroSerie() {
//        return numeroSerie;
//    }

    public void showYourInfo(){
        System.out.println("Camilla");
        System.out.println("numero de serie: " + this.numeroSerie);
    }
}
