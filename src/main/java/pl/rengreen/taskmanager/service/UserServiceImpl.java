package pl.rengreen.taskmanager.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.rengreen.taskmanager.model.Role;
import pl.rengreen.taskmanager.model.User;
import pl.rengreen.taskmanager.repository.RoleRepository;
import pl.rengreen.taskmanager.repository.UserRepository;

import java.util.*;

@Service
public class UserServiceImpl implements UserService {
    private UserRepository userRepository;
    private RoleRepository roleRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository,
                       RoleRepository roleRepository) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
    }

    @Override
    public User createUser(User user) {
        user.setActive(1);
        Role userRole = roleRepository.findByRole("USER");
        user.setRoles(new ArrayList<>(Collections.singletonList(userRole)));
        return userRepository.save(user);
    }

    @Override
    public User changeRoleToAdmin(User user) {
        Role adminRole = roleRepository.findByRole("ADMIN");
        user.setRoles(new ArrayList<>(Collections.singletonList(adminRole)));
        return userRepository.save(user);
    }

    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }

    @Override
    public User getUserByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    @Override
    public boolean isUserEmailPresent(String email) {
        return userRepository.findByEmail(email) != null;
    }

}
