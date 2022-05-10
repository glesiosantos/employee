package br.dev.thinkers.employee.services;

import br.dev.thinkers.employee.domain.Department;

import java.util.List;

public interface DepartmentService {

    void save(Department department);

    void update(Department department);

    void remove(String id);

    Department findDepartmentById(String id);

    List<Department> loadAllDepartments();

    boolean hasPosition(String id);
}
