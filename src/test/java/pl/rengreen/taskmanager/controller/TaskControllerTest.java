package pl.rengreen.taskmanager.controller;

import org.junit.Before;
import org.junit.Test;
import org.mockito.*;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import pl.rengreen.taskmanager.model.Task;
import pl.rengreen.taskmanager.service.TaskService;

import static org.hamcrest.Matchers.*;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

public class TaskControllerTest {

    @Mock
    TaskService taskServiceMock;

    @InjectMocks
    TaskController taskController;
    private MockMvc mockMvc;

    @Before
    @WithMockUser(username = "admin",authorities = {"ADMIN"})
    public void setup(){
        MockitoAnnotations.initMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(taskController).build();
    }

    @Test
    public void updateTask_shouldReturnStatusOkAndFilledTaskFormAsViewNameAndTaskAsAttribute() throws Exception {
        Long id = 1L;

        when(taskServiceMock.getTaskById(id)).thenReturn(new Task());

        mockMvc.perform(get("/task/edit/1"))
                .andExpect(status().isOk())
                .andExpect(view().name("views/filledTaskForm"))
                .andExpect(model().attribute("task", instanceOf(Task.class)));
    }

    @Test
    public void deleteTask_shouldInvokeDeleteTaskMethodAndRedirectToTasks() throws Exception {
        Long id = 1L;

        mockMvc.perform(get("/task/delete/1"))
                .andExpect(status().is3xxRedirection())
                .andExpect(view().name("redirect:/tasks"));

        verify(taskServiceMock, times(1)).deleteTask(id);
    }
}