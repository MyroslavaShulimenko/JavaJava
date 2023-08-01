package org.example;
//
public class Re8 {
    static void getEmpl(Employee e){
        System.out.printf("%03d \t %-12s \t %-12s \t %,.1f \n",e.id, e.name,e.surname,e.salary*(1+e.bonus));
        System.out.printf(e.id + "\n"+ e.salary+"\n"+e.name);
        System.out.printf("ID: %03d \t NAME: %-12s \t %-12s \t %,.1f \n"
                , e.id, e.name, e.surname, e.salary * (1 + e.bonus));
    }
    public static void main(String[] args) {
Employee e1=new Employee(12,"Ivan", "Ivanov",2800, 1.2);
getEmpl(e1);
    }
}
class Employee{
    int id;
    String name;
    String surname;
    int salary;
    double bonus;

    public Employee(int id, String name, String surname, int salary, double bonus) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.salary = salary;
        this.bonus = bonus;
    }
}