import { Injectable } from "@angular/core";
import { Http, RequestOptions, Headers, Response } from "@angular/http";
import { Observable } from "rxjs";
import { map } from "rxjs/operators";
import { Comments } from "src/app/models/comment";
import { User } from "../components/user/user";




@Injectable({
  providedIn: "root"
})
export class FeedbackService {
  baseUrl: string;
  baseUrl1: string;
  uid: any;
  dummyUser:User;
  dummyUser1:User;
  constructor(private http: Http) {
    this.baseUrl = "http://localhost:6556/comments";
    this.baseUrl1 = "http://localhost:6556/user/email/";
  }

  getJsonContentTypeHeader(): RequestOptions {
    const headers = new Headers();
    headers.append("Content-Type", "application/json");
    return new RequestOptions({ headers: headers });
  }
  
  getUser(emailId:string):Observable<User>{
   // console.log("in email Method");
    console.log(this.baseUrl1+emailId);
    return this.http
      .get(this.baseUrl1+emailId)
      .pipe(map(data => data.json()));
    
  }

  addComment(comments: Comments): Observable<Comments> {
    console.log("in service");
    console.log(comments.user.uEmailId);
    console.log(this.getUser(comments.user.uEmailId));
    
// if(comments.user.uEmailId=="siddhantpandey59@gmail.com"){
//   comments.user.id=1;
// }
// else if(comments.user.uEmailId=="snehith@gmail.com"){
//   comments.user.id=2;
// }
// else if(comments.user.uEmailId=="santhosh@gmail.com"){
//   comments.user.id=3;
// }
// else if(comments.user.uEmailId=="zoya@gmail.com"){
//   comments.user.id=4;
// }
// else if(comments.user.uEmailId=="sheereen@gmail.com"){
//   comments.user.id=5;
// }
// else if(comments.user.uEmailId=="yashwanth@gmail.com"){
//   comments.user.id=6;
// }
// else if(comments.user.uEmailId=="girija@gmail.com"){
//   comments.user.id=8;
// }

    console.log(comments.user.id);
    return this.http
      .post(
        this.baseUrl,
        JSON.stringify(comments),
        this.getJsonContentTypeHeader()
      )
      .pipe(map(data => data.json()));

  }

  
}
