package com.ishtifa.cruddemo.rest;

import com.ishtifa.cruddemo.entity.Employee;
import com.ishtifa.cruddemo.service.EmployeeServiceDAO;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/employees")
public class EmployeeRestController {
    private EmployeeServiceDAO employeeServiceDAO;
    //inject the employee dao using construct injection
    public EmployeeRestController(EmployeeServiceDAO theEmployeeServiceDao) {
        employeeServiceDAO=theEmployeeServiceDao;
    }

        // load employee data



        // add mapping for "/list"

        @GetMapping("/list")
        public String listEmployees(Model theModel) {

        List<Employee> theEmployees=employeeServiceDAO.findAll();
            // add to the spring model
            theModel.addAttribute("employees", theEmployees);

            return "employees/list-employees";
        }

        @GetMapping("/showformforadd")
    public String showformforadd(Model themodel)
        {
            Employee theEmployee=new Employee();
            themodel.addAttribute("employee",theEmployee);
            return "employees/employee-form";
        }
        @PostMapping("/save")
    public String saveEmployee(@ModelAttribute("employee") Employee theEmployee)
        {
            employeeServiceDAO.save(theEmployee);
            return "redirect:/employees/list";
        }

        @GetMapping("/showformforupdate")
    public String showformforupdate(@RequestParam("employeeId") int id,Model themodel)
        {
            Employee theEmployee=employeeServiceDAO.findbyid(id);
            themodel.addAttribute("employee",theEmployee);
            return "employees/employee-form";
        }
        @GetMapping("/delete")
    public String employeedelete(@RequestParam("employeeId") int id)
        {
            employeeServiceDAO.deletebyid(id);
            return "redirect:/employees/list";
        }

    }

