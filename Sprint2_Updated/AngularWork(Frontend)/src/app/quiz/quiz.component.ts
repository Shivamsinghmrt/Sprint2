import { Component, OnInit } from '@angular/core';
import { QuizService } from '../shared/quiz.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-quiz',
  templateUrl: './quiz.component.html',
  styleUrls: ['./quiz.component.css']
})
export class QuizComponent implements OnInit {
  
  
  constructor(public quizService:QuizService,private route:Router) { }

  ngOnInit(): void {

  this.quizService.seconds=0;
  this.quizService.qnProgress=0;
this.quizService.getQuestions().subscribe(
  (data:any)=>{

    this.quizService.Qns=data;
    console.log(data)
    console.log(this.quizService.Qns[this.quizService.qnProgress].questionTitle)
  
    this.startTimer();
  }
)
  }



startTimer(){
  this.quizService.timer=setInterval(()=>{
this.quizService.seconds++;

  },1000);
}

Answer(qid,choice){
  this.quizService.Qns[this.quizService.qnProgress].chosenAnswer=choice;
//  console.log("your answer"+choice)
  //console.log("correct answer"+this.quizService.Qns[this.quizService.qnProgress].questionAnswer)
  if(choice===(this.quizService.Qns[this.quizService.qnProgress].questionAnswer-1)){
    this.quizService.result=this.quizService.result+this.quizService.Qns[this.quizService.qnProgress].questionMarks;    
  }
  this.quizService.qnProgress++;
  if(this.quizService.qnProgress==2){
    clearInterval(this.quizService.timer);
    
    this.route.navigate(['/result']);
  }

}

}
