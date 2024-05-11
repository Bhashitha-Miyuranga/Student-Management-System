import { Component } from '@angular/core';
import {FormBuilder, FormGroup} from "@angular/forms";
import {StudentDTO} from "../../student/dto/student";
import {StudentAddEditService} from "../../../services/student/student-add-edit.service";
import * as _ from 'underscore';
import {Subscription} from "rxjs";
import {DepartmentAddEditService} from "../../../services/department/department-add-edit.service";
import {DepartmentDTO} from "../dto/departmentDTO";
import {Location} from "@angular/common";

@Component({
  selector: 'app-department-add-edit',
  templateUrl: './department-add-edit.component.html',
  styleUrls: ['./department-add-edit.component.css']
})
export class DepartmentAddEditComponent {

  DepartmentForm : FormGroup;
  department: DepartmentDTO = new DepartmentDTO();
  pageType : string;
  onDepartmentChangeSub = new Subscription();

  constructor(private departmentAddEditService : DepartmentAddEditService,
              private fb : FormBuilder,
              private location : Location){}

  ngOnInit(): void {


    this.onDepartmentChangeSub = this.departmentAddEditService.student.subscribe((departments) => {
      if (!_.isEmpty(departments)){
        this.department = new DepartmentDTO(departments);
        this.pageType ='edit';
      } else {
        this.department = new DepartmentDTO();
        this.pageType = 'new'
      }
      //console.log("yyyy : ",this.student)
      this.DepartmentForm = this.createForm();
    })
  }

  ngOnDestroy(): void {
    this.onDepartmentChangeSub.unsubscribe();
  }

  createForm(){
    return this.fb.group({
      departmentID: [this.department.departmentID],
      departmentName: [this.department.departmentName],
      status : [this.department.status]
    })
  }

  savaData(){
    let data = this.DepartmentForm.getRawValue();

    //console.log("data",data)

    this.departmentAddEditService.saveStudent(data);
  }

}
