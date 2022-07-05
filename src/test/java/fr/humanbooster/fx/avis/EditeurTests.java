package fr.humanbooster.fx.avis;

import com.fasterxml.jackson.databind.ObjectMapper;
import fr.humanbooster.fx.avis.service.EditeurService;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class EditeurTests {

    @Autowired
    private EditeurService editeurService;

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private MockMvc mockMvc;

    @Test
    @Order(1)
    public void testAdd() throws Exception {
        mockMvc.perform(
                MockMvcRequestBuilders.post("/api/editeurs/xxx"))
                .andExpect((ResultMatcher) MockMvcResultMatchers.jsonPath("$.nom", "xxx"))
                .andExpect(status().isOk())
                .andDo(MockMvcResultHandlers.print());
    }

    @Test
    @Order(2)
    public void testDelete() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.delete("/api/editeur/1"))
                .andExpect(status().isOk())
                .andDo(MockMvcResultHandlers.print());
    }
}
