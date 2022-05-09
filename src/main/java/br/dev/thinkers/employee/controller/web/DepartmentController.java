package br.dev.thinkers.employee.controller.web;

import br.dev.thinkers.employee.controller.dto.DepartmentDto;
import br.dev.thinkers.employee.domain.Department;
import br.dev.thinkers.employee.services.DepartmentService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("departments")
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class DepartmentController {

    private final DepartmentService departmentService;

    @GetMapping("/add")
    public String add(DepartmentDto departmentDto) {
        return "department/add";
    }

    @PostMapping("/save")
    public String saveDepartment(DepartmentDto departmentDto) {
        departmentService.save(new Department(departmentDto));
        return "redirect:/departments";
    }

    @GetMapping
    public String load(ModelMap model) {
        List<DepartmentDto> departmentList = new ArrayList<>();
        departmentService.loadAllPositions().forEach(department -> departmentList.add(new DepartmentDto(department)));
        model.addAttribute("departmentList", departmentList);
        return "department/load";
    }
}
