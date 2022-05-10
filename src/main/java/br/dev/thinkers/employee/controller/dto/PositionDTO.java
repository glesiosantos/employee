package br.dev.thinkers.employee.controller.dto;

import br.dev.thinkers.employee.domain.Position;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PositionDTO {
    private String id;
    private String name;
    private String idDepartment;

    public PositionDTO() {}

    public PositionDTO(Position position) {
        this.id = position.getId();
        this.name = position.getName();
        this.idDepartment = position.getDepartment().getId();
    }
}
