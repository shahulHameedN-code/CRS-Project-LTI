import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AddGradesComponent } from './add-grades/add-grades.component';
import { AppComponent } from './app.component';
import { MainComponent } from './main/main.component';
import { ProfessorComponent } from './professor/professor.component';
import { ViewStudentsComponent } from './view-students/view-students.component';

const routes: Routes = [
  {
    path:"",
    component:MainComponent

  },
  {
    path:"home",
    component:MainComponent

  },
  {
    path:"professor",
    component:ProfessorComponent
  },
  {
    path:"professor/addGrades",
    component:AddGradesComponent
  },
  {
    path:"professor/viewStudents",
    component:ViewStudentsComponent
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)]
})
export class AppRoutingModule { }
