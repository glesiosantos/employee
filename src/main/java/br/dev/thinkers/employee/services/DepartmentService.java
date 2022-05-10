package br.dev.thinkers.employee.services;

import br.dev.thinkers.employee.domain.Department;
import br.dev.thinkers.employee.domain.Position;

import java.util.List;

public interface DepartmentService {

    void save(Department department);

    void update(Department department);

    void remove(String id);

    Department findPositionById(String id);

    List<Department> loadAllPositions();

    boolean hasPosition(String id);
}
