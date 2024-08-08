package com.thinnakorn.mapper;

import com.thinnakorn.dto.StudentDto;
import com.thinnakorn.entity.Student;

public class StudentMapper {

    public static Student mapperToStudent(StudentDto studentDto){
        Student student = new Student(
                studentDto.getId(),
                studentDto.getFirstName(),
                studentDto.getLastName(),
                studentDto.getEmail()
        );
        return student;
    }

    public static StudentDto mapperToStudentDto(Student student){
        StudentDto studentDto=new StudentDto(
                student.getId(),
                student.getFirstName(),
                student.getLastName(),
                student.getEmail()
        );
        return studentDto;
    }
}
