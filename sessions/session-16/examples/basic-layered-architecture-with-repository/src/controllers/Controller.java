package controllers;

import managers.UserManager;
import views.Menu;

import java.io.IOException;

public class Controller {
    private Menu menu;
    private UserManager userManager;

    public Controller(Menu menu, UserManager userManager) {
        this.menu = menu;
        this.userManager = userManager;
    }

    public void run() throws IOException {
        menu.showMenu();
        menu.show("Dame un nombre");
        String nombre = menu.getString();

        userManager.createUser(nombre);
        menu.show(userManager.getUsers().toString());
    }
}
