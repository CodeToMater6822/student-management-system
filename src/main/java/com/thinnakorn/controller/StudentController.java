package com.thinnakorn.controller;

import com.thinnakorn.dto.StudentDto;
import com.thinnakorn.service.StudentService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.boot.Banner;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("student")
@AllArgsConstructor
public class StudentController {

    private StudentService studentService;
    @GetMapping("/users")
    public String getStudents(Model model){
        List<StudentDto> students = studentService.getStudents();
        model.addAttribute("students",students);
        return "index";
    }


    //handler method to handle create a new student
    @GetMapping("/new")
    public String createNewStudent(Model model){
        StudentDto student=new StudentDto();
        model.addAttribute("student",student);
        return "create-student";
    }

    @PostMapping("/users")
    public String saveStudent(@Valid @ModelAttribute("student") StudentDto studentDto,
                              BindingResult result,Model model){
        if(result.hasErrors()){
            model.addAttribute("student",studentDto);
            return "create-student";
        }
        studentService.createNewStudent(studentDto);
        return "redirect:/student/users";
    }
    //handler method to handle edit student request
    @GetMapping("/{studentId}/edit")
    public String callUpdateStudent(@PathVariable("studentId") Long studentId,Model model){
        StudentDto studentDto=studentService.getStudent(studentId);
        model.addAttribute("student",studentDto);
        return "update-student";
    }
    //handler method to update student information

    @PostMapping("/update/{studentId}")
    public String updateStudent(@PathVariable("studentId") Long id,
                                @Valid @ModelAttribute("student") StudentDto student,
                                BindingResult result,
                                Model model){
        if(result.hasErrors()){
            model.addAttribute("student",student);
            return "update-student";
        }
        System.out.println("info: "+student.getFirstName());
        studentService.updateStudent(student,id);
        return "redirect:/student/users";
    }

    //handler method to handle delete student from database
    @GetMapping("/{studentId}/delete")
    public String deleteStudent(@PathVariable("studentId") Long studentId){
        System.out.println("1111111111111111111");
        studentService.deleteStudentById(studentId);
        System.out.println("222222222222222222222");
        return "redirect:/student/users";
    }

    //handler method to handle view student info
    @GetMapping("/{studentId}/view")
    public String viewStudent(@PathVariable("studentId")Long studentId,
                              Model model){
        StudentDto student=studentService.getStudent(studentId);
        model.addAttribute("student",student);
        return "student-info";
    }
}
