package views;

import java.util.Scanner;

public class MenuConsoleSuperGuay implements Menu{

    Scanner sc;

    public MenuConsoleSuperGuay(){
        sc = new Scanner(System.in);
    }

    public void showMenu() {
        System.out.println("***muestra el menu***");
    }

    public void show(String s){
        System.out.println("***"+s+"***");
    }

    public String getString(){
        return sc.next();
    }

}
