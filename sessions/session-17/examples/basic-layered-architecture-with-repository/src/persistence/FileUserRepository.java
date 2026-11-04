package persistence;

import model.User;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.List;

public class FileUserRepository implements UserRepository {
    private Path path;

    public FileUserRepository(Path path) {
        this.path = path;
    }

    @Override
    public void add(User user) throws IOException {
        Files.writeString(
                path,
                user.getNombre() + System.lineSeparator(),
                StandardCharsets.UTF_8,
                StandardOpenOption.CREATE,
                StandardOpenOption.APPEND
        );
    }

    @Override
    public List<User> findAll() throws IOException {
        List<User> users = new ArrayList<User>();
        if (!Files.exists(path)) {
            return users;
        }

        for (String nombre : Files.readAllLines(path, StandardCharsets.UTF_8)) {
            users.add(new User(nombre));
        }
        return users;
    }
}
