import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Resolve} from "@angular/router";
import {Observable, Subject} from "rxjs";

@Injectable({
  providedIn: 'root'
})
export class DepartmentService implements Resolve<any>{

  onDepartmentsChange = new Subject()

  constructor(private httpClient : HttpClient) { }

  resolve(): Observable<any> | Promise<any> | any{
    this.getDepartments();
  }

  getDepartments(){
    this.httpClient.get('http://localhost:8080/department/getAllDepartment')
      .subscribe((Departments) => {
        //console.log("students",students)
        this.onDepartmentsChange.next(Departments);
      })
  }
}
