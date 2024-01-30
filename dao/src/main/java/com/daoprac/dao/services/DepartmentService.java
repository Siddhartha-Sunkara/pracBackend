package com.daoprac.dao.services;

import com.daoprac.dao.DAO.DepartmentDAO;
import com.daoprac.dao.models.CustomResponse;
import com.daoprac.dao.models.Department;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;






    @Service
    public class DepartmentService implements DepartmentServiceInterface {

        @Autowired
        private DepartmentDAO departmentDAO;



        @Override
        public ResponseEntity<CustomResponse<String>> saveDepartment(Department department) {
            try {
                departmentDAO.saveDepartment(department);
                return ResponseEntity.ok(new CustomResponse<>("OK", "Department Saved"));
            } catch (Exception e) {
                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new CustomResponse<>("Error", "Error saving Department"));
            }
        }

        @Override
        public ResponseEntity<CustomResponse<Department>> getDepartmentById(int roll) {
            try {
                Department department = departmentDAO.getDepartmentById(roll);
                return ResponseEntity.ok(new CustomResponse<>("OK", department));
            } catch (Exception e) {
                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new CustomResponse<>("Error", null));
            }
        }

        @Override
        public ResponseEntity<CustomResponse<List<Department>>> getAllStudentDepartment() {
            try {
                List<Department> departments = departmentDAO.getAllDepartment();
                return ResponseEntity.ok(new CustomResponse<>("OK", departments));
            } catch (Exception e) {
                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new CustomResponse<>("Error", null));
            }
        }

        @Override
        public ResponseEntity<CustomResponse<String>> updateDepartment(Department department) {
            try {
                departmentDAO.updateDepartment(department);
                return ResponseEntity.ok(new CustomResponse<>("OK", "Department Updated"));
            } catch (Exception e) {
                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new CustomResponse<>("Error", "Error updating Department"));
            }
        }

        @Override
        public ResponseEntity<CustomResponse<String>> deleteDepartment(int roll) {
            try {
                departmentDAO.deleteDepartment(roll);
                return ResponseEntity.ok(new CustomResponse<>("OK", "Department Deleted"));
            } catch (Exception e) {
                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new CustomResponse<>("Error", "Error deleting Department"));
            }
        }

        @Override
        public ResponseEntity<CustomResponse<String>> deleteDepartmentByIds(List<Integer> ids) {
            try {
                departmentDAO.deleteDepartmentByIds(ids);
                return ResponseEntity.ok(new CustomResponse<>("OK", "Deleted"));
            } catch (Exception e) {
                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new CustomResponse<>("Error", "Error deleting Department"));
            }
        }



        @Override
        public ResponseEntity<CustomResponse<List<Department>>> findAllDepartmentById(List<Integer> ids) {
            try {
                List<Department> departments = departmentDAO.findAllDepartmentById(ids);
                return ResponseEntity.ok(new CustomResponse<>("OK", departments));
            } catch (Exception e) {
                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new CustomResponse<>("Error", null));
            }
        }


    }


