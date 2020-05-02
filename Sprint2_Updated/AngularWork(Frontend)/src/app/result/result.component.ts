import { Component, OnInit } from '@angular/core';
import { QuizService } from '../shared/quiz.service';

@Component({
  selector: 'app-result',
  templateUrl: './result.component.html',
  styleUrls: ['./result.component.css']
})
export class ResultComponent implements OnInit {

  marks:number=0;
  constructor(private quizService:QuizService) { }

  ngOnInit(): void {
    
    this.marks=this.quizService.result;
    
  }
  ngOnDestroy(){
    this.marks=0;
    this.quizService.result=0;
  }

}
