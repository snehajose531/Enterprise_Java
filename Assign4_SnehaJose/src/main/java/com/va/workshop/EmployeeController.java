package com.va.workshop;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import jakarta.validation.Valid;

@Controller
public class EmployeeController {

    @Autowired
    private EmployeeRepo empRepo;

    @GetMapping("/")
    public String home(Model model) {
        model.addAttribute("employee", new Employee());
        return "registration";
    }

    @PostMapping("/submit")
    public String add(@Valid Employee employee, BindingResult result, Model model) {
        if (result.hasErrors()) {
        	model.addAttribute("employee", employee);
            return "registration";
        }
        empRepo.save(employee);
        model.addAttribute("employees", empRepo.findAll()); 
        return "registration";
    }
}
