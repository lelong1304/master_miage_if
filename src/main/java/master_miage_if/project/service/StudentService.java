package master_miage_if.project.service;


import master_miage_if.project.domain.Student;

import java.util.List;

public interface StudentService {
    List<Student> findAll();

    Student createStudent(Student studentRequest);
}
