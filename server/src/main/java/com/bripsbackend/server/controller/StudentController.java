package com.bripsbackend.server.controller;

import com.bripsbackend.server.model.Student;
import com.bripsbackend.server.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/api/students")
public class StudentController {
    @Autowired
    private StudentRepository studentRepository;

    @GetMapping
    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    @PostMapping
    public Student createStudent(@RequestBody Student student) {
        return studentRepository.save(student);
    }

    @GetMapping("/dummy")
    public List<Student> getDummyStudents() {
        return Arrays.asList(
                new Student("1", "John Doe", 15),
                new Student("2", "Jane Smith", 16),
                new Student("3", "Alice Johnson", 14),
                new Student("4", "Bob Brown", 17)
        );
    }
}
