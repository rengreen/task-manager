package pl.rengreen.taskmanager.service;

import pl.rengreen.taskmanager.model.User;

public interface UserService {
    User createUser(User user);
    User changeRoleToAdmin(User user);
}
