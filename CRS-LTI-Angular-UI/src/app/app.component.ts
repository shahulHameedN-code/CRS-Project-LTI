import { Component, OnInit } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Router } from '@angular/router';
@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit {
  title = 'CRS-LTI-Dev';  
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
    this.router.navigateByUrl("professor");

    
  }
}
