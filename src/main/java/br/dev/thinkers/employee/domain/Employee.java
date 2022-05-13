package br.dev.thinkers.employee.domain;

import br.dev.thinkers.employee.controller.dto.EmployeeDTO;
import br.dev.thinkers.employee.enuns.State;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.NumberFormat;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;

@Getter
@Setter
@Entity
@Table(name = "employees")
public class Employee extends AbstractEntity<String> {

    private String name;

    @NumberFormat(style = NumberFormat.Style.CURRENCY, pattern = "#,##0.00")
    private BigDecimal salary;


    @Column(name = "entry_date")
    private LocalDate entryDate;

    @Column(name = "departure_date")
    private LocalDate departureDate;

    @OneToOne
    @JoinColumn(name = "address_id")
    private Address address;

    @ManyToOne
    @JoinColumn(name = "position_id")
    private Position position;

    public Employee() {}

    public Employee(EmployeeDTO dto, Position position) {

        Address address = new Address();
        address.setId(dto.getId());
        address.setZipCode(dto.getZipCode());
        address.setStreet(dto.getStreet());
        address.setDistrict(dto.getDistrict());
        address.setState(State.valueOf(dto.getState()));
        address.setComplement(dto.getComplement());

        setId(dto.getId());
        this.name = dto.getName();
        this.salary = new BigDecimal(dto.getSalary());
        this.entryDate = dto.getEntryDate();
        this.departureDate = dto.getDepartureDate() == null ? null : dto.getDepartureDate();
        this.position = position;
        this.address = address;
    }
}
