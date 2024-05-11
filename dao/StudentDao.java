package com.example.student.dao;

import com.example.student.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentDao extends JpaRepository<Student, Integer> {

    Student findByStudentID(Integer studentID);

    List<Student> findAllByDistrict(String district);
}
