package br.dev.thinkers.employee.repositories.impl;

import br.dev.thinkers.employee.domain.Employee;
import br.dev.thinkers.employee.repositories.AbstractRepository;
import br.dev.thinkers.employee.repositories.EmployeeRepository;
import org.springframework.stereotype.Repository;

@Repository
public class EmployeeRepositoryImpl extends AbstractRepository<Employee, String> implements EmployeeRepository {
}
