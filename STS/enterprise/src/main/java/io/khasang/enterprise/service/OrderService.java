package io.khasang.enterprise.service;

import org.springframework.beans.factory.annotation.Autowired;

public class OrderService {
    @Autowired
    Order order;

    public OrderService() {
    }

    public Order createOrder(Project project, String title){
        return new Order(project,title);
    }

    public boolean deleteOrder(Order order){
        if (order == null){
            return false;
        }
        return true;
    }

    public boolean confirmOrder(Order order){
        if (order == null){
            return false;
        }
        return true;
    }

    public boolean confirmOrderProgsess(Order order){
        if (order == null){
            return false;
        }
        return true;
    }
}
