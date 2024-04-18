package org.example.demo1;

public interface IEmployeeRepository {

    boolean save(Employee employee) throws InvalidEmployeeIdException;
}
