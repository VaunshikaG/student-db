//  all business logic
package com.sports.sports_db.service;

import com.sports.sports_db.entity.EmployeeEntity;
import com.sports.sports_db.model.Employee;
import com.sports.sports_db.repository.EmployeeRepositoy;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeeService {

    @Autowired
    EmployeeRepositoy employeeRepositoy;

    public List<Employee> getAllEmp() {
        try {
            List<EmployeeEntity> employees = employeeRepositoy.findAll();
            List<Employee> customEmployees = new ArrayList<>();
            employees.stream().forEach(e -> {
                Employee employee = new Employee();
                BeanUtils.copyProperties(e, employee);
                customEmployees.add(employee);
            });
            return customEmployees;
        } catch (Exception e) {
            throw e;
        }
    }

    public String addEmployee(EmployeeEntity employee) {
        try {
            if (!employeeRepositoy.exsitsByName(employee.getFirstName(), employee.getLastName())) {
                employeeRepositoy.save(employee);
                return "Employee Added Successfully!";
            } else {
                return "This Employee Already Exists in Database";
            }
        } catch (Exception e) {
            throw e;
        }
    }

    public  String removeEmployee(EmployeeEntity employee) {
        try {
            if (employeeRepositoy.exsitsByName(employee.getFirstName(), employee.getLastName())) {
                employeeRepositoy.delete(employee);
                return "Employee Deleted Successfully!";
            } else {
                return "Employee Doesn't Exists!";
            }
        } catch (Exception e) {
            throw e;
        }
    }

    public String updateEmployee(EmployeeEntity employee) {
        try {
            if (employeeRepositoy.existsById(employee.getId())) {
                employeeRepositoy.save(employee);
                return "Employee Updated Successfully!";
            } else {
                return "Employee Doesn't Exists!";
            }
        } catch (Exception e) {
            throw e;
        }
    }
}
