package org.example.demo1;

import java.time.LocalDateTime;

public class Tester extends Employee {


    public Tester(long id, String name, String surname, double salary, LocalDateTime birthdate, int age, float premium) {
        super(id, name, surname, salary, birthdate, age, premium);
        setEmployeeType("Tester");
    }

    @Override
    public String work() {
        return "Tester is working";
    }

    public String testerMessage() {
        return "Tester is testing";
    }
}
