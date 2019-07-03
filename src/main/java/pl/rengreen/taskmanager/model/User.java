package pl.rengreen.taskmanager.model;

import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import java.util.List;
import java.util.stream.Collectors;

@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Long id;
    @Email
    @NotEmpty
    @Column(unique = true)
    private String email;
    @NotEmpty
    private String name;
    @NotEmpty
    @Length(min = 5)
    private String password;
    @Column(columnDefinition = "VARCHAR(255) DEFAULT 'images/user.png'")
    private String photo;
    @OneToMany(mappedBy = "owner", cascade = CascadeType.PERSIST)
    private List<Task> tasksOwned;

    @ManyToMany(cascade = CascadeType.MERGE)
    @JoinTable(name = "user_role",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id"))
    private List<Role> roles;

    public List<Task> getTasksCompleted() {
        return tasksOwned.stream()
                .filter(Task::isCompleted)
                .collect(Collectors.toList());
    }

    public List<Task> getTasksInProgress() {
        return tasksOwned.stream()
                .filter(task -> !task.isCompleted())
                .collect(Collectors.toList());
    }

    public boolean isAdmin(){
        String roleName="ADMIN";
        return roles.stream().map(Role::getRole).anyMatch(roleName::equals);
    }

    public User() {
    }

    public User(@Email @NotEmpty String email,
                @NotEmpty String name,
                @NotEmpty @Length(min = 5) String password,
                String photo) {
        this.email = email;
        this.name = name;
        this.password = password;
        this.photo = photo;
    }

    public User(@Email @NotEmpty String email,
                @NotEmpty String name,
                @NotEmpty @Length(min = 5) String password,
                String photo,
                List<Task> tasksOwned,
                List<Role> roles) {
        this.email = email;
        this.name = name;
        this.password = password;
        this.photo = photo;
        this.tasksOwned = tasksOwned;
        this.roles = roles;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public List<Task> getTasksOwned() {
        return tasksOwned;
    }

    public void setTasksOwned(List<Task> tasksOwned) {
        this.tasksOwned = tasksOwned;
    }

    public List<Role> getRoles() {
        return roles;
    }

    public void setRoles(List<Role> roles) {
        this.roles = roles;
    }

}
