import java.util.Scanner;

public class MenuWithColors implements Menu{

    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_BLACK = "\u001B[30m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_PURPLE = "\u001B[35m";
    public static final String ANSI_CYAN = "\u001B[36m";
    public static final String ANSI_WHITE = "\u001B[37m";

    Scanner sc;

    public MenuWithColors(){
        sc = new Scanner(System.in);
    }

    @Override
    public void showMenu() {
        System.out.println("menu 2");
    }

    @Override
    public void show(String s) {
        System.out.println(ANSI_GREEN + s + ANSI_RESET);
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
