package com.example.SpringSecurityProject.Controller;

import com.example.SpringSecurityProject.Model.Student;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class HomeContoller {

    @GetMapping("/")
    public String greet(HttpServletRequest req){
        return "Welcome to my world "+req.getSession().getId();
    }

    private List<Student> students = new ArrayList<>(List.of(new Student(1,"Muthu",95),new Student(2,"Eswari",100)));
    @GetMapping("/students")
    public List<Student> getStudents(){
        return students;
    }

    @GetMapping("csrf-token")
    public CsrfToken getCsrfToken(HttpServletRequest req){
        return (CsrfToken) req.getAttribute("_csrf");
    }

    @PostMapping("/students")
    public Student addStudent(@RequestBody Student student){
        students.add(student);
        return student;
    }


}
