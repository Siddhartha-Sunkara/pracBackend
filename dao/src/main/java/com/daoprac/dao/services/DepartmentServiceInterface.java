package com.daoprac.dao.services;

import com.daoprac.dao.models.CustomResponse;
import com.daoprac.dao.models.Department;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface DepartmentServiceInterface {
    ResponseEntity<CustomResponse<String>> saveDepartment(Department department);
    ResponseEntity<CustomResponse<Department>> getDepartmentById(int roll);
    ResponseEntity<CustomResponse<List<Department>>> getAllStudentDepartment();
    ResponseEntity<CustomResponse<String>> updateDepartment(Department department);
    ResponseEntity<CustomResponse<String>> deleteDepartment(int roll);

    ResponseEntity<CustomResponse<String>> deleteDepartmentByIds(List<Integer> ids);


    ResponseEntity<CustomResponse<List<Department>>> findAllDepartmentById(List<Integer> ids);


}
