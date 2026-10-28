package managers;

import model.User;
import persistence.UserRepository;

import java.io.IOException;
import java.util.List;

public class UserManager {
    private UserRepository userRepository;

    public UserManager(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public void createUser(String nombre) throws IOException {
        userRepository.add(new User(nombre));
    }

    public List<User> getUsers() throws IOException {
        return userRepository.findAll();
    }
}
