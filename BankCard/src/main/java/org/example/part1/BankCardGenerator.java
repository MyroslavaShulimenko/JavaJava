package org.example.part1;

import java.util.Random;
import java.util.stream.Collectors;

public class BankCardGenerator {
    private static Random random= new Random();
//Сделать класс ГенераторДанныхБанковскойКарты, который будет возвращать Данные Карты (String)
//Данные карты должны быть String вида:
//
//12345678123456780000999
//Первые 16 цифр это номер
//Потом дата (месяц/год)
//Потом CVV код
//    public BankCardGenerator() {
//        this.random = random;
//    }

    public static String generate() {
        String pan = random.ints(16, 0, 10)
                .mapToObj(Integer::toString)
                .collect(Collectors.joining());
//        String dateCVV = String.format(
//                "%02d%02d%03d",
//                random.nextInt(1, 13),
//                random.nextInt(21, 30),
//                random.nextInt(1, 1000)
//        );
      //  return pan +" "+ dateCVV;
        return pan ;
    }

}
