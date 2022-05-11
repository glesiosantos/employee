package br.dev.thinkers.employee.controller.web;

import br.dev.thinkers.employee.controller.dto.PositionDTO;
import br.dev.thinkers.employee.domain.Department;
import br.dev.thinkers.employee.domain.Position;
import br.dev.thinkers.employee.services.DepartmentService;
import br.dev.thinkers.employee.services.PositionService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("positions")
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class PositionController {

    private final PositionService positionService;
    private final DepartmentService departmentService;

    @ModelAttribute("departments")
    public List<Department> departments() {
        return departmentService.loadAllDepartments();
    }

    @GetMapping
    public String loadPosition(ModelMap model){
        model.addAttribute("positionList", positionService.loadAllPositions());
        return "positions/load";
    }

    @GetMapping("/add")
    public String addPosition(PositionDTO positionDTO, ModelMap model) {
        return "positions/form";
    }

    @PostMapping("/save")
    public String savePosition(PositionDTO positionDTO, RedirectAttributes attr) {
        Department department = departmentService.findDepartmentById(positionDTO.getIdDepartment());
        positionService.save(new Position(positionDTO, department));
        attr.addFlashAttribute("success", "Cargo cadastrado com sucesso!");
        return "redirect:/positions";
    }

    @PostMapping("/update")
    public String updatePosition(PositionDTO positionDTO, RedirectAttributes attr) {
        Department department = departmentService.findDepartmentById(positionDTO.getIdDepartment());
        positionService.update(new Position(positionDTO, department));
        attr.addFlashAttribute("success", "Cargo atualizado com sucesso!");
        return "redirect:/positions";
    }

    @GetMapping("/edit/{id}")
    public String updatedPosition(@PathVariable("id") String id, ModelMap model) {
        Position position = positionService.findPositionById(id);
        model.addAttribute("positionDTO", new PositionDTO(position));
        return "positions/form";
    }

    @GetMapping("/delete/{id}")
    public String remover(@PathVariable("id") String id, RedirectAttributes attr) {
        if(!positionService.hasEmployee(id)){
            attr.addFlashAttribute("warning", "Cargo não pode ser excluido, pois possui funcionários vinculado ao cargo");
        } else {
            positionService.remove(id);
            attr.addFlashAttribute("success", "Cargo excluído com sucesso");
        }
        return "redirect:/positions";
    }
}
