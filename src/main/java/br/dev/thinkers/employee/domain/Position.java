package br.dev.thinkers.employee.domain;

import br.dev.thinkers.employee.controller.dto.PositionDTO;
import lombok.*;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "positions")
public class Position extends AbstractEntity<String> {

    private String name;

    @ManyToOne
    @JoinColumn(name = "department_id")
    private Department department;

    @OneToMany(mappedBy = "position")
    private List<Employee> employees;

    public Position() {}

    public Position(PositionDTO dto, Department department) {
        if(!dto.getId().isBlank()) {
            setId(dto.getId());
        }
        this.name = dto.getName();
        this.department = department;
    }
}
