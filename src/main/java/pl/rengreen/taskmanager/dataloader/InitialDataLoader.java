package pl.rengreen.taskmanager.dataloader;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;
import pl.rengreen.taskmanager.model.Role;
import pl.rengreen.taskmanager.model.User;
import pl.rengreen.taskmanager.model.Task;
import pl.rengreen.taskmanager.service.RoleService;
import pl.rengreen.taskmanager.service.TaskService;
import pl.rengreen.taskmanager.service.UserService;

import java.time.LocalDate;

@Component
public class InitialDataLoader implements ApplicationListener<ContextRefreshedEvent> {

    private UserService userService;
    private TaskService taskService;
    private RoleService roleService;

    @Autowired
    public InitialDataLoader(UserService userService, TaskService taskService, RoleService roleService) {
        this.userService = userService;
        this.taskService = taskService;
        this.roleService = roleService;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {

        //ROLES --------------------------------------------------------------------------------------------------------
        roleService.createRole(new Role("ADMIN"));
        roleService.createRole(new Role("USER"));

        //USERS --------------------------------------------------------------------------------------------------------
        User admin = new User(
                "admin@mail.com",
                "admin",
                "112233",
                "images/user.png");
        userService.createUser(admin);
        userService.changeRoleToAdmin(admin);

        User ann = new User(
                "ann@mail.com",
                "Ann",
                "112233",
                "images/user.png");
        userService.createUser(ann);
        userService.changeRoleToAdmin(ann);

        User mark = new User(
                "mark@mail.com",
                "Mark",
                "112233",
                "images/user.png");
        userService.createUser(mark);
        userService.changeRoleToAdmin(mark);

        //TASKS --------------------------------------------------------------------------------------------------------
        taskService.createTask(new Task(
                "First task",
                "Detailed description of first task",
                LocalDate.now().plusDays(10),
                true,
                mark,
                mark
        ));

        taskService.createTask(new Task(
                "Second task",
                "Detailed description of second task",
                LocalDate.now(),
                true,
                ann,
                ann
        ));

        taskService.createTask(new Task(
                "Third task",
                "Detailed description of third task",
                LocalDate.now().minusDays(1),
                false,
                admin
        ));

        taskService.createTask(new Task(
                "Fourth task",
                "Detailed description of fourth task",
                LocalDate.now().minusDays(10),
                true,
                admin
        ));

    }
}
