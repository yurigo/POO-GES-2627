import controllers.Controller;
import managers.UserManager;
import persistence.FileUserDao;
import persistence.UserDao;
import views.MenuConsole;

import java.io.IOException;
import java.nio.file.Paths;

public class Main {
    public static void main(String[] args) throws IOException {
        UserDao userDao = new FileUserDao(Paths.get("users.txt"));
        UserManager userManager = new UserManager(userDao);
        Controller controller = new Controller(new MenuConsole(), userManager);

        controller.run();
    }
}
