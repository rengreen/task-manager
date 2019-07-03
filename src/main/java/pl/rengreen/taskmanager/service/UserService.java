package pl.rengreen.taskmanager.service;

import pl.rengreen.taskmanager.model.User;

import java.util.List;

public interface UserService {
    User createUser(User user);

    User changeRoleToAdmin(User user);

    List<User> findAll();

    User getUserByEmail(String email);

    boolean isUserEmailPresent(String email);

    User getUserById(Long userId);

    void deleteUser(Long id);
}
