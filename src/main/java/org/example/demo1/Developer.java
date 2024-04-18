package org.example.demo1;

import java.time.LocalDateTime;

public class Developer extends  Employee{


    public Developer(long id, String name, String surname, double salary, LocalDateTime birthdate, int age, float premium) {
        super(id, name, surname, salary, birthdate, age, premium);
        setEmployeeType("Developer");
    }

    @Override
    public String work() {
        return "Developer is working";
    }


    public String developerMessage() {
        return "Developer is developing";
    }
}
