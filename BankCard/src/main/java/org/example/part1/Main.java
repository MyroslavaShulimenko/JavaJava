package org.example.part1;


import static org.example.part1.LuhnaAlgorithm.isValidCreditCardNumber;

public class Main {
    public static void main(String[] args) {

        String card = BankCardGenerator.generate();
        if (isValidCreditCardNumber(card)) {
            System.out.println("Номер карты верен.");
        } else {
            System.out.println("Номер карты неверен.");
        }
        System.out.println("-".repeat(50));
        System.out.println(card);
    }
}