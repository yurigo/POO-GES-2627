package persistence;

import model.User;

import java.io.IOException;
import java.util.List;

public interface UserDao {
    void insert(User user) throws IOException;

    List<User> findAll() throws IOException;
}
