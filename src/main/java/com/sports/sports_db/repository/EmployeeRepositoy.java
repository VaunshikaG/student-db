//  to connect with db

package com.sports.sports_db.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sports.sports_db.entity.EmployeeEntity;

@Repository
public interface EmployeeRepositoy extends JpaRepository<EmployeeEntity, Integer> {

    public boolean existsByFirstNameAndLastName(String firstname, String lastname);

    public boolean existsById(int id);
}
