package org.example.home2023_08_24;
//Обеспечивает хранение и управление товарами на складе.
//Содержит поле capacity для ограничения вместимости склада.+
//Содержит поле availableItems для отслеживания доступного количества товаров на складе.+
//Метод produce(int amount): Добавляет заданное количество товаров на склад.+
//Если нет места на складе, блокирует поток до освобождения места.
//Метод consume(int amount): Изымает заданное количество товаров со склада.
//Если товаров недостаточно, блокирует поток до появления достаточного количества товаров.
//

public class Warehouse {
    private int capacity;
    private volatile int availableItems;

    public Warehouse(int capacity, int availableItems) {
        if (capacity <= 0 || availableItems < 0) {
            throw new IllegalArgumentException();
        }
        this.capacity = capacity;
        this.availableItems = availableItems;
    }

    public synchronized void produce1(int amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException();
        }
        int temp = capacity - availableItems;
            for (int i = 1; i < amount; i++) {
                while (temp > amount) {
                    try {
                        wait();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
                notifyAll();
                availableItems++;
                temp--;
            }

        availableItems = availableItems + amount;

    }

    public synchronized void produce(int amount) {
        int temp=capacity;
        if (amount <= 0) {
            throw new IllegalArgumentException();
        }
        for (int i = 1; i <= amount; i++) {
            while (capacity == 0) {
                try {
                    System.out.println("Producer  ждет место на складе");
                    wait();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
            notifyAll();
            availableItems++;
            capacity--;
            System.out.println("Производим и кладем на склад availableItems =  " + availableItems);
           if (availableItems==temp){System.out.println("Склад заполнен  - "+availableItems);}
        }
    }
    public synchronized void consume(int amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException();
        }
        for (int i = 1; i <= amount ; i++) {
            while(availableItems == 0){
                try {
                    System.out.println("Consumer ждет поступления  товара");
                    wait();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
            notifyAll();
            availableItems--;
            capacity++;
            System.out.println(" товар выдали - "+capacity+" остаток на складе = "+ availableItems);
            if (availableItems==0){System.out.println("Склад пуст  - "+availableItems);}

        }
    }
}
