package org.lld.prep.order_priority_queue;

import java.util.*;

class Order {
    int orderId;
    Date orderDate;
    Date completionDate;

    public Order(int orderId, Date orderDate, Date completionDate) {
        this.orderId = orderId;
        this.orderDate = orderDate;
        this.completionDate = completionDate;
    }

    @Override
    public String toString() {
        return "Order{id=" + orderId + ", orderDate=" + orderDate + ", completionDate=" + completionDate + "}";
    }
}


public class MainClass {
    public static void main(String[] args) {
        Queue<Order> orderQueue = new PriorityQueue<>
                (Comparator.comparing((Order o) -> o.orderDate)
                .thenComparing((Order o) -> o.completionDate));

        orderQueue.add(new Order(101, new GregorianCalendar(2025, Calendar.FEBRUARY, 10).getTime(),
                new GregorianCalendar(2025, Calendar.FEBRUARY, 15).getTime()));

        orderQueue.add(new Order(102, new GregorianCalendar(2025, Calendar.FEBRUARY, 10).getTime(),
                new GregorianCalendar(2025, Calendar.FEBRUARY, 12).getTime()));

        orderQueue.add(new Order(103, new GregorianCalendar(2025, Calendar.FEBRUARY, 8).getTime(),
                new GregorianCalendar(2025, Calendar.FEBRUARY, 14).getTime()));


        orderQueue.forEach((Order o) -> {
            System.out.println(o.toString());
        });
        
    }
}
