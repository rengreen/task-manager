package pl.rengreen.taskmanager.controller;

import org.junit.Before;
import org.junit.Test;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

public class IndexControllerTest {
    private MockMvc mockMvc;

    @Before
    public void setup(){
        IndexController indexController = new IndexController();
        mockMvc= MockMvcBuilders.standaloneSetup(indexController).build();
    }

    @Test
    public void index_shouldReturnStatusOkAndIndexAsViewName() throws Exception {
        mockMvc.perform(get("/"))
                .andExpect(status().isOk())
                .andExpect(view().name("index"));
    }
}