package master_miage_if.project.service.impl;

import lombok.AllArgsConstructor;
import master_miage_if.project.domain.Student;
import master_miage_if.project.entity.StudentEntity;
import master_miage_if.project.mapper.StudentMapper;
import master_miage_if.project.repository.StudentEntityRepository;
import master_miage_if.project.service.StudentService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@AllArgsConstructor
public class StudentServiceImpl implements StudentService {
    private final StudentEntityRepository studentEntityRepository;

    @Override
    public List<Student> findAll() {
        List<StudentEntity> entities = studentEntityRepository.findAll();
        return StudentMapper.toList(entities);
    }


    @Override
    public Student createStudent(Student studentRequest) {
        StudentEntity studentEntity = StudentMapper.toStudentEntity(studentRequest);
        StudentEntity saved = studentEntityRepository.save(studentEntity);
        return StudentMapper.toStudent(saved);
    }

    @Override
    public Student findStudentById(UUID id) throws Exception {
        Optional<StudentEntity> studentEntityOptional = studentEntityRepository.findById(id);
        StudentEntity studentEntity = studentEntityOptional.orElseThrow(() -> new Exception("Student not found"));
        return StudentMapper.toStudent(studentEntity);
    }
}
