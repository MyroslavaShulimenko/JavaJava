package org.example.class1508.entity;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PersonTest {

    @Test
    void isAdultTest() {
        Person person1=new Person("person1",Person.LEGAL_AGE-1,"a1","email1");
        Person person2=new Person("person2",Person.LEGAL_AGE,"a2","email2");
        Person person3=new Person("person3",Person.LEGAL_AGE+1,"a3","email3");

        assertFalse(person1.isAdult());
        assertTrue(person2.isAdult());
        assertTrue(person3.isAdult());
    }

    @Test
    void compareToTest() {
        Person person1=new Person("person1",Person.LEGAL_AGE-1,"a1","email1");
        Person person2=new Person("person1",Person.LEGAL_AGE,"a2","email2");
        Person person3=new Person("person3",Person.LEGAL_AGE+1,"a3","email3");

        assertTrue(person1.compareTo(person3)<0);
        assertEquals(0,person1.compareTo(person2));
        assertTrue(person3.compareTo(person1)>0);
    }
}