import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Subject} from "rxjs";
import {Resolve} from "@angular/router";
import {Observable} from "rxjs";

@Injectable({
  providedIn: 'root'
})
export class StudentService implements Resolve<any>{

  onStudentsChange = new Subject()

  constructor(private httpClient : HttpClient) { }

  resolve(): Observable<any> | Promise<any> | any{
    this.getStudents();
  }

  getStudents(){
    this.httpClient.get('http://localhost:8080/student/getAllStudent')
      .subscribe((students) => {
        //console.log("students",students)
        this.onStudentsChange.next(students);
      })
  }
}
