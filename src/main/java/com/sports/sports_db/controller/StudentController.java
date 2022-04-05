package com.sports.sports_db.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.sports.sports_db.entity.StudentEntity;
import com.sports.sports_db.model.StudentModel;
import com.sports.sports_db.service.StudentService;

@RestController
@CrossOrigin(origins = "*")
public class StudentController {

    @Autowired
    StudentService employeeService;

    @RequestMapping(value = "getstudent", method = RequestMethod.GET)
    public List<StudentModel> getStudent() {
        return employeeService.getStudent();
    }

    @RequestMapping(value = "addstudent", method = RequestMethod.POST)
    public String addStudent(@RequestBody StudentEntity student) {
        return employeeService.addStudent(student);
    }

    @RequestMapping(value = "updatestudent", method = RequestMethod.PUT)
    public String updateStudent(@RequestBody StudentEntity student) {
        return employeeService.updateStudent(student);
    }

    @RequestMapping(value = "deletestudent", method = RequestMethod.DELETE)
    public String deleteStudent(@RequestBody StudentEntity student) {
        return employeeService.removeStudent(student);
    }
}
