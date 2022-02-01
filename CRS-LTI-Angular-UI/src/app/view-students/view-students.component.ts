import { Component, OnInit } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Router } from '@angular/router';
import { BrowserModule } from '@angular/platform-browser'

@Component({
  selector: 'app-view-students',
  templateUrl: './view-students.component.html',
  styleUrls: ['./view-students.component.css']
})
export class ViewStudentsComponent implements OnInit {




  studentId:any;
  courseId:any;
   grade:any ;
   result :any []=[];
   loginResult:any;


   constructor(private http:HttpClient, private router:Router){}

  ngOnInit(): void {
  }



  viewStudents() {
     let url="http://localhost:8080/gateway/professor/viewStudents/"+this.courseId;
  //  let url="http://localhost:8081/professor/viewStudents/"+this.courseId;
   
    this.http.get<any>(url).subscribe((res : any[])=>{
     console.log(res);
   // this.logger.debug(res);
   this.result = res;

});
    

    
  }


}
