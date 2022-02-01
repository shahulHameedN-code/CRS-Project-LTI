import { Component, OnInit } from '@angular/core';
import { HttpClient, JsonpClientBackend } from '@angular/common/http';
import { Router } from '@angular/router';

@Component({
  selector: 'app-add-grades',
  templateUrl: './add-grades.component.html',
  styleUrls: ['./add-grades.component.css']
})
export class AddGradesComponent implements OnInit {


  studentId:any;
  courseId:any;
   grade:any ;
   result :any;
   loginResult:any;
  finalRes:any;
  obj :any;
  constructor(private http:HttpClient, private router:Router){}

  ngOnInit(): void {
  }


  addGrades() {
      let url="http://localhost:8080/gateway/professor/addGrades"
    // let url="http://localhost:8081/professor/addGrades"
     this.http.post<any>(url,{
       studentId:this.studentId,
       courseId:this.courseId,
       grade:this.grade
     }
     ).subscribe((res : any[])=>{
      console.log(res);
    // this.logger.debug(res);
    this.result = res;

});

this.finalRes="Grade Added Successfully";
     
 
     
   }

}
