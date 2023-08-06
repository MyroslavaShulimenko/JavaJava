package org.example.part2;

import org.example.part1.BankCardGenerator;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.example.part1.LuhnaAlgorithm.isValidCreditCardNumber;

public class Main {
    public static void main(String[] args) {

        String card = BankCardGenerator2.generate();
        String s=BankCardGenerator2.generatorPan();
        if (isValidCreditCardNumber(s)) {
            System.out.println("Номер карты верен.");
        } else {
            System.out.println("Номер карты неверен.");
        }
        System.out.println(s);
        System.out.println("-".repeat(50));
        System.out.println(card);
        System.out.println(BankCardGenerator2.generateDevaloper(2).toString());

        System.out.println(client());
    }
    public static Map<List<Developer>,String> client(){
        Map<List<Developer>, String> map= new HashMap<>();
        map.put(BankCardGenerator2.generateDevaloper(1),BankCardGenerator2.generate());
        return map;
    }
}
