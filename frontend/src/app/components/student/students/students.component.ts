import {Component, OnInit} from '@angular/core';
import {StudentService} from "../../../services/student/student.service";
import {Router} from "@angular/router";

@Component({
  selector: 'app-students',
  templateUrl: './students.component.html',
  styleUrls: ['./students.component.css']
})
export class StudentsComponent implements OnInit{

  students:any = [];

  constructor(private studentService : StudentService,
              private router : Router){}

  ngOnInit(): void {
    this.studentService.onStudentsChange.subscribe((students) =>{
      //console.log("Students : ",students)
      this.students = students;
    })
  }

  getStudents(){
    this.studentService.getStudents();
  }

  addEditStudent(student:any){
    //console.log("Student : ",student)

    if (student != null){
      sessionStorage.setItem('studentID',student.studentID);
    }else{
      sessionStorage.removeItem("studentID");
    }

    this.router.navigate(['/admin/students/add-edit'])
  }

}
