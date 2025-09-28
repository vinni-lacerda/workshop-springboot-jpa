package com.udemyJava.course.entities;

//import com.udemyJava.course.enums.OrderStatus;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.io.Serializable;
import java.time.Instant;
import java.util.Date;
import java.util.Objects;

@Entity
@Table(name = "tb_order")
public class Order implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss'Z'", timezone = "GMT")
    private Instant moment;
//    private OrderStatus orderStatus;

    @ManyToOne
    @JoinColumn(name = "client_id")
    private User client;

    public User getClient() {
        return client;
    }

    public void setClient(User client) {
        this.client = client;
    }

//    public Order(Long id, Instant moment, User client, OrderStatus orderStatus) {
//        this.id = id;
//        this.moment = moment;
//        this.client = client;
//        this.orderStatus = orderStatus;
//    }


    public Order(Long id, Instant moment, User client) {
        this.id = id;
        this.moment = moment;
        this.client = client;
    }

    public Order() {
    }

    public Long getId() {
        return id;
    }
    
    public Instant getMoment() {
        return moment;
    }

    public void setMoment(Date moment) {
        this.moment = moment.toInstant();
    }

//    public OrderStatus getOrderStatus() {
//        return orderStatus;
//    }
//
//    public void setOrderStatus(OrderStatus orderStatus) {
//        this.orderStatus = orderStatus;
//    }

//    @Override
//    public boolean equals(Object o) {
//        if (o == null || getClass() != o.getClass()) return false;
//        Order order = (Order) o;
//        return Objects.equals(id, order.id) && Objects.equals(moment, order.moment) && Objects.equals(orderStatus, order.orderStatus);
//    }
//
//    @Override
//    public int hashCode() {
//        return Objects.hash(id, moment, orderStatus);
//    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Order order = (Order) o;
        return Objects.equals(id, order.id) && Objects.equals(moment, order.moment) && Objects.equals(client, order.client);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, moment, client);
    }
}
