package pl.rengreen.taskmanager.service;

import pl.rengreen.taskmanager.model.Task;
import pl.rengreen.taskmanager.model.User;

import java.util.List;

public interface TaskService {

    void createTask(Task task);

    List<Task> findAll();

    List<Task> findByOwnerOrderByDateDesc(User user);
}
