package com.daoprac.dao.DAO;

import com.daoprac.dao.models.Department;

import java.util.List;

public interface DepartmentDAO {
    void saveDepartment(Department department);
    Department getDepartmentById(int roll);
    List<Department> getAllDepartment();
    void updateDepartment(Department department);
    void deleteDepartment(int roll);

    List<Department> findAllDepartmentById(List<Integer> ids);

    void deleteDepartmentByIds(List<Integer> ids);
}
