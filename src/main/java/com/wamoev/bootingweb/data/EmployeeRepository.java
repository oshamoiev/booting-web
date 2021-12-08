package com.wamoev.bootingweb.data;

import com.wamoev.bootingweb.models.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, String> {
}
