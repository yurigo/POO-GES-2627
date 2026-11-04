import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        Gson gson = new Gson();

        // usuarios es un map y en el fromJson hay que
        // utilizar Map<Integer, User> de un modo especial:

        /*
         {
                "1": {
                    "login": "yuri",
                    "password": "yuri"
                },
                "2": {
                    "login": "Alice",
                    "password": "alice"
                }
            }
         */

        String filepath = "./usuarios.json";

        File jsonfile = new File(filepath);
        try {
            FileReader fileReader = new FileReader(jsonfile);

            Type type = new TypeToken<List<User>>() {}.getType()
            
            List<User> usuarios = gson.fromJson(fileReader, type);

            
            for (User usuario: usuarios) {
                System.out.println(usuario);
            }
            
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}