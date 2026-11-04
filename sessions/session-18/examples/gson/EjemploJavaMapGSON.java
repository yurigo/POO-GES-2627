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
                    "login": "Bob",
                    "password": "bob"
                },
                "2": {
                    "login": "Alice",
                    "password": "alice"
                }
            }
         */

        String filepath = "./usuarios-object.json";

        File jsonfile = new File(filepath);
        try {
            FileReader fileReader = new FileReader(jsonfile);

            // Doc util: https://www.baeldung.com/gson-json-to-map
            Map<Integer, User> usuarios = gson.fromJson(fileReader , new TypeToken<Map<Integer, User>>() {}.getType());
            
            System.out.println(usuarios.get(2).getLogin());
            
            for (User usuario: usuarios.values()) {
                System.out.println(usuario.getLogin() + " " + usuario.getPassword());
            }
            
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}