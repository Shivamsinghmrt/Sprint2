
import { Routes } from '@angular/router';
import { RegisterComponent } from './register/register.component';
import { QuizComponent } from './quiz/quiz.component';
import { ResultComponent } from './result/result.component';
import { AuthGuard } from './auth/auth.guard';
import { LoginComponent } from './login/login.component';
import { WelcomeComponent } from './welcome/welcome.component';
import { AdminComponent } from './admin/admin.component';
import { Component } from '@angular/core';
import { QuesCrudComponent } from './admin/ques-crud/ques-crud.component';

export const appRoutes:Routes=[

{path:'register',component:RegisterComponent},
{path:'quiz',component:QuizComponent},
{path:'result',component:ResultComponent },
{path:'login',component:LoginComponent },
{path:'welcome',component:WelcomeComponent },
{path:'quesCrud',component:QuesCrudComponent},
{
    path:'admin',component:AdminComponent, 
  // children:[{path:'quesCrud',component:QuesCrudComponent}]
},
{path:'**',redirectTo:'welcome',pathMatch:'full'}
//canActivate:[AuthGuard]
];