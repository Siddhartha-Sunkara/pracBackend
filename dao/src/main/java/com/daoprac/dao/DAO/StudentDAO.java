package com.daoprac.dao.DAO;

import com.daoprac.dao.models.Student;


import java.util.List;

public interface StudentDAO  {
    void saveStudent(Student student);
    Student getStudentById(int roll);
    List<Student> getAllStudents();
    void updateStudent(Student student);
    void deleteStudent(int roll);

    List<Student> findAllById(List<Integer> ids);
    void deleteStudentsByIds(List<Integer> ids);
}
