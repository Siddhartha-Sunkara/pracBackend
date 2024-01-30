package com.daoprac.dao.controllers;

import com.daoprac.dao.models.CustomResponse;
import com.daoprac.dao.models.Student;
import com.daoprac.dao.services.StudentServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/students")
public class StudentController {

    @Autowired
    private StudentServiceInterface studentService;

    @PostMapping("/add")
    public ResponseEntity<CustomResponse<String>> saveStudent(@RequestBody Student student) {
        return studentService.saveStudent(student);
    }

    @DeleteMapping("/delete/{roll}")
    public ResponseEntity<CustomResponse<String>> deleteStudent(@PathVariable int roll) {
        return studentService.deleteStudent(roll);
    }

    @PutMapping("/update")
    public ResponseEntity<CustomResponse<String>> updateStudent(@RequestBody Student student) {
        return studentService.updateStudent(student);
    }

    @GetMapping("/get")
    public ResponseEntity<CustomResponse<List<Student>>> getAllStudents() {
       return studentService.getAllStudents();
    }

    @GetMapping("/getids")
    public ResponseEntity<CustomResponse<List<Student>>> getStudentsByIds(@RequestParam List<Integer> ids) {
        return  studentService.findAllById(ids);
//        return ResponseEntity.ok(new CustomResponse<>("OK", students));
    }

    @DeleteMapping("/deleteids")
    public ResponseEntity<CustomResponse<String>> deleteStudentsByIds(@RequestParam List<Integer> ids) {
        return studentService.deleteStudentsByIds(ids);
    }
}
