import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-admin',
  templateUrl: './admin.component.html',
  styleUrls: ['./admin.component.css']
})
export class AdminComponent implements OnInit {

  select:boolean=false;
  select1:boolean=false;
  constructor() { }


  OnCrud(){
this.select=!this.select;
if(this.select){
this.select1=false;
}
  }
  NoCrud(){
    this.select1=!this.select1;
    if(this.select1){
    this.select=false;
    }
  }
  ngOnInit(): void {
  }

}
