package com.code4future.springbootthymeleafdemo.controller;

import com.code4future.springbootthymeleafdemo.dto.EmployeeForm;
import com.code4future.springbootthymeleafdemo.entity.Employee;
import com.code4future.springbootthymeleafdemo.service.EmployeeService;
import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/employees")
public class EmployeeController {

    private EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/new")
    public String addNewEmployee(Model model) {
        model.addAttribute("employee", new EmployeeForm());
        return "add-employee";
    }

    @PostMapping("/save")
    public String saveEmployeeInfo(@Valid @ModelAttribute("employee") EmployeeForm employee, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            if (employee.getId() == null) {
                return "add-employee";
            } else {
                return "edit-employee";
            }
        }
        Employee entityEmployee = new Employee();
        BeanUtils.copyProperties(employee, entityEmployee);
        employeeService.save(entityEmployee);
        return "redirect:/home";
    }

    @GetMapping("/edit/{id}")
    public String showEmployeeEditForm(@PathVariable Long id, Model model) {
        Employee employee = employeeService.findById(id);
        EmployeeForm form = new EmployeeForm();
        BeanUtils.copyProperties(employee, form);
        model.addAttribute("employee", form);
        return "edit-employee";
    }

    @GetMapping("/delete/{id}")
    public String deleteEmployeeById(@PathVariable Long id) {
        employeeService.deleteById(id);
        return "redirect:/home";
    }
}
