package pl.rengreen.taskmanager.service;

import pl.rengreen.taskmanager.model.User;

import java.util.List;

public interface UserService {
    User createUser(User user);
    User changeRoleToAdmin(User user);

    List<User> findAll();
}
