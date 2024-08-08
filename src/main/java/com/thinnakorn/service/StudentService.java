package com.thinnakorn.service;

import com.thinnakorn.dto.StudentDto;
import com.thinnakorn.entity.Student;
import com.thinnakorn.repository.StudentRepository;

import java.util.List;

public interface StudentService {
    List<StudentDto> getStudents();
    StudentDto getStudent(Long id);
    void createNewStudent(StudentDto student);

    void updateStudent(StudentDto student,Long id);

    void deleteStudentById(Long studentId);
}
