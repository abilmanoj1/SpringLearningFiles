package com.dexlock.ReactSpringProject.repository;

import com.dexlock.ReactSpringProject.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee,Long> {
}
