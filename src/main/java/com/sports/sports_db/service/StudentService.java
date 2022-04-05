//  all business logic
package com.sports.sports_db.service;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sports.sports_db.entity.StudentEntity;
import com.sports.sports_db.model.StudentModel;
import com.sports.sports_db.repository.StudentRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class StudentService {

    @Autowired
    StudentRepository studentRepositoy;

    public List<StudentModel> getStudent() {
        try {
            List<StudentEntity> student = studentRepositoy.findAll();
            List<StudentModel> customStudentModels = new ArrayList<>();
            student.forEach(s -> {
                StudentModel studentModel = new StudentModel();
                BeanUtils.copyProperties(s, studentModel);
                customStudentModels.add(studentModel);
            });
            return customStudentModels;
        } catch (Exception e) {
            throw e;
        }
    }

    public String addStudent(StudentEntity student) {
        try {
            if (!studentRepositoy.existsByFirstNameAndLastName(student.getFirstName(), student.getLastName())) {
                studentRepositoy.save(student);
                return "Student Added Successfully!";
            } else {
                return "This Student Already Exists in Database";
            }
        } catch (Exception e) {
            throw e;
        }
    }

    public  String removeStudent(StudentEntity student) {
        try {
            if (studentRepositoy.existsByFirstNameAndLastName(student.getFirstName(), student.getLastName())) {
                studentRepositoy.delete(student);
                return "Student Deleted Successfully!";
            } else {
                return "Student Doesn't Exists!";
            }
        } catch (Exception e) {
            throw e;
        }
    }

    public String updateStudent(StudentEntity student) {
        try {
            if (studentRepositoy.existsById(student.getId())) {
                studentRepositoy.save(student);
                return "Student Updated Successfully!";
            } else {
                return "Student Doesn't Exists!";
            }
        } catch (Exception e) {
            throw e;
        }
    }
}
