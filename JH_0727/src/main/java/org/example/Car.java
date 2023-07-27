package org.example;

import lombok.Getter;
import lombok.Setter;

// Написать класс машина у которой будут поля цвет, булеан-спортивная или нет,
// энам марка и инт максимальная скорость
@Getter
@Setter

public class Car {
    String color;
    boolean sport;
    Mark mark;
    int speed;

    public Car(String color, boolean sport, Mark mark, int speed) {
        this.color = color;
        this.sport = sport;
        this.mark = mark;
        this.speed = speed;
    }

    @Override
    public String toString() {
        return "Car{" +
                "color='" + color + '\'' +
                ", sport=" + sport +
                ", mark=" + mark +
                ", speed=" + speed +
                '}';
    }
}
