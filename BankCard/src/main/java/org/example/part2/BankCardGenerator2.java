package org.example.part2;

import com.github.javafaker.Faker;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class BankCardGenerator2 {
    static Faker faker = new Faker();

    private static final Random random= new Random();
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
        String pan = generatorPan();
       String dateCVV= generatorDateCVV();
       Currency2 currency2=getRandomCurrency();
       Double balance = getBalance();
       Status status=getStatusBankCard();
          return "\n № = "+pan +"\n dateCVV =  "+ dateCVV+"\n currency - "+currency2+"\n balance = "+balance+"\n status - "+status;
    }

    private static String generatorDateCVV() {
       return   String.format(
                "%02d%02d%03d",
                random.nextInt(1, 13),
                random.nextInt(21, 30),
                random.nextInt(1, 1000)
        );
    }

    public static String generatorPan() {
        return random.ints(16, 0, 10)
                .mapToObj(Integer::toString)
                .collect(Collectors.joining());
    }
    public static List<Developer> generateDevaloper(int quantityDeveloper) {
        List<Developer> developers = new ArrayList<>(quantityDeveloper);
        for (int i = 0; i < quantityDeveloper; i++) {
            developers.add(new Developer(
                    faker.name().firstName(),
                    faker.name().lastName(),
                    random.nextInt(16, 78)
            ));
        }
        return developers;
    }

    public static double getBalance() {
        return random.nextDouble(1_000_000);
    }

    public static Currency2 getRandomCurrency(){
        Currency2[] currencies = Currency2.values();
        return currencies[random.nextInt(currencies.length)];
    }

    public static Status getStatusBankCard(){
        Status[] statuses = Status.values();
        return statuses[random.nextInt(statuses.length)];
    }
}
