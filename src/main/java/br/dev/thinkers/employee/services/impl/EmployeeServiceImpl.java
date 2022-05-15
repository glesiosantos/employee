package br.dev.thinkers.employee.services.impl;

import br.dev.thinkers.employee.domain.Employee;
import br.dev.thinkers.employee.repositories.EmployeeRepository;
import br.dev.thinkers.employee.services.EmployeeService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.util.List;

@Service
@Transactional
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepository employeeRepository;

    @Override
    public void save(Employee employee) {
        employeeRepository.save(employee);
    }

    @Override
    public void update(Employee employee) {
        employeeRepository.update(employee);
    }

    @Override
    public void remove(String id) {
        employeeRepository.delete(id);
    }

    @Transactional(readOnly = true)
    @Override
    public Employee findPositionById(String id) {
        return employeeRepository.findById(id);
    }

    @Transactional(readOnly = true)
    @Override
    public List<Employee> loadAllEmployees() {
        return employeeRepository.findAll();
    }
}
