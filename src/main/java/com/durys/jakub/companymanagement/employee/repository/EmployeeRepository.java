package com.durys.jakub.companymanagement.employee.repository;

import com.durys.jakub.companymanagement.employee.model.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {
}
