package org.example.demo1;

import java.time.LocalDateTime;

public abstract class Employee {

    private long id;
    private String name;
    private String surname;

    private double salary;

    private LocalDateTime birthdate;

    private int age;


    private float premium;

    private String employeeType;






    public Employee(long id, String name, String surname, double salary, LocalDateTime birthdate, int age, float premium) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.salary = salary;
        this.birthdate = birthdate;
        this.age = age;
        this.premium = premium;

    }
    public abstract String work();


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public LocalDateTime getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(LocalDateTime birthdate) {
        this.birthdate = birthdate;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public float getPremium() {
        return premium;
    }

    public void setPremium(float premium) {
        this.premium = premium;
    }

    public String getEmployeeType() {
        return employeeType;
    }

    public void setEmployeeType(String employeeType) {
        this.employeeType = employeeType;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", salary=" + salary +
                ", birthdate=" + birthdate +
                ", age=" + age +
                ", premium=" + premium +
                ", employeeType='" + employeeType + '\'' +
                '}';
    }
}
