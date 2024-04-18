package org.example.demo1;

public class EmployeeRepository implements IEmployeeRepository {
    @Override
    public boolean save(Employee employee) throws InvalidEmployeeIdException{
        try {
            MockDB.save(employee);
            return true;
        } catch (InvalidEmployeeIdException e) {
            throw e;
        }catch (Exception e){
            return false;
        }

    }
}
