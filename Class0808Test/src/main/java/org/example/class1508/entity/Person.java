package org.example.class1508.entity;
//String name
//int age
//String address
//String email
//Методы:
//
//Конструктор с параметрами для инициализации полей.
//String getSummary() - возвращает строку, содержащую информацию о человеке (имя, возраст, адрес).
//boolean isAdult() - проверяет, является ли человек совершеннолетним (возраст >= 18).
//void sendEmail(String message) - имитирует отправку электронной почты.

import lombok.Getter;

//
@Getter
public class Person  implements Comparable<Person>{
    public static final int LEGAL_AGE = 18;


    private final String name;
    private final int age;
    private final String address;
    private final String email;

    public Person(String name, int age, String address, String email) {
        this.name = name;
        this.age = age;
        this.address = address;
        this.email = email;
    }

  public   String getSummary() {

        return getName() + " " + getAge() + " " + getAddress();
    }

  public   boolean isAdult() {
        return age >= LEGAL_AGE;
    }

  public   void sendEmail(String message) {


    }


    @Override
    public int compareTo(Person o) {
        return name.compareTo(o.getName());
    }
}
