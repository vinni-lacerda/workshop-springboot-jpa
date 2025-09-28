package com.udemyJava.course.config;

import com.udemyJava.course.entities.Order;
import com.udemyJava.course.entities.User;
import com.udemyJava.course.repositories.OrderRepository;
import com.udemyJava.course.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.time.Instant;
import java.util.Arrays;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private OrderRepository orderRepository;

    @Override
    public void run(String... args) throws Exception {
        User u1 = new User(null, "Maria Brown", "maria@gmail.com", "988888888");
        User u2 = new User(null, "Alex Green", "alex@gmail.com", "977777777");

        Order o1 = new Order(null, Instant.parse("2025-09-24T19:50:07Z"), u1);
        Order o2 = new Order(null, Instant.parse("2025-09-25T22:50:07Z"), u2);
        Order o3 = new Order(null, Instant.parse("2025-09-26T23:50:07Z"), u1);

        userRepository.saveAll(Arrays.asList(u1, u2));
        orderRepository.saveAll(Arrays.asList(o1, o2, o3));
    }
}
