package org.example;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");

        List<Developer> developers = Generator.generateDevaloper(20);
        System.out.println("-".repeat(50));
        System.out.println(developers);

       System.out.println("SportCar = speed>200");
        System.out.println(Handler.findSportCarMan(developers));
        System.out.println("-".repeat(50));

       System.out.println(Handler.gpoupGender(developers));
        System.out.println("-".repeat(50));

        System.out.println(Handler.maxSpeed(developers));
        System.out.println("-".repeat(50));

        Handler.writer(developers);
    }

}