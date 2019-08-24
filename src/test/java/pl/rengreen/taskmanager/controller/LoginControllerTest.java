package pl.rengreen.taskmanager.controller;

import org.junit.Before;
import org.junit.Test;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

public class LoginControllerTest {
    private MockMvc mockMvc;

    @Before
    public void setup(){
        LoginController loginController = new LoginController();
        mockMvc= MockMvcBuilders.standaloneSetup(loginController).build();
    }
    @Test
    public void showLoginForm_shouldReturnStatusOkAndLoginFormAsViewName() throws Exception {
        mockMvc.perform(get("/login"))
                .andExpect(status().isOk())
                .andExpect(view().name("views/loginForm"));
    }
}