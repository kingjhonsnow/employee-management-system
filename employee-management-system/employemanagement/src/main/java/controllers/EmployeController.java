package controllers;

import entity.Employe;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import repositories.EmployeRepository;
import java.util.List;

@RestController
@RequestMapping("/api/employees")  // Added /api prefix for consistency
@CrossOrigin(origins = "http://localhost:3000")  // Additional CORS annotation
public class EmployeController {

    @Autowired
    private EmployeRepository employeRepository;

    @GetMapping
    public List<Employe> getAllEmployees() {
        return employeRepository.findAll();
    }
}