import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { AuthService } from 'src/app/core/auth.service';

import { HttpClientModule } from '@angular/common/http'; import { HttpModule } from '@angular/http';
import { TokenStorage } from 'src/app/core/token.sotrage.service';


@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent {

  constructor(private router: Router, private authService: AuthService, private token: TokenStorage) {
  }

  username: string;
  password: string;
  ngOnInit(): void {
    let token = sessionStorage.getItem('AuthToken');
    if (token) {
      //alert("You are already logged in. Please logout and try again ! You will now be redirected")
      this.router.navigate(['']);
    }
    
  }

  async delay(ms: number) {
    await new Promise(resolve => setTimeout(()=>resolve(), ms)).then(()=>console.log("fired"));
}

  login(): void {
    this.authService.attemptAuth(this.username, this.password).subscribe(
      data => {
        this.token.saveToken(data.token);
        window.location.reload();
        this.delay(3000).then(any=>{
          this.router.navigate(['']);
     });
      }
    );
  }

}
