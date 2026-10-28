package managers;

import model.User;

import java.util.ArrayList;
import java.util.List;

public class UserManager {

    List<User> users;

    public UserManager(){
        // users = new MiListaSuperPoderosa<User>();
        users = new ArrayList<User>();
    }

    /**
     * A partir de un nombre agregarlo a la lista de usuarios
     * @param nombre el nombre del usuario a agregar.
     */
    public void createUser(String nombre) {
        User u = new User(nombre);
        users.add(u);
    }

    /**
     * El manager tiene que devolver la lista de usuarios
     * en forma de string.
     * @return lista de usuarios serializada
     */
    public String serializeUsers(){

        return users.toString();


    }
}
