package org.example;
// Написать класс Обработчик, который будет:
// —проходится по листу девелоперов и выводить всех мужчин у которых спортивная машина
// —группировать по полу все машины, т.е. у мужчин такие, у женщин такие
// —Переводить в мапу ключ-девелопер а значение максимальная скоросьть авто
// —записывать в текстовый файл всех девелоперов в формате : Jonn-[auto: BMW ::: salary: 12345] в столбик.

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Handler {
public static List<Developer>findSportCarMan(List<Developer>developers){
    return developers.stream()
            .filter(m->m.gender.equals('m')&& m.car.isSport())
            .toList();
}
   public static Map<Character,List<Developer>>gpoupGender(List<Developer>developers){
    return developers.stream()
            .collect(Collectors.groupingBy(Developer::getGender));
   }
   public static Map<Developer,Integer>maxSpeed(List<Developer>developers){
    return developers.stream()
            .collect(Collectors.toMap(developer -> developer,developer -> developer.car.speed));
   }
    public static void writer(List<Developer> list) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("hendler.txt"))) {
            for (Developer elem : list) {
                writer.write(elem.getName() +
                        "-[auto: " + elem.getCar().getMark() +
                        ", salary: " + elem.getSalary() + "]" + "\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
