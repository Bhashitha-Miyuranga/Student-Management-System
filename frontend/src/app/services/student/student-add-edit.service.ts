import { Injectable } from '@angular/core';
import {Resolve} from "@angular/router";
import {Observable} from "rxjs";
import {HttpClient} from "@angular/common/http";
import {BehaviorSubject} from "rxjs";
import {Subject} from "rxjs";

@Injectable({
  providedIn: 'root'
})
export class StudentAddEditService implements Resolve<any>{

  student = new BehaviorSubject({});
  onDepartmentsChanged = new Subject();

  constructor(private httpClient : HttpClient) { }

  resolve(): Observable<any> | Promise<any> | any {
    this.getStudentByID();
    this.getAllDepartment();
  }

  getStudentByID(){
    //console.log("Call getStudentByID")

    let studentID = sessionStorage.getItem("studentID");

    //console.log("getStudentByID : ",studentID)
    if(studentID != null){
      this.httpClient.get(`http://localhost:8080/student/getStudentByID/${studentID}`)
        .subscribe((student) => {
          //console.log("Student : ",student)
          this.student.next(student);
        })
    }else {
      //console.log("Student ID null")
      this.student.next({});
    }
  }

  getAllDepartment(){
    this.httpClient.get('http://localhost:8080/department/getAllDepartment')
      .subscribe((departments) => {
        //console.log("departments",departments)
        this.onDepartmentsChanged.next(departments);
      })
  }

  saveStudent(data:any){
    this.httpClient.post('http://localhost:8080/student/addStudent',data)
      .subscribe((student) => {
        this.student.next(student);
        alert("Data are saved !")
      })
  }

}
