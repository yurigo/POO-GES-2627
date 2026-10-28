package managers;

import model.User;
import persistence.UserDao;

import java.io.IOException;
import java.util.List;

public class UserManager {
    private UserDao userDao;

    public UserManager(UserDao userDao) {
        this.userDao = userDao;
    }

    public void createUser(String nombre) throws IOException {
        userDao.insert(new User(nombre));
    }

    public List<User> getUsers() throws IOException {
        return userDao.findAll();
    }
}
