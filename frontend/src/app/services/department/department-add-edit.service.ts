import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Resolve} from "@angular/router";
import {BehaviorSubject, Observable, Subject} from "rxjs";

@Injectable({
  providedIn: 'root'
})
export class DepartmentAddEditService implements Resolve<any>{

  student = new BehaviorSubject({});
  onDepartmentsChanged = new Subject();

  constructor(private httpClient : HttpClient) { }

  resolve(): Observable<any> | Promise<any> | any {
    // this.getDepartmentByID();
    // this.getAllDepartment();
  }

  // getDepartmentByID(){
  //   //console.log("Call getStudentByID")
  //
  //   let DepartmentID = sessionStorage.getItem("studentID");
  //
  //   //console.log("getStudentByID : ",studentID)
  //   if(studentID != null){
  //     this.httpClient.get(`http://localhost:8080/student/getStudentByID/${studentID}`)
  //       .subscribe((student) => {
  //         //console.log("Student : ",student)
  //         this.student.next(student);
  //       })
  //   }else {
  //     //console.log("Student ID null")
  //     this.student.next({});
  //   }
  // }
  //
  // getAllDepartment(){
  //   this.httpClient.get('http://localhost:8080/department/getAllDepartment')
  //     .subscribe((departments) => {
  //       //console.log("departments",departments)
  //       this.onDepartmentsChanged.next(departments);
  //     })
  // }

  saveStudent(data:any){
    this.httpClient.post('http://localhost:8080/department/addDepartment',data)
      .subscribe((department) => {
        this.student.next(department);
        alert("Data are saved !")
      })
  }
}
