import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import {LoginComponent} from "./components/login/login.component";
import {AdminLayoutComponent} from "./components/admin-layout/admin-layout.component";
import {StudentsComponent} from "./components/student/students/students.component";
import {DepartmentsComponent} from "./components/department/departments/departments.component";
import {DashboardComponent} from "./components/dashboard/dashboard.component";
import {StudentService} from "./services/student/student.service";
import {StudentAddEditComponent} from "./components/student/student-add-edit/student-add-edit.component";
import {StudentAddEditService} from "./services/student/student-add-edit.service";
import {DepartmentService} from "./services/department/department.service";
import {DepartmentAddEditComponent} from "./components/department/department-add-edit/department-add-edit.component";
import {DepartmentAddEditService} from "./services/department/department-add-edit.service";

const routes: Routes = [
  {
    path:'',
    redirectTo:'login',
    pathMatch:'full'
  },
  {
    path:'login',
    component:LoginComponent
  },
  {
    path:'admin',
    component:AdminLayoutComponent,
    children: [
      {
        path:'dashboard',
        component : DashboardComponent
      },
      {
        path : 'students',
        component :StudentsComponent,
        resolve:{
          data : StudentService
        }
      },
      {
        path: 'students/add-edit',
        component:StudentAddEditComponent,
        resolve: {
          data : StudentAddEditService
        }
      },
      {
        path: 'departments/add-edit',
        component:DepartmentAddEditComponent,
        resolve: {
          data : DepartmentAddEditService
        }
      },
      {
        path : 'departments',
        component : DepartmentsComponent,
        resolve: {
          data : DepartmentService
        }
      }
    ]
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
