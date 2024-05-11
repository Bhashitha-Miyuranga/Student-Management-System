import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { LoginComponent } from './components/login/login.component';
import { AdminLayoutComponent } from './components/admin-layout/admin-layout.component';
import {FormsModule, ReactiveFormsModule} from "@angular/forms";
import { StudentsComponent } from './components/student/students/students.component';
import { DepartmentsComponent } from './components/department/departments/departments.component';
import {HttpClientModule} from "@angular/common/http";
import { DashboardComponent } from './components/dashboard/dashboard.component';
import { StudentAddEditComponent } from './components/student/student-add-edit/student-add-edit.component';
import { DepartmentAddEditComponent } from './components/department/department-add-edit/department-add-edit.component';

@NgModule({
  declarations: [
    AppComponent,
    LoginComponent,
    AdminLayoutComponent,
    StudentsComponent,
    DepartmentsComponent,
    DashboardComponent,
    StudentAddEditComponent,
    DepartmentAddEditComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    ReactiveFormsModule,
    HttpClientModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
