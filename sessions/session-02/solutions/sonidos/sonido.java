public class Sonido{

    float volumen;
    float duracion;
    float frecuencia;

    // -------------------

    void play(){
        System.out.println("emitiendo sonido: " + frecuencia + "Hz, durante:" + duracion + " a un volumen de" + volumen);


    }

    boolean isAudible(){
        // if (frecuencia > 20 && frecuencia < 20_000){
        //     return true;
        // }
        // else{
        //     return false;
        // }
        
        return frecuencia > 20 && frecuencia < 20_000;
    }

}