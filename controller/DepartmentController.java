package com.example.student.controller;

import com.example.student.Service.DepartmentService;
import com.example.student.dto.DepartmentDTO;
import com.example.student.model.Department;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/department")
public class DepartmentController {

    @Autowired
    private DepartmentService departmentService;

    @RequestMapping(value = "/getAllDepartment",method = RequestMethod.GET)
    public ResponseEntity<List<DepartmentDTO>> getAllDepartment(){
        List<DepartmentDTO> departments = this.departmentService.getAllDepartments();

        return new ResponseEntity<>(departments, HttpStatus.OK);
    }

    @RequestMapping(value = "/addDepartment",method = RequestMethod.POST)
    public ResponseEntity<DepartmentDTO> addDepartment(@RequestBody DepartmentDTO departmentDTO){
        DepartmentDTO newDeratment = this.departmentService.addDepartment(departmentDTO);

        return new ResponseEntity<>(newDeratment, HttpStatus.CREATED);
    }

    @RequestMapping(value = "/getDepartmentByID/{departmentID}",method = RequestMethod.GET)
    public ResponseEntity<DepartmentDTO>getDepartmentByID(@PathVariable Integer departmentID){
        DepartmentDTO department = this.departmentService.getDepartmentByID(departmentID);

        return new ResponseEntity<>(department,HttpStatus.OK);
    }
}
