package master_miage_if.project.controller;

import lombok.AllArgsConstructor;
import master_miage_if.project.domain.Student;
import master_miage_if.project.entity.StudentEntity;
import master_miage_if.project.mapper.StudentMapper;
import master_miage_if.project.repository.StudentEntityRepository;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
@AllArgsConstructor
public class StudentController {
    private final StudentEntityRepository repository;

    @QueryMapping
    public List<Student> getAllStudents() {
        List<StudentEntity> studentEntities = repository.findAll();
        return StudentMapper.toList(studentEntities);
    }

    @MutationMapping
    public Student newStudent(@Argument String firstName, @Argument String lastName, @Argument String email, @Argument Integer age) {
        Student studentRequest = Student.builder()
                .firstName(firstName)
                .lastName(lastName)
                .email(email)
                .age(age)
                .build();
        StudentEntity studentEntity = StudentMapper.toStudentEntity(studentRequest);
        return StudentMapper.toStudent(repository.save(studentEntity));
    }
}
