package master_miage_if.project.service.impl;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import master_miage_if.project.domain.Student;
import master_miage_if.project.entity.BookEntity;
import master_miage_if.project.entity.StudentEntity;
import master_miage_if.project.mapper.StudentMapper;
import master_miage_if.project.repository.BookEntityRepository;
import master_miage_if.project.repository.StudentEntityRepository;
import master_miage_if.project.service.StudentService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@AllArgsConstructor
@Slf4j
public class StudentServiceImpl implements StudentService {
    private final StudentEntityRepository studentEntityRepository;
    private final BookEntityRepository bookEntityRepository;

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

    @Override
    public Student rentBook(UUID studentId, List<UUID> listBookId) throws Exception {
        Optional<StudentEntity> studentEntityOptional = studentEntityRepository.findById(studentId);
        StudentEntity studentEntity = studentEntityOptional.orElseThrow(() -> new Exception("Student not found"));
        listBookId.forEach(
                bookId -> {
                    Optional<BookEntity> bookEntityOptional = bookEntityRepository.findById(bookId);
                    bookEntityOptional.ifPresentOrElse(studentEntity::addBook, () -> log.error("Book with id {} not found", bookId));
                }
        );
        studentEntityRepository.save(studentEntity);
        return StudentMapper.toStudent(studentEntity);
    }
}
