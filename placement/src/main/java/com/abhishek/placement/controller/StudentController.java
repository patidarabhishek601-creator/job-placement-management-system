package com.abhishek.placement.controller;

import com.abhishek.placement.dto.StudentRequest;
import com.abhishek.placement.entity.Student;
import com.abhishek.placement.service.StudentService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/students")
public class StudentController {
    private final StudentService studentService;
    @PostMapping
    public Student saveStudent(@Valid @RequestBody StudentRequest request){
        return studentService.saveStudent(request);
    }
    @GetMapping
    public List<Student> getAllStudents(){
        return studentService.getAllStudents();
    }
    @GetMapping("/{id}")
    public Student getStudentById(@PathVariable Long id){
        return studentService.getStudentById(id);
    }
    @PutMapping("/{id}")
    public Student updateStudent(@PathVariable Long id, @Valid @RequestBody StudentRequest request){
        return studentService.updateStudent(id,request);
    }
    @DeleteMapping("/{id}")
    public String deleteStudent(@PathVariable Long id){
        studentService.deleteStudent(id);
        return "Student deleted successfully!";
    }

}
