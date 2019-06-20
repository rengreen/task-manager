package pl.rengreen.taskmanager.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import pl.rengreen.taskmanager.model.Task;
import pl.rengreen.taskmanager.model.User;
import pl.rengreen.taskmanager.service.TaskService;
import pl.rengreen.taskmanager.service.UserService;

import javax.validation.Valid;

@Controller
public class TaskController {

    private TaskService taskService;
    private UserService userService;

    @Autowired
    public TaskController(TaskService taskService, UserService userService) {
        this.taskService = taskService;
        this.userService = userService;
    }

    @GetMapping("/tasks")
    public String listTasks(Model model) {

        model.addAttribute("tasks", taskService.findAll());
        return "views/tasksList";
    }

    @GetMapping("task/create")
    public String showTaskForm(Model model) {

        User user = userService.getUserByEmail("admin@mail.com");
        Task task = new Task();
        task.setCreator(user);
        model.addAttribute("task", task);
        return "views/emptyTaskForm";
    }

    @PostMapping("task/create")
    public String createTask(@Valid Task task, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "views/emptyTaskForm";
        }
        taskService.createTask(task);

        return "redirect:/tasks";
    }

}


