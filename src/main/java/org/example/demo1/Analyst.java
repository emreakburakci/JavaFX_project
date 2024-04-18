package org.example.demo1;

import java.time.LocalDateTime;

public class Analyst extends Employee {


    public Analyst(long id, String name, String surname, double salary, LocalDateTime birthdate, int age, float premium) {
        super(id, name, surname, salary, birthdate, age, premium);
        setEmployeeType("Analyst");
    }

    @Override
    public String work() {
        return "Analyst is working";
    }

    public String analystMessage() {
        return "Analyst is analyzing";
    }
}
