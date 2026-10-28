package views;

import java.util.Scanner;

public class MenuConsole implements Menu {

    Scanner sc;

    public MenuConsole(){
        sc = new Scanner(System.in);
    }

    public void showMenu() {
        System.out.println("muestra el menu");
    }

    public void show(String s){
        System.out.println(s);
    }

    public String getString(){
        return sc.next();
    }

}
