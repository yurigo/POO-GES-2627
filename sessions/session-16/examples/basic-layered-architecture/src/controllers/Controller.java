package controllers;

import managers.UserManager;
import views.Menu;

public class Controller {
    private Menu menu;
    private UserManager userManager;

    public Controller(Menu menu){
        this.menu = menu;
        userManager = new UserManager();
    }

    public void run(){

        for(;;) {
            menu.showMenu();
            menu.show("Dame un nombre");
            String nombre = menu.getString();

            userManager.createUser(nombre);
            menu.show(userManager.serializeUsers());
        }

    }
}
