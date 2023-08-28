package org.example.home2023_08_24;

public class Consumer {
    private final Warehouse warehouse;

    public Consumer(Warehouse warehouse) {
        this.warehouse = warehouse;
    }

    public void consumeItems(int amount){
        warehouse.consume(amount);
    }
}
