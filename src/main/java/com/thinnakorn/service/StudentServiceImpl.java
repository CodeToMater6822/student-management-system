package com.thinnakorn.service;

import com.thinnakorn.dto.StudentDto;
import com.thinnakorn.entity.Student;
import com.thinnakorn.mapper.StudentMapper;
import com.thinnakorn.repository.StudentRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class StudentServiceImpl implements StudentService{

    private StudentRepository studentRepository;
    @Override
    public List<StudentDto> getStudents() {
        List<Student> students=studentRepository.findAll();

        return students.stream()
                .map(student -> StudentMapper.mapperToStudentDto(student))
                .collect(Collectors.toUnmodifiableList());
    }

    @Override
    public StudentDto getStudent(Long id) {
        Student student= studentRepository.findById(id).get();
        StudentDto studentDto=StudentMapper.mapperToStudentDto(student);
        return studentDto;
    }

    @Override
    public void createNewStudent(StudentDto student) {
        Student saveStudent=StudentMapper.mapperToStudent(student);
        studentRepository.save(saveStudent);
    }

    @Override
    public void updateStudent(StudentDto studentDto,Long id) {
        Student student = studentRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Student not found with id "+id));
        student.setFirstName(studentDto.getFirstName());
        student.setLastName(studentDto.getLastName());
        student.setEmail(studentDto.getEmail());
        studentRepository.save(student);
//        return StudentMapper.mapperToStudentDto(studentRepository.save(student));
    }

    @Override
    public void deleteStudentById(Long studentId) {
        studentRepository.deleteById(studentId);
    }
}
