package com.durys.jakub.companymanagement.employee.repository;

import com.durys.jakub.companymanagement.employee.model.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface JpaEmployeeRepository extends JpaRepository<Employee, Long> {

    String BASE_QUERY = "SELECT * FROM CM_EMPLOYEE";

    @Query(value = BASE_QUERY, nativeQuery = true)
    List<Employee> findAll();
}
