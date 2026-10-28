package persistence;

import model.User;

import java.io.IOException;
import java.util.List;

public interface UserRepository {
    void add(User user) throws IOException;

    List<User> findAll() throws IOException;
}
