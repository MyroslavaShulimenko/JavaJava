package org.example.part1;

import java.time.YearMonth;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
//Создать класс Хранилище:
//- Map (храниться минимум 25 Клиентов. Ключ -> Клиент, Значение -> баланс)
//
//Написать в хранилище методы, которые на вход получают Map
// (+ может ещё какой параметр), а на выходе делают следующее:
//
//- Выводят всех клиентов, у которых определенный статус карты.
//- Группируют по балансу: у кого больше или меньше какой-то суммы.
//- Средний баланс по клиентам.
//- Выводят только номера карт всех клиентов в формате имя -> номер.
//- Выводят всех клиентов, у кого закончился срок действия карт.
//- Сортируют по балансу.
//- Группируют: у кого закончился срок карт, а у кого нет.
// */
public class DataStore {
    private Map<Client, Long> clientBalance = new HashMap<>();

    public void add(Client client) {
        clientBalance.put(client, client.getBalance());
    }

    public void printClientsWithCardStatus(Status status) {
        clientBalance.keySet().stream()
                .filter(client -> client.getCard().getStatus().equals(status))
                .forEach(System.out::println);
    }

    public void printGroupingByBalance(long threshold) {
        Map<String, List<Client>> grouped = clientBalance.entrySet().stream().collect(
                Collectors.groupingBy(
                        entry -> entry.getKey().getBalance() > threshold ? "GREATER" : "LESS_OR_EQUAL",
                        Collectors.mapping(Map.Entry::getKey, Collectors.toList())
                )
        );

        System.out.println(grouped);
    }

    public void printAverageBalance() {
        double average = clientBalance.values().stream()
                .mapToLong(num -> num)
                .average()
                .orElse(0);

        System.out.printf("%.2f\n", average);
    }

    public void printClientsWithCardNumbers() {
        for (Client client : clientBalance.keySet()) {
            System.out.printf("%s -> %s\n", client.getName(), client.getCard().getPan());
        }
    }

    public void printClientsWithExpiredCards() {
        YearMonth now = YearMonth.now();

        clientBalance.keySet().stream()
                .filter(client -> client.getCard().isExpired(now))
                .forEach(System.out::println);
    }

    public void printClientsSortedByBalance() {
        clientBalance.entrySet().stream()
                .sorted(Comparator.comparingLong(Map.Entry::getValue))
                .map(Map.Entry::getKey)
                .forEach(System.out::println);
    }

    public void printGroupingByCardExpired() {
        YearMonth now = YearMonth.now();

        Map<Boolean, List<Client>> grouped = clientBalance.keySet().stream()
                .collect(Collectors.groupingBy(client -> client.getCard().isExpired(now)));
        System.out.println(grouped);
    }

    @Override
    public String toString() {
        return "Store{" +
                "clientBalance=" + clientBalance +
                '}';
    }
}
