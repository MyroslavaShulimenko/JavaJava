package org.example.class3108;

import java.util.List;
import java.util.concurrent.Exchanger;

public class Exch {

    public static void main(String[] args) {

    }
}
enum Action{
    STONE,
    SCISSORS,
    PAPER
}
class Person extends Thread{
    private String name;
    private List<Action>actionList;
    private Exchanger<Action>exchanger;
    public Person (String name, List<Action>actionList, Exchanger<Action>exchanger){
        this.name=name;
        this.actionList=actionList;
        this.exchanger=exchanger;
        this.start();
    }

}