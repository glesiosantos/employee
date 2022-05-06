package br.dev.thinkers.employee.domain;

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
}
