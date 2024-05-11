package com.example.student.dao;


import com.example.student.model.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DepartmentDao extends JpaRepository<Department, Integer> {

    Department findByDepartmentID(Integer departmentID);
}
