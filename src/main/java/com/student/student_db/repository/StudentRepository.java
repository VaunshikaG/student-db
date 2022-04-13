//  to connect with db

package com.student.student_db.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.student.student_db.entity.StudentEntity;

@Repository
public interface StudentRepository extends JpaRepository<StudentEntity, Integer> {

    public boolean existsByFirstNameAndLastName(String firstname, String lastname);

    public boolean existsById(int id);
}
