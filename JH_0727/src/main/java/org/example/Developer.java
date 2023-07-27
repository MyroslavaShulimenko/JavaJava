package org.example;
//Написать класс Девелопер у которого будет имя, фамилия , возраст, зарплата,
// чар- пол и машина

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class Developer {
    String name;
    String surName;
    int age;
    int salary;
    Character gender;
    Car car;

    @Override
    public String toString() {
        return
                "Name='" + name + '\'' +
                ", surName='" + surName + '\'' +
                ", age=" + age +
                ", salary=" + salary +
                ", gender=" + gender + "\n"+
                " car=" + car +"\n";

    }
}
