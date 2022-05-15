package br.dev.thinkers.employee.controller.web;

import br.dev.thinkers.employee.controller.dto.EmployeeDTO;
import br.dev.thinkers.employee.domain.Address;
import br.dev.thinkers.employee.domain.Employee;
import br.dev.thinkers.employee.domain.Position;
import br.dev.thinkers.employee.enuns.State;
import br.dev.thinkers.employee.services.EmployeeService;
import br.dev.thinkers.employee.services.PositionService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Controller
@RequestMapping("employees")
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class EmployeeController {

    private final PositionService positionService;
    private final EmployeeService employeeService;

    @ModelAttribute("positions")
    public List<Position> positions() {
        return positionService.loadAllPositions();
    }

    @ModelAttribute("states")
    public List<State> states() {
        return Arrays.asList(State.values());
    }

    @GetMapping
    public String loadEmployees(ModelMap model){
        List<EmployeeDTO> employees = employeeService.loadAllEmployees()
                .stream().map(EmployeeDTO::convertObjectToDto).collect(Collectors.toList());
        model.addAttribute("employees", employees);
        return "employees/load";
    }

    @GetMapping("/add")
    public String addEmployee(EmployeeDTO employeeDTO){
        return "employees/form";
    }

    @PostMapping("/save")
    public String saveEmployee(EmployeeDTO employeeDTO, RedirectAttributes attr) {
        Employee employee = Employee.convertDtoToObject(employeeDTO);
        employeeService.save(employee);
        attr.addAttribute("success","Funcionário cadastrado com sucesso!");
        return "redirect:/employees";
    }


}
