package views;

import java.util.Scanner;

public class MenuConsole implements Menu {
    private Scanner scanner;

    public MenuConsole() {
        scanner = new Scanner(System.in);
    }

    @Override
    public void showMenu() {
        System.out.println("Gestión de usuarios");
    }

    @Override
    public void show(String texto) {
        System.out.println(texto);
    }

    @Override
    public String getString() {
        return scanner.next();
    }
}
