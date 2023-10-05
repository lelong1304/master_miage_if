package master_miage_if.project.controller;

import lombok.AllArgsConstructor;
import master_miage_if.project.domain.Student;
import master_miage_if.project.service.StudentService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("students")
@AllArgsConstructor
public class StudentController {
    private final StudentService studentService;

    @GetMapping()
    public List<Student> getAll() {
        return studentService.findAll();
    }

    @PostMapping(consumes = {"application/json"})
    public Student save(@RequestBody Student s) {
        return studentService.createStudent(s);
    }

}
