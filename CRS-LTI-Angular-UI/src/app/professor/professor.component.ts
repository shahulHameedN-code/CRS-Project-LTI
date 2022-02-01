import { Component, OnInit } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Router } from '@angular/router';

@Component({
  selector: 'app-professor',
  templateUrl: './professor.component.html',
  styleUrls: ['./professor.component.css']
})
export class ProfessorComponent implements OnInit {

  studentId:any;
  courseId:any;
   grade:any ;
   result :any;
   loginResult:any;
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
     
 
     
   }

}
