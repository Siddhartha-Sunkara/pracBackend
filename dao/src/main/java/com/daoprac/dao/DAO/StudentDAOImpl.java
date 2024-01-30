package com.daoprac.dao.DAO;

import com.daoprac.dao.models.Student;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Objects;

import static org.springframework.data.mongodb.core.query.Criteria.where;
import static org.springframework.data.mongodb.core.query.Query.query;

@Repository
public class StudentDAOImpl implements StudentDAO {
    @Autowired
    private MongoTemplate mongoTemplate;

    @Override
    public void saveStudent(Student student) {
        mongoTemplate.save(student);
    }

    @Override
    public Student getStudentById(int roll) {
        return mongoTemplate.findById(roll, Student.class);
    }

    @Override
    public List<Student> getAllStudents() {
        return mongoTemplate.findAll(Student.class);
    }

    @Override
    public void updateStudent(Student student) {
        // Assuming that 'roll' is your unique identifier in MongoDB
        mongoTemplate.save(student);
    }

    @Override
    public void deleteStudent(int roll) {
        mongoTemplate.remove(Objects.requireNonNull(mongoTemplate.findById(roll, Student.class)));
    }

    @Override
    public List<Student> findAllById(List<Integer> ids) {
        return mongoTemplate.find(
                query(where("_id").in(ids)),
                Student.class
        );
    }
    @Override
    public void deleteStudentsByIds(List<Integer> ids) {
        mongoTemplate.remove(
                query(where("_id").in(ids)),
                Student.class
        );
        // You can return the list of deleted students if needed
        ResponseEntity.ok("Successfully Deleted");
    }
}
