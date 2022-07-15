package com.flightofdream.HRService;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequestMapping("/employee")
@RestController
public class EmployeeServiceController {
    private final EmployeeService employeeService;

    public EmployeeServiceController(EmployeeService employeeService) {

        this.employeeService=employeeService;
    }

    @GetMapping("/add")
    public Employee addEmployee(@RequestParam("fname") String firstName, @RequestParam("lname") String lastName) {
        Employee d=null;
        try {
            d=employeeService.addEmployee(firstName, lastName);
        }catch(EmployeeAlreadyAddedException e) {
           e.printStackTrace();
           System.out.println("<b>EmployeeAlreadyAdded");
        }
        return d;

    }

    @GetMapping("/remove")
    public Employee removeEmployee(@RequestParam("fname") String firstName, @RequestParam("lname") String lastName){
        Employee d=null;
        try {
            d=employeeService.removeEmployee(firstName,lastName);
        }catch(EmployeeAlreadyAddedException e) {
            e.printStackTrace();
            System.out.println("<b>EmployeeNotFound");
        }
        return d;
    }

    @GetMapping("/find")
    public Employee findEmployee(@RequestParam("fname") String firstName, @RequestParam("lname") String lastName) {
        Employee d=null;
        try {
            d=employeeService.findEmployee(firstName,lastName);
        }catch(EmployeeAlreadyAddedException e) {
            e.printStackTrace();
            System.out.println("<b>EmployeeNotFound");
        }
        return d;
    }
    @GetMapping("/list")
    public List<Employee> showEmployeeList(){
        return employeeService.showEmployeeList();
    }
}
