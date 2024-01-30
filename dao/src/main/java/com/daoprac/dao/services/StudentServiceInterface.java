package com.daoprac.dao.services;

import com.daoprac.dao.models.CustomResponse;
import com.daoprac.dao.models.Student;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface StudentServiceInterface {
    ResponseEntity<CustomResponse<String>> saveStudent(Student student);
    ResponseEntity<CustomResponse<Student>> getStudentById(int roll);
    ResponseEntity<CustomResponse<List<Student>>> getAllStudents();
    ResponseEntity<CustomResponse<String>> updateStudent(Student student);
    ResponseEntity<CustomResponse<String>> deleteStudent(int roll);

    ResponseEntity<CustomResponse<String>> deleteStudentsByIds(List<Integer> ids);


    ResponseEntity<CustomResponse<List<Student>>> findAllById(List<Integer> ids);
}
