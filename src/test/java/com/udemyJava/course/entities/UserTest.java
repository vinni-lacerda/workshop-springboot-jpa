package com.udemyJava.course.entities;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

public class UserTest {
    @Test
    @DisplayName("Should test User constructor and getters")
    void testConstructorAndGetters(){
        User user = new User(1L, "Bruna", "bruna@mail.com", "123456");
        assertEquals(1L, user.getId());
        assertEquals("Bruna", user.getName());
        assertEquals("bruna@mail.com", user.getEmail());
        assertEquals("123456", user.getPassword());
    }

    @Test
    @DisplayName("Should test User setters")
    void testSetters(){
        User user = new User();
        user.setId(2L);
        user.setName("vini");
        user.setEmail("vini@mail.com");
        user.setPassword("12347");

        assertEquals(2L, user.getId());
        assertEquals("vini", user.getName());
        assertEquals("vini@mail.com", user.getEmail());
        assertEquals("12347", user.getPassword());
    }
    @Test
    void testOrderListInitilized(){
        User user = new User();

        assertNotNull(user.getOrders());
        assertTrue(user.getOrders().isEmpty());
    }

    @Test
    @DisplayName("Should test equals and hashcode")
    void testEqualsAndHashCode(){
        User u1 = new User(1L, "Bruna", "bruna@mail.com", "123456");
        User u2 = new User(1L, "Bruna", "bruna@mail.com", "123456");
        assertEquals(u1, u2);
        assertEquals(u1.hashCode(), u2.hashCode());
    }

    @Test
    @DisplayName("Should test equals with diferent ids")
    void testNotEqualsDifferentId(){
        User u1 = new User(1L, "Bruna", "bruna@mail.com", "123456");
        User u2 = new User(2L, "Bruna", "bruna@mail.com", "123456");

        assertNotEquals(u1, u2);
    }

    @Test
    void testAddMockerOrder(){
        User user = new User(1L, "kocmoc", "kocmoc@mail.com", "123456");

        Order mockedOrder = Mockito.mock(Order.class);
        when(mockedOrder.getId()).thenReturn(10L);
        when(mockedOrder.getClient()).thenReturn(user);

        user.getOrders().add(mockedOrder);

        assertEquals(1, user.getOrders().size());
        assertEquals(10L, user.getOrders().get(0).getId());
        assertEquals(user, user.getOrders().get(0).getClient());

        verify(mockedOrder, times(1)).getId();
        verify(mockedOrder, times(1)).getClient();
    }
}
