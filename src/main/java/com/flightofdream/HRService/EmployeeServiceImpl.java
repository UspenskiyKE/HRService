package com.flightofdream.HRService;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService{
    private final List<Employee> employeeList=new ArrayList<>();
    private final int listSize=5;

    public Employee addEmployee( String firstName, String lastName) {

            Employee e = new Employee(firstName, lastName);
            if(!employeeList.contains(e)) {

                if(employeeList.size()<listSize) {

                    employeeList.add(e);
                }else {
                    throw new EmployeeStorageIsFullException("Employee Storage Is Full!");
                }

            }else {
                throw new EmployeeAlreadyAddedException("Employee Is Already Added!");

            }
            return e;
    }

    public Employee removeEmployee( String firstName, String lastName) {
        Employee f=findEmployee(firstName,lastName);
        if(f!=null) {
            employeeList.remove(f);
        }else{
            throw new EmployeeNotFoundException("Employee Is Not Found!");
        }
        return f;
    }

    public Employee findEmployee(String firstName, String lastName) {
        Employee e1=new Employee(firstName,lastName);
        Employee result=null;
        if (employeeList.contains(e1)) {
            result=e1;
        }else {
            throw new EmployeeNotFoundException("Employee Is Not Found!");
        }
        return result;
    }

    public List<Employee> showEmployeeList(){
        return employeeList;
    }
}
