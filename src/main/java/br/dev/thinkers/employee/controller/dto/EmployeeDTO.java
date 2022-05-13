package br.dev.thinkers.employee.controller.dto;

import br.dev.thinkers.employee.domain.Employee;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class EmployeeDTO {

    private String id;
    private String name;
    private String salary;
    private LocalDate entryDate;
    private LocalDate departureDate;
    private String zipCode;
    private String street;
    private String district;
    private String city;
    private String state;
    private String complement;
    private String idPosition;


    public EmployeeDTO() {}

    public EmployeeDTO(Employee employee) {
        this.id = employee.getId();
        this.name = employee.getName();
        this.salary = employee.getSalary().toString();
        this.entryDate = employee.getEntryDate();
        this.departureDate = employee.getDepartureDate();
        this.zipCode = employee.getAddress().getZipCode();
        this.street = employee.getAddress().getStreet();
        this.district = employee.getAddress().getDistrict();
        this.city = employee.getAddress().getCity();
        this.state = employee.getAddress().getState().toString();
        this.complement = employee.getAddress().getComplement();
        this.idPosition = employee.getPosition().getId();
    }
}
