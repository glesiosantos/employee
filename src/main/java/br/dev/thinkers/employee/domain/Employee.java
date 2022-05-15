package br.dev.thinkers.employee.domain;

import br.dev.thinkers.employee.controller.dto.EmployeeDTO;
import br.dev.thinkers.employee.enuns.State;
import br.dev.thinkers.employee.utils.ConvertDate;
import br.dev.thinkers.employee.utils.Converter;
import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.NumberFormat;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

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

    @OneToMany(mappedBy = "employee", cascade = CascadeType.ALL)
    private Set<Address> addresses = new HashSet<>();

    @ManyToOne
    @JoinColumn(name = "position_id")
    private Position position;

    public Employee() {}
    public static Employee convertDtoToObject(EmployeeDTO dto) {

        Position position = new Position();
        position.setId(dto.getIdPosition());

        Address address = new Address();
        address.setZipCode(dto.getZipCode());
        address.setStreet(dto.getStreet());
        address.setDistrict(dto.getDistrict());
        address.setCity(dto.getCity());
        address.setState(State.valueOf(dto.getState()));
        address.setComplement(dto.getComplement());

        Employee employee = new Employee();
        employee.name = dto.getName();
        employee.salary = Converter.convertStringToBigDecimal(dto.getSalary());
        employee.entryDate = dto.getEntryDate();
        employee.departureDate = dto.getDepartureDate() == null  ? null : dto.getDepartureDate();
        employee.getAddresses().add(address);
        employee.setPosition(position);

        address.setEmployee(employee);

        return employee;
    }
}
