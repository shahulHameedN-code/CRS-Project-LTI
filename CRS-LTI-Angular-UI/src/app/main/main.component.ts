import { Component, OnInit } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Router } from '@angular/router';

@Component({
  selector: 'app-main',
  templateUrl: './main.component.html',
  styleUrls: ['./main.component.css']
})
export class MainComponent implements OnInit {

  username:any;
  password:any;
   getData:any ;
   result :any;
   loginResult:any;
   constructor(private http:HttpClient, private router:Router){}
 
   ngOnInit(): void {
     
   }
   login() {
     let url="http://localhost:8080/gateway/login"
 
     this.http.post<any>(url,{
       userName:this.username,
       password:this.password
     }).toPromise();
     console.log("in login");
     this.router.navigateByUrl("professor");
 
     
   }

}
