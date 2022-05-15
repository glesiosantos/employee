package br.dev.thinkers.employee.controller.dto;

import br.dev.thinkers.employee.domain.Employee;
import br.dev.thinkers.employee.utils.ConvertDate;
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

    private String addressId;
    private String zipCode;
    private String street;
    private String district;
    private String city;
    private String state;
    private String complement;
    private String idPosition;
    private String position;

    public EmployeeDTO() {}

    public static EmployeeDTO convertObjectToDto(Employee employee) {
        EmployeeDTO employeeDTO = new EmployeeDTO();
        employeeDTO.id = employee.getId();
        employeeDTO.name = employee.getName();
        employeeDTO.salary = employee.getSalary().toString();
        employeeDTO.entryDate = employee.getEntryDate();
        employeeDTO.departureDate = employee.getDepartureDate() == null ? null : employee.getDepartureDate();
        employeeDTO.idPosition = employee.getPosition().getId();
        employeeDTO.position = employee.getPosition().getName();
        return employeeDTO;
    }
}
