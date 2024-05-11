package com.example.student.Service;

import com.example.student.dao.DepartmentDao;
import com.example.student.dto.DepartmentDTO;
import com.example.student.model.Department;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class DepartmentService {

    @Autowired
    private DepartmentDao departmentDao;

//    public List<Department> getAllDepartments(){
//        List<Department> departments = this.departmentDao.findAll();
//
//        return departments;
//    }

    public List<DepartmentDTO> getAllDepartments(){
        List<Department> departments = this.departmentDao.findAll();


        List<DepartmentDTO> departmentDTOs = new ArrayList<>();
        for (Department department:departments){
          DepartmentDTO departmentDTO = new DepartmentDTO(department);

            departmentDTOs.add(departmentDTO);
        }
        return departmentDTOs;
    }

//    public Department addDepartment(Department department){
//        Department newDepartment = this.departmentDao.saveAndFlush(department);
//
//        return newDepartment;
//    }

    public DepartmentDTO  addDepartment(DepartmentDTO departmentDTO){

        Department department = new Department();

        department.setDepartmentName(departmentDTO.getDepartmentName());
        department.setStatus(departmentDTO.getStatus());

        department = this.departmentDao.saveAndFlush(department);

        return new DepartmentDTO(department);
    }

    public DepartmentDTO getDepartmentByID(Integer departmentID){
        Department department = this.departmentDao.findByDepartmentID(departmentID);

        return new DepartmentDTO(department);
    }
}
