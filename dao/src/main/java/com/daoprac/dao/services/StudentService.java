package com.daoprac.dao.services;

import com.daoprac.dao.DAO.StudentDAO;
import com.daoprac.dao.models.CustomResponse;
import com.daoprac.dao.models.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService implements StudentServiceInterface {

    @Autowired
    private StudentDAO studentDAO;

    public ResponseEntity<CustomResponse<String>> saveStudent(Student student) {
        try {
            studentDAO.saveStudent(student);
            return ResponseEntity.ok(new CustomResponse<>("OK", "Student Saved"));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new CustomResponse<>("Error", "Error saving student"));
        }
    }

    public ResponseEntity<CustomResponse<Student>> getStudentById(int roll) {
        try {
            Student student = studentDAO.getStudentById(roll);
            return ResponseEntity.ok(new CustomResponse<>("OK", student));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new CustomResponse<>("Error", null));
        }
    }

    public ResponseEntity<CustomResponse<List<Student>>> getAllStudents() {
        try {
            List<Student> students = studentDAO.getAllStudents();
            return ResponseEntity.ok(new CustomResponse<>("OK", students));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new CustomResponse<>("Error", null));
        }
    }

    public ResponseEntity<CustomResponse<List<Student>>> findAllById(List<Integer> ids) {
        try {
            List<Student> students = studentDAO.findAllById(ids);
            return ResponseEntity.ok(new CustomResponse<>("OK", students));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new CustomResponse<>("Error", null));
        }
    }

    public ResponseEntity<CustomResponse<String>> updateStudent(Student student) {
        try {
            studentDAO.updateStudent(student);
            return ResponseEntity.ok(new CustomResponse<>("OK", "Student Updated"));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new CustomResponse<>("Error", "Error updating student"));
        }
    }

    public ResponseEntity<CustomResponse<String>> deleteStudent(int roll) {
        try {
            studentDAO.deleteStudent(roll);
            return ResponseEntity.ok(new CustomResponse<>("OK", "Student Deleted"));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new CustomResponse<>("Error", "Error deleting student"));
        }
    }

    public ResponseEntity<CustomResponse<String>> deleteStudentsByIds(List<Integer> ids) {
        try {
            studentDAO.deleteStudentsByIds(ids);
            return ResponseEntity.ok(new CustomResponse<>("OK", "Deleted"));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new CustomResponse<>("Error", "Error deleting students"));
        }
    }
}
