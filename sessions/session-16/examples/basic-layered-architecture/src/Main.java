import controllers.Controller;
import views.Menu;
import views.MenuConsole;
import views.MenuConsoleSuperGuay;

public class Main{

    public static void main(String[] args){

        // Menu m = new MenuConsole();
        Menu m = new MenuConsoleSuperGuay();


        Controller c = new Controller(m);

        c.run();
    }
}