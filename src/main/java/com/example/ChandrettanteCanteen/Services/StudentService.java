package com.example.ChandrettanteCanteen.Services;

import com.example.ChandrettanteCanteen.Models.Student;
import com.example.ChandrettanteCanteen.Repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;

import java.util.Optional;

public class StudentService {
    @Autowired
    StudentRepository studentRepository;

    public ResponseEntity<String> studentLogin(String username, String password) {
        Optional<Student> optionalStudent = studentRepository.findById(username);

        if (optionalStudent.isEmpty()) {
            return ResponseEntity.badRequest().body("Username or password is incorrect");
        }

        Student student = optionalStudent.get();
        if (student.getPassword().equals(password)) {
            return ResponseEntity.ok("Logged in as " + student.getName());
        }

        return ResponseEntity.badRequest().body("Username or password is incorrect");
    }

    public ResponseEntity<String> addStudent(Student student) {
        Optional<Student> existingStudent = studentRepository.findById(student.getSid());

        if (existingStudent.isPresent()) {
            return ResponseEntity.badRequest().body("Username already exists");
        }

        studentRepository.save(student);
        return ResponseEntity.ok("Signed in as " + student.getName());
    }

    public ResponseEntity<Student> getStatus(String userName) {
        Optional<Student> studentOpt = studentRepository.findById(userName);
        return studentOpt.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

}
