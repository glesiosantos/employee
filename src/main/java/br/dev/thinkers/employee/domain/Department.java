package br.dev.thinkers.employee.domain;

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
}
