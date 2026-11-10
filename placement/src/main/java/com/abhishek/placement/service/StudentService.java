package com.abhishek.placement.service;

import com.abhishek.placement.dto.StudentRequest;
import com.abhishek.placement.entity.Student;
import com.abhishek.placement.repository.StudentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class StudentService {
    private final StudentRepository studentRepository;

    public Student saveStudent(Student student) {
        return studentRepository.save(student);
    }

    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    public Student getStudentById(Long id) {
        return studentRepository.findById(id).orElseThrow(() -> new RuntimeException("Student not found with id: " + id)
        );
    }

    public Student updateStudent(Long id, StudentRequest request) {
        Student student = studentRepository.findById(id).orElseThrow(() -> new RuntimeException("Student not found"));
        student.setFullName(request.getFullName());
        student.setEmail(request.getEmail());
        student.setPhone(request.getPhone());
        student.setCollege(request.getCollege());
        student.setGraduationYear(request.getGraduationYear());
        return studentRepository.save(student);
    }
    public void deleteStudent(Long id){
        Student student=studentRepository.findById(id).orElseThrow(()-> new RuntimeException("Student not found"));
        studentRepository.delete(student);
    }
    public Student saveStudent(StudentRequest request){
        Student student=new Student();
        student.setFullName(request.getFullName());
        student.setEmail(request.getEmail());
        student.setPhone(request.getPhone());
        student.setCollege(request.getCollege());
        student.setGraduationYear(request.getGraduationYear());
        return studentRepository.save(student);

    }
}