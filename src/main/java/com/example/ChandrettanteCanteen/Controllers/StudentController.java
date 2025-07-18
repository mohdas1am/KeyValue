package com.example.ChandrettanteCanteen.Controllers;

import com.example.ChandrettanteCanteen.Models.Student;
import com.example.ChandrettanteCanteen.Services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

public class StudentController {
    @Autowired
    StudentService studentService;

    @GetMapping("/students/login/{username}/{password}")
    public ResponseEntity<String>studentLogin(@PathVariable String username,@PathVariable String password){
        return studentService.studentLogin(username,password);
    }

    @PostMapping("/students/sign-up")
    public ResponseEntity<String>signUp(@RequestBody Student student){
        return studentService.addStudent(student);
    }

    @GetMapping("/get-status/{userName}")
    public ResponseEntity<Student>getCurrentStatus(@PathVariable String userName){
        return studentService.getStatus(userName);
    }
}
