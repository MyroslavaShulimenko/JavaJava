package org.example.class1508.service;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.example.class1508.entity.Order;
import org.example.class1508.entity.Product;
import org.example.class1508.exception.InvalidOrderException;

import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

//void addOrder(Order order) - добавляет заказ в список заказов.
//double calculateTotalRevenue() - вычисляет общую выручку от всех заказов.
//List<Order> getExpiredOrders() - возвращает список заказов, у которых истекла дата.
@AllArgsConstructor
@Getter
public class OrderProcessor {
    private List<Order> orders ;

    public void addOrder(Order order)throws InvalidOrderException {
        if (order == null || order.getProducts() == null || order.getOrderDate() == null) {
            throw new InvalidOrderException();
        }
        Map<Product, Long> map = order.getProducts().stream()
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

        for (Map.Entry<Product, Long> entry : map.entrySet()) {
            if (entry.getKey().getQuantity() < entry.getValue()) {
                throw new InvalidOrderException();
            }
        }
        orders.add(order);
    }

    public double calculateTotalRevenue2() {
        double resultTotal=0;
        for (Order order:orders
        ) {resultTotal+=order.calculateTotalPrice();}
        return resultTotal;
    }
    public double calculateTotalRevenue() {
        return orders.stream().mapToDouble(Order::calculateTotalPrice).sum();
        }


    public List<Order> getExpiredOrders() {
        return orders.stream()
                .filter(Order::isOrderExpired)
                .toList();
    }
}
