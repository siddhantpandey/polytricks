import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';



import { Http, RequestOptions, Headers, Response } from '@angular/http';
import { Observable } from 'rxjs';
import { map } from 'rxjs/operators';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { User } from '../user/user';
import { AuthService } from 'src/app/core/auth.service';
import { TokenStorage } from 'src/app/core/token.sotrage.service';


@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})
export class RegisterComponent implements OnInit {
  ngOnInit(): void {
    let token = sessionStorage.getItem('AuthToken');
    if(token) {
      alert("You are already logged in. You will be redirected.")
      this.router.navigate(['login']);
    }
    else
      this.user = new User();
  }
  user: User;
  baseUrl:string;
  constructor(private http: HttpClient, private router: Router, private authService: AuthService, private token: TokenStorage) {
    this.baseUrl= "http://localhost:6556/user/";
  }

  register(){
    alert(this.user.username);
    let headers = new HttpHeaders();
    headers.append('Content-Type', 'application/json');
    this.http.post('http://localhost:6556/user/signup', this.user, {headers : headers})
      .subscribe(res => {
         alert('Sign Up Success');//only objects
      })
  }



}
