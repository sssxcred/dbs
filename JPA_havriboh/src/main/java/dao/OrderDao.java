package dao;

import entities.Order;

import java.time.LocalDate;
import java.util.List;

public class OrderDao extends BaseDao<Order, Integer>{
    public OrderDao() {
        super(Order.class);
    }

    public void create(String number, LocalDate date, String discount, Integer customerId) {
        Order order = new Order(number, date, discount, customerId);
        getEntityManager().persist(order);
        System.out.println("Order created: " + number);
    }

}
