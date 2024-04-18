package org.example.demo1;

import java.time.LocalDateTime;

public class MockDB {



    private static Employee[] employees = new Employee[100];
    private static int index = 0;



    public static void save(Employee employee) throws InvalidEmployeeIdException{
        // if employees id contained in the array throw exception
        for(Employee employee1 : employees){
            if(employee1 != null && employee1.getId() == employee.getId()){
                throw new InvalidEmployeeIdException("Employee with id " + employee.getId() + " already exists");
            }
        }

        employees[index] = employee;
        index++;
    }

    public static void save(long id, String name, String surname, double salary, LocalDateTime birthDate, int age,float premium, String employeeType) throws InvalidEmployeeIdException{
        if(employeeType.equals("Developer")){
            Developer developer = new Developer(id, name, surname, salary, birthDate, age,premium);
            save(developer);
}else if(employeeType.equals("Tester")){
            Tester tester = new Tester(id, name, surname, salary, birthDate, age,premium);
            save(tester);
        }else if(employeeType.equals("Analyst")){
            Analyst analyst = new Analyst(id, name, surname, salary, birthDate, age,premium);
            save(analyst);
        }else{
            throw new InvalidEmployeeIdException("Invalid employee type");
        }


    }

    public static Employee[] getEmployees(){
        return employees;
    }

    public Employee getEmployeeById(long id){
        for(Employee employee : employees){
            if(employee.getId() == id){
                return employee;
            }
        }
        return null;

    }

    public static void setEmployees(Employee[] employees) {
        MockDB.employees = employees;
    }

    public static int getIndex() {
        return index;
    }



}
