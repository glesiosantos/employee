package br.dev.thinkers.employee.controller.dto;

import br.dev.thinkers.employee.domain.Department;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DepartmentDto {

    private String id;
    private String name;

    public DepartmentDto() {}

    public DepartmentDto(Department department) {
        this.id = department.getId();
        this.name = department.getName();
    }
}
