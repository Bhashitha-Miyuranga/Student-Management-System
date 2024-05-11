import {Component, OnInit} from '@angular/core';
import {Router} from "@angular/router";
import {DepartmentService} from "../../../services/department/department.service";


@Component({
  selector: 'app-departments',
  templateUrl: './departments.component.html',
  styleUrls: ['./departments.component.css']
})
export class DepartmentsComponent implements OnInit{

  Departments:any = [];

  constructor(private departmentService : DepartmentService,
              private router : Router){}

  ngOnInit(): void {
    this.departmentService.onDepartmentsChange.subscribe((Departments) =>{
      //console.log("Students : ",students)
      this.Departments = Departments;
    })
  }

  getStudents(){
    this.departmentService.getDepartments();
  }

  addEditDepartmet(){

    this.router.navigate(['/admin/departments/add-edit'])
  }


}
