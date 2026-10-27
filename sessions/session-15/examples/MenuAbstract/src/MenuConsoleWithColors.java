import java.util.Scanner;

public class MenuConsoleWithColors extends Menu{

    Scanner sc;

    public MenuConsoleWithColors(){
        sc = new Scanner(System.in);
    }

    @Override
    public void showMenu() {
        System.out.println("aaaaaaaaa");
    }

    @Override
    public void show(String s) {
        System.out.println("**" + s + "**");

    }

    @Override
    public Integer getInteger() {
        return sc.nextInt();
    }

    @Override
    public String getString() {
        return sc.next();
    }
}
