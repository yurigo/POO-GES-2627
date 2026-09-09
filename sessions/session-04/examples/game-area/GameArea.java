public class GameArea {

    private int width;
    private int height;

    private Ball p1;
    private Ball p2;

    /**
     * aqui voy a escribir algo de la clase
     * @param width esto es el ancho del area de juego
     * @param height esto es el alto del area de juego
     */
    public GameArea(int width, int height) {
        this.width = width;
        this.height = height;
    }

    public void draw() {

        System.out.println(" --------- Game Area ----------");

        for (int j = 0; j < this.height; j++) {
            for (int i = 0; i < this.width; i++) {

                //consultar b1
                if (p1.isOn(i, j)) {
                    System.out.print("1");
                    continue;
                }

                // consultar b2
                if (p2.isOn(i, j)) {
                    System.out.print("2");
                    continue;
                }

                System.out.print("-");
            }
            System.out.println();
        }

    }

    public void addPlayer1() {
//        Ball p1 = new Ball(3, 3, 1, 1, 10);
//        this.p1 = p1;

        this.p1 = new Ball(3, 3, 1, 1, 10);
    }

    public void addPlayer2() {
        this.p2 = new Ball(9, 9, -1, 1, 9);
    }
}
