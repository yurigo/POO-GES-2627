import java.util.Scanner;

public class MenuImplementation extends Menu {

    private Scanner sc;

    public MenuImplementation(){
        sc = new Scanner(System.in);
    }

    public void showMenu(){
        System.out.println("------");
        System.out.println("1. menu");
        System.out.println("------");
    }

    public void show(String s){
        System.out.println(s);
    }

    public Integer getInteger(){
        // yo puedo encapsular el error. y hasta que no me den un entero
        // sigo preguntando...
        return sc.nextInt();
    }

    public String getString(){
        return sc.next();
    }
}
