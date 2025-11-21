package com.udemyJava.course.entities;

import com.udemyJava.course.enums.OrderStatus;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.time.Instant;


@ExtendWith(MockitoExtension.class)
public class OrderTest {
    @Mock
    private User user;
    @Mock
    private OrderItem item1;
    @Mock
    private OrderItem item2;

    private Order order;

    @BeforeEach
    void setup(){
        user = new User(10L, "Vini", "vini@mail.com", "12345");
        order = new Order(
          1L,
                Instant.parse("2025-11-11T21:37:00Z"),
                user,
                OrderStatus.PAID
        );
    }
    @Test
    @DisplayName("Should return getters")
    void testBasicAttributes(){
        assertEquals(1L, order.getId());
        assertEquals(Instant.parse("2025-11-11T21:37:00Z"), order.getMoment());
        assertEquals(user, order.getClient());
        assertEquals(OrderStatus.PAID, order.getOrderStatus());
    }
    @Test
    @DisplayName("Should test set on orderStatus")
    void testSetOrderStatus(){
        order.setOrderStatus(OrderStatus.CANCELLED);
        assertEquals(OrderStatus.CANCELLED, order.getOrderStatus());
    }
    @Test
    @DisplayName("Should test equals and hashcode")
    void testEqualsAndHashCode(){
        Order order2 = new Order(1L, Instant.parse("2025-11-11T21:37:00Z"), user, OrderStatus.PAID);
        assertEquals(order, order2);
        assertEquals(order.hashCode(), order2.hashCode());
    }

    @Test
    @DisplayName("Should return item total value")
    void testGetSubTotalWithMockito(){
        when(item1.getSubTotal()).thenReturn(100.0);
        when(item2.getSubTotal()).thenReturn(250.0);

        order.getItems().add(item1);
        order.getItems().add(item2);

        double total = order.getTotal();
        assertEquals(350.0, total);

        verify(item1, times(1)).getSubTotal();
        verify(item2, times(1)).getSubTotal();
    }

    @Test
    @DisplayName("Should test payment entity getters and setters")
    void testPaymentSettersAndGetters(){
        Payment mockPayment = mock(Payment.class);
        order.setPayment(mockPayment);

        assertEquals(mockPayment, order.getPayment());
    }
}

