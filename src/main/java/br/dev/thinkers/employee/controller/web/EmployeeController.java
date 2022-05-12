package br.dev.thinkers.employee.controller.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("employees")
public class EmployeeController {

    @GetMapping("/add")
    public String addEmployee(){
        return "employees/form";
    }
}
