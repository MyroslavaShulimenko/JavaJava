package org.example.class1508.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDate;
import java.util.List;
//double calculateTotalPrice() - вычисляет общую стоимость заказа на основе продуктов.
//int getNumberOfProducts() - возвращает количество продуктов в заказе.
//boolean isOrderExpired() - проверяет, истекла ли дата заказа.
@AllArgsConstructor
@Getter
public class Order {
    public static final int DAYS_BEFOR_EXPIRATION = 7;
    private int orderId;
    private Person customer;
    private List<Product> products;
    private LocalDate orderDate;

    public Order() {
    }

    public   double calculateTotalPrice(){
      double totalPrice=0.0;
      for (Product product:products)
      {totalPrice+=product.getPrice();}
         return totalPrice;
      }
   public int getNumberOfProducts(){
      return products.size();
    }
    public boolean isOrderExpired(){
     LocalDate localDate=LocalDate.now();
      return orderDate.isBefore(LocalDate.now().minusDays(DAYS_BEFOR_EXPIRATION));
    }
}
