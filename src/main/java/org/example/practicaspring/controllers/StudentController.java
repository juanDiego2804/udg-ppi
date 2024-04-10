package org.example.practicaspring.controllers;

import org.example.practicaspring.Models.StudentModel;
import org.example.practicaspring.services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Optional;

@RestController
@RequestMapping("/students")//localhost:8080//students
public class StudentController{
    @Autowired
    StudentService studentService;

    //get
    @GetMapping()
    public ArrayList<StudentModel> getAllStudents(){//antes era find
        return studentService.getAllStudents();
    }


    //post
    @PostMapping()
    public StudentModel saveStudent(@RequestBody StudentModel student){
        return this.studentService.saveStudent(student);
    }

    @GetMapping("/findStudentById{id}")
    public Optional<StudentModel> findStudentById(@PathVariable Long id){
        return studentService.findStudentById(id);
    }

    @GetMapping("/findStudentByCode/{code}")//localhost:8080/students/find-by-code?
    public Optional<StudentModel> findStudentByCode(@RequestParam("code")String code){//(path variable Stirng code
        return studentService.findStudentByCode(code);
    }

    @GetMapping("/findStudentByName/{name}")//localhost:8080/students/find-by-code?
    public ArrayList<StudentModel> findStudentByName(@RequestParam("name")String name){//[athvariable Stirng name
        return studentService.findStudentByName(name);
    }





    @DeleteMapping("/delete-student-by-id")
    public String deleteStudentById(@PathVariable Long id){
        return studentService.deleteStudent(id);
    }

    //put
    @PutMapping()
    public StudentModel editStudentById(@RequestBody StudentModel student){
        return studentService.editById(student);//saveStudent
    }


}