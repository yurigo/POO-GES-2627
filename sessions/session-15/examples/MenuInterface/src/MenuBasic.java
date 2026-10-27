import java.util.Scanner;

public class MenuBasic implements Menu {

    Scanner sc;

    public MenuBasic(){
        sc = new Scanner(System.in);
    }

    @Override
    public void showMenu() {
        System.out.println("menu 1");
    }

    @Override
    public void show(String s) {
        System.out.println(s);
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
