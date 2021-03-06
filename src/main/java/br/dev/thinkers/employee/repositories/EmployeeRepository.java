package br.dev.thinkers.employee.repositories;

import br.dev.thinkers.employee.domain.Employee;

import java.util.List;

public interface EmployeeRepository {
    void save(Employee employee);
    void update(Employee employee);
    void delete(String id);
    Employee findById(String id);
    List<Employee> findAll();
}
