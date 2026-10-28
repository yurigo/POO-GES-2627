import controllers.Controller;
import managers.UserManager;
import persistence.FileUserRepository;
import persistence.UserRepository;
import views.MenuConsole;

import java.io.IOException;
import java.nio.file.Paths;

public class Main {
    public static void main(String[] args) throws IOException {
        UserRepository userRepository = new FileUserRepository(Paths.get("users.txt"));
        UserManager userManager = new UserManager(userRepository);
        Controller controller = new Controller(new MenuConsole(), userManager);

        controller.run();
    }
}
