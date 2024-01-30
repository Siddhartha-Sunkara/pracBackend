package com.daoprac.dao.controllers;

import com.daoprac.dao.models.CustomResponse;
import com.daoprac.dao.models.Department;
import com.daoprac.dao.services.DepartmentServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/department")
public class DepartmentController {

    @Autowired
   private DepartmentServiceInterface departmentService;

    @PostMapping("/addDepartment")
    public ResponseEntity<CustomResponse<String>> saveStudent(@RequestBody Department department) {
        return departmentService.saveDepartment(department);
    }

    @DeleteMapping("/deleteDepartment/{roll}")
    public ResponseEntity<CustomResponse<String>> deleteStudent(@PathVariable int roll) {
        return departmentService.deleteDepartment(roll);
    }

    @PutMapping("/updateDepartment")
    public ResponseEntity<CustomResponse<String>> updateStudent(@RequestBody Department department) {
        return departmentService.updateDepartment(department);
    }

    @GetMapping("/getDepartment")
    public ResponseEntity<CustomResponse<List<Department>>> getAllStudents() {
        return departmentService.getAllStudentDepartment();
    }

    @GetMapping("/getDepartmentids")
    public ResponseEntity<CustomResponse<List<Department>>> getStudentsByIds(@RequestParam List<Integer> ids) {
        return  departmentService.findAllDepartmentById(ids);
//        return ResponseEntity.ok(new CustomResponse<>("OK", students));
    }

    @DeleteMapping("/deleteDepartmentids")
    public ResponseEntity<CustomResponse<String>> deleteStudentsByIds(@RequestParam List<Integer> ids) {
        return departmentService.deleteDepartmentByIds(ids);
    }
}
