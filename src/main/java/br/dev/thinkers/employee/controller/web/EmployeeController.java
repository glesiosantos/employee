package br.dev.thinkers.employee.controller.web;

import br.dev.thinkers.employee.controller.dto.EmployeeDTO;
import br.dev.thinkers.employee.domain.Department;
import br.dev.thinkers.employee.domain.Position;
import br.dev.thinkers.employee.enuns.State;
import br.dev.thinkers.employee.services.PositionService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Arrays;
import java.util.List;

@Controller
@RequestMapping("employees")
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class EmployeeController {

    private final PositionService positionService;

    @ModelAttribute("positions")
    public List<Position> positions() {
        return positionService.loadAllPositions();
    }

    @ModelAttribute("states")
    public List<State> states() {
        return Arrays.asList(State.values());
    }
    @GetMapping("/add")
    public String addEmployee(EmployeeDTO employeeDTO){
        return "employees/form";
    }


}
