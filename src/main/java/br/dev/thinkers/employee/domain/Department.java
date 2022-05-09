package br.dev.thinkers.employee.domain;

import br.dev.thinkers.employee.controller.dto.DepartmentDto;
import lombok.*;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "departments")
public class Department extends AbstractEntity<String> {

    private String name;

    @OneToMany(mappedBy = "department")
    private List<Position> positions;

    public Department(){}

    public Department(DepartmentDto obj) {
        if (!obj.getId().isBlank()) {
            this.setId(obj.getId());
        }

        this.name = obj.getName();
    }
}
