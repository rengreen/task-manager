package pl.rengreen.taskmanager.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.rengreen.taskmanager.model.Task;

@Repository
public interface TaskRepository extends JpaRepository<Task, Long> {

}