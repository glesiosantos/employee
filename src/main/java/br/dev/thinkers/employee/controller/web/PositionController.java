package br.dev.thinkers.employee.controller.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("positions")
public class PositionController {

    @GetMapping
    public String loadPosition(){
        return "positions/load";
    }
}
