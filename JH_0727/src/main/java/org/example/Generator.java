package org.example;

import com.github.javafaker.Faker;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

// Написать класс Генератор, который генерирует Девелоперов и Машины
// у генератора будут два метода, которые будут генерировать машины и Девелоперов
// в зависимости от количества которые вы передадите в параметры
// Вам в помощь библиотека faker для генерации любых имен, фамилий итд
public class Generator {
    static Faker faker = new Faker();
    static Random random = new Random();

    private static Mark generateMark() {
        Mark[] marks = Mark.values();
        return marks[random.nextInt(marks.length)];
    }

    public static int speed() {
        return random.nextInt(200, 400);
    }

    public static String color() {
        return faker.color().name();
    }

    public static char gender() {
        char[] genders = {'f', 'm'};
        return genders[random.nextInt(genders.length)];
    }

    public static Car generateCar() {
        int speed = speed();
        boolean sport = speed > 200;
        return new Car(
                color(),
                sport,
                generateMark(),
                speed
        );
    }

    public static List<Developer> generateDevaloper(int quantityDeveloper) {
        List<Developer> developers = new ArrayList<>(quantityDeveloper);
        for (int i = 0; i < quantityDeveloper; i++) {
            developers.add(new Developer(
                    faker.name().firstName(),
                    faker.name().lastName(),
                    random.nextInt(16, 78),
                    random.nextInt(1500, 7000),
                    gender(),
                    generateCar()
            ));
        }
        return developers;
    }

}
