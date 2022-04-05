//  all business logic
package com.sports.sports_db.service;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sports.sports_db.entity.EmployeeEntity;
import com.sports.sports_db.model.EmployeeModel;
import com.sports.sports_db.repository.EmployeeRepositoy;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeeService {

    @Autowired
    EmployeeRepositoy employeeRepositoy;

    public List<EmployeeModel> getAllEmp() {
        try {
            List<EmployeeEntity> employees = employeeRepositoy.findAll();
            List<EmployeeModel> customEmployeeModels = new ArrayList<>();
            employees.forEach(e -> {
                EmployeeModel employeeModel = new EmployeeModel();
                BeanUtils.copyProperties(e, employeeModel);
                customEmployeeModels.add(employeeModel);
            });
            return customEmployeeModels;
        } catch (Exception e) {
            throw e;
        }
    }

    public String addEmployee(EmployeeEntity employee) {
        try {
            if (!employeeRepositoy.existsByFirstNameAndLastName(employee.getFirstName(), employee.getLastName())) {
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
            if (employeeRepositoy.existsByFirstNameAndLastName(employee.getFirstName(), employee.getLastName())) {
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
