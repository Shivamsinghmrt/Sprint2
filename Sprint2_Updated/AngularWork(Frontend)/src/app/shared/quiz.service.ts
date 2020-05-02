import { Injectable } from '@angular/core';
import{HttpClient} from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class QuizService {

//------------properties----------------
readonly rootUrl='http://localhost:9094';
result:number=0;
Qns:any[];
seconds:number;
timer;
qnProgress:number

//-------Helper Methods-----------------
  constructor(private http:HttpClient) { }





  //-----Http Methods--------------------


displayTimeTaken(){
  return Math.floor(this.seconds/3600)+':'+ Math.floor(this.seconds/60)+':'+ Math.floor(this.seconds%60)
}




insertParticipant(name:string,id:number,password:string){

var body={
  userId:id,
  userName:name,
  userPassword:password
}
return this.http.post('http://localhost:9094/User/addUser',body,{responseType:'text'});
}


authParticipant(id:number,password:string){

  var body={
    userId:id,
    userPassword:password
  }
  return this.http.post('http://localhost:9094/User/authUser',body,{responseType:'text'});
  }
  
getQuestions(){

  return this.http.get('http://localhost:9094/ques/allQuestions');

}



deleteQuestion(qid:number){

  return this.http.delete('http://localhost:9094/ques/deleteQuestion/'+qid,{responseType:'text'});

}

insertQuestion(title:string,id:number,option:any[],marks:number,answer:number){

  var body={

    questionId:id,
    questionTitle:title,
    questionAnswer:answer,
    questionMarks:marks,
    questionOptions:option

      }
  
  return this.http.put('http://localhost:9094/ques/updateQuestions',body,{responseType:'text'});
  }
  



addQuestion(id:number,title:string,answer:number,marks:number,option:any[]){

  var body={
    questionId:id,
    questionTitle:title,
    questionAnswer:answer,
    questionMarks:marks,
    questionOptions:option
  }
  return this.http.post('http://localhost:9094/ques/addQuestion',body,{responseType:'text'});
  


}



}
