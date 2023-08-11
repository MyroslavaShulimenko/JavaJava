package org.example.part1;

import java.util.stream.IntStream;

public class LuhnaAlgorithm {

        public static boolean isValidCreditCardNumber(String cardNumber) {
            // Шаг 1: Удаление пробелов и невалидных символов
            String cleanedCardNumber = cardNumber.replaceAll("[^0-9]", "");

            // Шаг 2: Проверка длины номера карты
            if (cleanedCardNumber.length() < 13 || cleanedCardNumber.length() > 19) {
                return false;
            }

            // Шаг 3: Преобразование строки в массив цифр
            int[] digits = cleanedCardNumber.chars().map(Character::getNumericValue).toArray();

            // Шаг 4: Удвоение каждой второй цифры справа (начиная с предпоследней)
            IntStream.range(0, digits.length - 1)
                    .filter(i -> (digits.length - i) % 2 == 0)
                    .forEach(i -> digits[i] = (digits[i] * 2 > 9) ? digits[i] * 2 - 9 : digits[i] * 2);

            // Шаг 5: Суммирование всех цифр
            int sum = IntStream.of(digits).sum();

            // Шаг 6: Проверка, является ли сумма кратной 10
            return sum % 10 == 0;
        }

        public static void main(String[] args) {
            String cardNumber = "4149 4393 1567 8916"; // Поменяйте номер карты на тот, который хотите проверить
            if (isValidCreditCardNumber(cardNumber)) {
                System.out.println("Номер карты верен.");
            } else {
                System.out.println("Номер карты неверен.");
            }
        }


}
