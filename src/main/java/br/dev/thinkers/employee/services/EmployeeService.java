package br.dev.thinkers.employee.services;

import br.dev.thinkers.employee.domain.Employee;

import java.util.List;


public interface EmployeeService {

    void save(Employee employee);

    void update(Employee employee);

    void remove(String id);

    Employee findPositionById(String id);

    List<Employee> loadAllEmployees();
}
