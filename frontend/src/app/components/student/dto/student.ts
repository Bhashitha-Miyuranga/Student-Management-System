export class StudentDTO {

  studentID;
  first_Name;
  last_Name;
  district;
  departmentID;

  constructor(student?:any){
    student = student || {};
    this.studentID = student.studentID || null;
    this.first_Name = student.first_Name || '';
    this.last_Name = student.last_Name || '';
    this.district = student.district || '';
    this.departmentID = student.departmentID || null;
  }
}
