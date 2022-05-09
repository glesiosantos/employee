package br.dev.thinkers.employee.repositories;

import br.dev.thinkers.employee.domain.Department;

import java.util.List;

public interface DepartmentRepository {
    void save(Department department);
    void update(Department department);
    void delete(String id);
    Department findById(String id);
    List<Department> findAll();
}
