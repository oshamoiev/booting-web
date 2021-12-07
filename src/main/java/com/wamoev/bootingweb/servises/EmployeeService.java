package com.wamoev.bootingweb.servises;

import com.wamoev.bootingweb.models.Employee;
import com.wamoev.bootingweb.models.Position;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class EmployeeService {
    private static final List<Employee> employees = new ArrayList<>();

    static {
        employees.add(new Employee(UUID.randomUUID().toString(), "John", "Doe", Position.CONCIERGE));
        employees.add(new Employee(UUID.randomUUID().toString(), "Jane", "Mo", Position.FRONT_DESK));
        employees.add(new Employee(UUID.randomUUID().toString(), "Oliver", "Riha", Position.HOUSEKEEPING));
        employees.add(new Employee(UUID.randomUUID().toString(), "Sam", "Sal", Position.SECURITY));
    }

    public List<Employee> getEmployees() {
        return employees;
    }
}
