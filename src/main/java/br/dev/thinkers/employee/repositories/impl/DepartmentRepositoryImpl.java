package br.dev.thinkers.employee.repositories.impl;

import br.dev.thinkers.employee.domain.Department;
import br.dev.thinkers.employee.repositories.AbstractRepository;
import br.dev.thinkers.employee.repositories.DepartmentRepository;
import org.springframework.stereotype.Repository;

@Repository
public class DepartmentRepositoryImpl extends AbstractRepository<Department, String> implements DepartmentRepository {
}
