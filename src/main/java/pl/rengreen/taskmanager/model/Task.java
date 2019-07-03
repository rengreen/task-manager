package pl.rengreen.taskmanager.model;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.FutureOrPresent;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.*;
import java.time.temporal.ChronoUnit;

@Entity
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "task_id")
    private Long id;
    @NotEmpty
    private String name;
    @NotEmpty
    @Column(length = 1200)
    @Size(max = 1200)
    private String description;
    @NotNull
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate date;
    private boolean isCompleted;
    private String creatorName;
    @ManyToOne
    @JoinColumn(name = "OWNER_ID")
    private User owner;

    public long daysLeftUntilDeadline(LocalDate date) {
        return ChronoUnit.DAYS.between(LocalDate.now(), date);
    }

    public Task() {
    }

    public Task(@NotEmpty String name,
                @NotEmpty @Size(max = 1200) String description,
                @NotNull @FutureOrPresent LocalDate date,
                boolean isCompleted,
                String creatorName) {
        this.name = name;
        this.description = description;
        this.date = date;
        this.isCompleted = isCompleted;
        this.creatorName = creatorName;
    }

    public Task(@NotEmpty String name,
                @NotEmpty @Size(max = 1200) String description,
                @NotNull LocalDate date,
                boolean isCompleted,
                String creatorName,
                User owner) {
        this.name = name;
        this.description = description;
        this.date = date;
        this.isCompleted = isCompleted;
        this.creatorName = creatorName;
        this.owner = owner;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public boolean isCompleted() {
        return isCompleted;
    }

    public void setCompleted(boolean completed) {
        isCompleted = completed;
    }

    public String getCreatorName() {
        return creatorName;
    }

    public void setCreatorName(String creatorName) {
        this.creatorName = creatorName;
    }

    public User getOwner() {
        return owner;
    }

    public void setOwner(User owner) {
        this.owner = owner;
    }

    @Override
    public String toString() {
        return "Task{" +
                "name='" + name + '\'' +
                ", creatorName='" + creatorName + '\'' +
                ", owner=" + owner +
                '}';
    }
}
