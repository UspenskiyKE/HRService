package com.flightofdream.HRService;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService{
    private static List<Employee> employeeList=new ArrayList<>();

    public Employee addEmployee( String firstName, String lastName) {

            Employee e = new Employee(firstName, lastName);
            if(!employeeList.contains(e)) {
                employeeList.add(e);

            }else {

                throw new EmployeeAlreadyAddedException("Сотрудник уже есть в списке!");

            }
            return e;

    }

    public Employee removeEmployee( String firstName, String lastName) {
        Employee f=findEmployee(firstName,lastName);
        Employee d=null;
        if(f!=null) {
            d=f;

            employeeList.remove(f);
        }else{
            throw new EmployeeNotFoundException("Удаление невозможно: сотрудник не найден!");
        }
        return d;
    }

    public Employee findEmployee(String firstName, String lastName) {
        Employee e1=new Employee(firstName,lastName);
        Employee e2;
        Employee result=null;
        for ( int i = 0; i < employeeList.size(); i++) {
            e2=employeeList.get(i);
            if(e1.equals(e2)) {
                System.out.println(e2); result=e2; break; }
        }
        if(result==null){

            throw new EmployeeNotFoundException("Сотрудник не найден!");
        }
        return result;

    }

    public List<Employee> showEmployeeList(){
        return employeeList;
    }
}
