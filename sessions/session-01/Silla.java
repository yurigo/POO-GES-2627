public class Silla {
    int patas;
    int color;
    int posicionX;

    void showData() {
        System.out.println("Patas: " + patas);
        System.out.println("Color: " + color);
        System.out.println("Posicion X: " + posicionX);
    }

    void push() {
        posicionX = posicionX + 1;
        System.out.println("La silla se mueve a la derecha.");
    }

    void pull() {
        posicionX = posicionX - 1;
        System.out.println("La silla se mueve a la izquierda.");
    }

    public static void main(String[] args) {
        Silla silla1 = new Silla();
        Silla silla2 = new Silla();

        silla1.patas = 4;
        silla1.color = 2;
        silla1.posicionX = 0;

        silla2.patas = 3;
        silla2.color = 1;
        silla2.posicionX = 5;

        System.out.println("Estado inicial:");
        silla1.showData();
        silla2.showData();

        silla1.push();
        silla2.pull();

        System.out.println("Estado tras moverlas:");
        silla1.showData();
        silla2.showData();
    }
}
