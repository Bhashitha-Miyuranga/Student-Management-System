export class DepartmentDTO {

  departmentID;
  departmentName;
  status;

  constructor(department?:any){
    department = department || {};
    this.departmentID = department.departmentID || null;
    this.departmentName = department.departmentName || '';
    this.status = department.status || '';
  }
}
