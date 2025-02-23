package com.emranhss.FirstSpringBoot.controller;

import com.emranhss.FirstSpringBoot.entity.Student;
import com.emranhss.FirstSpringBoot.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class StudentController {

    @Autowired
    private StudentService studentService;


    @RequestMapping("/savestudentform")
    public String saveStudent(Model m) {
        m.addAttribute("student", new Student());
        m.addAttribute("title", "Add New Student");
        return "savestudentform";
    }

    @PostMapping("/savestudent")
    public String saveStudent(@ModelAttribute("student") Student student) {
        studentService.saveStu(student);
        return "redirect:/showAllStudent";
    }

    @RequestMapping("/showAllStudent")
    public String showAllStudent(Model m) {
        List<Student> stuList = studentService.getAllStu();
        m.addAttribute("stuList", stuList);
        m.addAttribute("title", "All Student");

        return "showAllStudent";
    }

    @RequestMapping("deletestudent/{id}")
    public String deleteStudent(@PathVariable("id") int id) {
        studentService.deleteById(id);
        return "redirect:/showAllStudent";
    }

    @RequestMapping("/editstudent/{id}")
    public  String editStudent(@PathVariable("id") int id, Model m){
        Student s=studentService.findById(id);

        m.addAttribute("student", s);

        return "savestudentform";

    }


}
