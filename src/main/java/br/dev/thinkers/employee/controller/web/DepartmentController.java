package br.dev.thinkers.employee.controller.web;

import br.dev.thinkers.employee.controller.dto.DepartmentDto;
import br.dev.thinkers.employee.domain.Department;
import br.dev.thinkers.employee.services.DepartmentService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("departments")
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class DepartmentController {

    private final DepartmentService departmentService;

    @GetMapping("/add")
    public String add(DepartmentDto departmentDto) {
        return "department/form";
    }

    @PostMapping("/save")
    public String saveDepartment(DepartmentDto departmentDto, RedirectAttributes attr) {
        departmentService.save(new Department(departmentDto));
        attr.addFlashAttribute("success", "Departamento adicionado com sucesso!");
        return "redirect:/departments";
    }

    @PostMapping("/update")
    public String updateDepartment(DepartmentDto departmentDto, RedirectAttributes attr) {
        departmentService.update(new Department(departmentDto));
        attr.addFlashAttribute("success", "Departamento atualizado com sucesso!");
        return "redirect:/departments";
    }

    @GetMapping
    public String load(ModelMap model) {
        List<DepartmentDto> departmentList = new ArrayList<>();
        departmentService.loadAllPositions().forEach(department -> departmentList.add(new DepartmentDto(department)));
        model.addAttribute("departmentList", departmentList);
        return "department/load";
    }

    @GetMapping("/edit/{id}")
    public String preEdit(@PathVariable("id") String id, ModelMap model) {
        Department department = departmentService.findPositionById(id);
        model.addAttribute("departmentDto", new DepartmentDto(department));
        return "department/form";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable("id") String id, RedirectAttributes attr)  {
        if(departmentService.hasPosition(id)) {
            departmentService.remove(id);
            attr.addFlashAttribute("success", "Departamento removido com sucesso!");
        } else {
            attr.addFlashAttribute("success", "Departamento não pode ser removido. Pois possui cargo(s) vinculado!");
        }
        return "redirect:/departments";
    }
}
