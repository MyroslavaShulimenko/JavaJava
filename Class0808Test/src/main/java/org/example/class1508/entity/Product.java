package org.example.class1508.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;

//double getTotalPrice() - возвращает общую стоимость продукта (цена * количество).
//boolean isAvailable() - проверяет, доступен ли продукт для заказа (количество > 0).
//String getCategory() - возвращает категорию продукта.
@AllArgsConstructor
@Getter
public class Product {
    private String name;
    private double price;
    private int quantity;
    private String category;

    public double getTotalPrice() {
        return price * quantity;
    }

    public boolean isAvailable() {
        return quantity > 0;
    }

    public String getCategory() {
        return category;
    }
}
