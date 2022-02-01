import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { CommonModule } from '@angular/common';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import {HttpClientModule }from '@angular/common/http';
import { ProfessorComponent } from './professor/professor.component'
import { RouterModule } from '@angular/router';
import { MainComponent } from './main/main.component';
import { AddGradesComponent } from './add-grades/add-grades.component';
import { ViewStudentsComponent } from './view-students/view-students.component';

@NgModule({
  declarations: [
    AppComponent,
    ProfessorComponent,
    MainComponent,
    AddGradesComponent,
    ViewStudentsComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    CommonModule,
    FormsModule,
    HttpClientModule,
    RouterModule

    
  ],
  exports: [ RouterModule ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
