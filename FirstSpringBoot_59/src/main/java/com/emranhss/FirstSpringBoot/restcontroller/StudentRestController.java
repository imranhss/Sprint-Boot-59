package com.emranhss.FirstSpringBoot.restcontroller;

import com.emranhss.FirstSpringBoot.entity.Student;
import com.emranhss.FirstSpringBoot.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("student/api")
public class StudentRestController {


    @Autowired
    private StudentService studentService;


    @GetMapping("/")
    public List<Student> getAllStudent() {

        return studentService.getAllStu();
    }

    @PostMapping("/save")
    public void saveStudent(@RequestBody Student s) {

        studentService.saveStu(s);
    }

    @DeleteMapping("/delete/{id}")
    public  void deleteStudet(@PathVariable int id){
        studentService.deleteById(id);
    }

    @PutMapping("/update/")
    public  void updateStudet(@RequestBody Student s){
        studentService.saveStu(s);
    }





}
