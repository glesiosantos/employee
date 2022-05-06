package br.dev.thinkers.employee.domain;

import lombok.*;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;

@Getter
@Setter
@Entity
@Table(name = "employees")
public class Employee extends AbstractEntity<String> {

    private String name;

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

}
