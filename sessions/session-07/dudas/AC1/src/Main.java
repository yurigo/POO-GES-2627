public class Main {
    public static void main(String[] args){

        // enfoque 1: crear el constructor en bola y usarlo.
        Ball b1 = new Ball("pepito", "menganito", "fulanito");
        Ball b2 = new Ball("algo que leo en el fichero");

        b1.getAt1();

        // ¿Crear el metodo createBall en Ball?
        // no tiene sentido
        // he instanciado b1, no tiene sentido
        // crear otra bola.
        b1.createBall("a", "b", "c");

        // nuevo enfoque:
        // usar una factoria experta en crear bolas
        FactoryBall fb = new FactoryBall();
        Ball b3 = fb.createBall("1","2","3");

    }
}
