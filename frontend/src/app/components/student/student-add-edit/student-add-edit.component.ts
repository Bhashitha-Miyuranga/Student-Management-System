import {Component, OnDestroy, OnInit} from '@angular/core';
import {StudentAddEditService} from "../../../services/student/student-add-edit.service";
import {Subscription} from "rxjs";
import {FormBuilder, FormGroup} from "@angular/forms";
import {StudentDTO} from "../dto/student";
import * as _ from 'underscore';
import {Location} from "@angular/common";

@Component({
  selector: 'app-student-add-edit',
  templateUrl: './student-add-edit.component.html',
  styleUrls: ['./student-add-edit.component.css']
})
export class StudentAddEditComponent implements OnInit,OnDestroy{

  studentForm : FormGroup;
  student = new StudentDTO();
  pageType : string;
  departments : any = [];
  onStudentChangeSub = new Subscription();

  constructor(private studentAddEditService : StudentAddEditService,
              private fb : FormBuilder,
              private location : Location ){}

  ngOnInit(): void {

    this.studentAddEditService.onDepartmentsChanged
      .subscribe((departments) => {
        //console.log("departmentsss",departments)
        this.departments = departments;
      })

    this.onStudentChangeSub = this.studentAddEditService.student.subscribe((student) => {
      if (!_.isEmpty(student)){
        this.student = new StudentDTO(student);
        this.pageType ='edit';
      } else {
        this.student = new StudentDTO();
        this.pageType = 'new'
      }
      //console.log("yyyy : ",this.student)
      this.studentForm = this.createForm();
    })
  }

  ngOnDestroy(): void {
    this.onStudentChangeSub.unsubscribe();
  }

  createForm(){
    return this.fb.group({
      studentID: [this.student.studentID],
      first_Name: [this.student.first_Name],
      last_Name : [this.student.last_Name],
      district : [this.student.district],
      departmentID : [this.student.departmentID]
    })
  }

  savaData(){
    let data = this.studentForm.getRawValue();

    //console.log("data",data)

      this.studentAddEditService.saveStudent(data);
  }

  goBack(){
    this.location.back();
  }

}
