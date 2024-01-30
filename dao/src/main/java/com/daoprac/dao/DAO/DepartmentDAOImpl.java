package com.daoprac.dao.DAO;

import com.daoprac.dao.models.Department;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.List;
import java.util.Objects;

import static org.springframework.data.mongodb.core.query.Criteria.where;
import static org.springframework.data.mongodb.core.query.Query.query;

@Repository
public class DepartmentDAOImpl implements DepartmentDAO {
    @Autowired
    private MongoTemplate mongoTemplate;

    @Override
    public void saveDepartment(Department department) {
        mongoTemplate.save(department);
    }

    @Override
    public Department getDepartmentById(int roll) {
        return mongoTemplate.findById(roll, Department.class);
    }

    @Override
    public List<Department> getAllDepartment() {
        return mongoTemplate.findAll(Department.class);
    }

    @Override
    public void updateDepartment(Department department) {
        // Assuming that 'roll' is your unique identifier in MongoDB
        mongoTemplate.save(department);
    }

    @Override
    public void deleteDepartment(int roll) {
        mongoTemplate.remove(Objects.requireNonNull(mongoTemplate.findById(roll, Department.class)));
    }

    @Override
    public List<Department> findAllDepartmentById(List<Integer> ids) {
        return mongoTemplate.find(
                query(where("_id").in(ids)),
                Department.class
        );
    }

    @Override
    public void deleteDepartmentByIds(List<Integer> ids) {
        mongoTemplate.remove(
                query(where("_id").in(ids)),
                Department.class
        );
        // You can return the list of deleted students if needed
        ResponseEntity.ok("Successfully Deleted");
    }


}
