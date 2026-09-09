public class Main {
    public static void main(String[] args) {

        System.out.println("Bienvenido al juego.");

        GameArea gameArea = new GameArea(20, 10);

        gameArea.addPlayer1();
        gameArea.addPlayer2();

        gameArea.draw();
    }
}
