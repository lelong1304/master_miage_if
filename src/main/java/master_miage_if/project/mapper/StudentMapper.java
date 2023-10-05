package master_miage_if.project.mapper;

import master_miage_if.project.domain.Student;
import master_miage_if.project.entity.StudentEntity;

import java.util.List;

public class StudentMapper {

    public static Student toStudent(StudentEntity entity) {
        return Student.builder()
                .id(entity.getId())
                .age(entity.getAge())
                .firstName(entity.getFirstName())
                .lastName(entity.getLastName())
                .email(entity.getEmail())
                .build();
    }

    public static List<Student> toList(List<StudentEntity> studentEntityList) {
        return studentEntityList.stream().map(StudentMapper::toStudent).toList();
    }

    public static StudentEntity toStudentEntity(Student model) {
        return StudentEntity.builder()
                .id(model.id())
                .age(model.age())
                .firstName(model.firstName())
                .lastName(model.lastName())
                .email(model.email())
                .build();
    }


}
