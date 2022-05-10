package br.dev.thinkers.employee.services.impl;

import br.dev.thinkers.employee.domain.Department;

import br.dev.thinkers.employee.repositories.DepartmentRepository;
import br.dev.thinkers.employee.services.DepartmentService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class DepartmentServiceImpl implements DepartmentService {

    private final DepartmentRepository departmentRepository;

    @Override
    public void save(Department department) {
        departmentRepository.save(department);
    }

    @Override
    public void update(Department department) {
        departmentRepository.update(department);
    }

    @Override
    public void remove(String id) {
        departmentRepository.delete(id);
    }

    @Transactional(readOnly = true)
    @Override
    public Department findDepartmentById(String id) {
        return departmentRepository.findById(id);
    }

    @Transactional(readOnly = true)
    @Override
    public List<Department> loadAllDepartments() {
        return departmentRepository.findAll();
    }

    @Override
    public boolean hasPosition(String id) {
        return findDepartmentById(id).getPositions().isEmpty();
    }
}
