package com.udemyJava.course.resources;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.udemyJava.course.entities.User;
import com.udemyJava.course.repositories.OrderRepository;
import com.udemyJava.course.repositories.UserRepository;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Arrays;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class UserControllerIntegrationTest {
    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private ObjectMapper objectMapper;

    private User u1;
    private User u2;

    @BeforeEach
    void setup(){
        orderRepository.deleteAll();
        userRepository.deleteAll();

        u1 = new User(null, "Bruna", "bruna@mail.com", "123456");
        u2 = new User(null, "Vini", "vini@mail.com", "12345");

        userRepository.saveAll(Arrays.asList(u1, u2));
    }
    @Test
    @DisplayName("Should return all users")
    void shouldReturnAllUsers() throws Exception {
        mockMvc.perform(get("/users"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.length()").value(2))
                .andExpect(jsonPath("$[0].name").value("Bruna"))
                .andExpect(jsonPath("$[1].name").value("Vini"));
    }

    @Test
    @DisplayName("Should return user by id")
    void shouldReturnUserById() throws Exception {
        mockMvc.perform(get("/users/" + u1.getId()))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.email").value("bruna@mail.com"));
    }
}
