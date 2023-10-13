package master_miage_if.project.service;


import master_miage_if.project.domain.Student;

import java.util.List;
import java.util.UUID;

public interface StudentService {
    List<Student> findAll();

    Student createStudent(Student studentRequest);

    Student findStudentById(UUID id) throws Exception;
}
