import { Component, OnInit } from '@angular/core';

import { Router } from '@angular/router';
import { TokenStorage } from 'src/app/core/token.sotrage.service';


@Component({
  selector: 'app-loginsuccess',
  templateUrl: './loginsuccess.component.html',
  styleUrls: ['./loginsuccess.component.css']
})
export class LoginsuccessComponent implements OnInit {

  //tokenStore: TokenStorage;
  constructor(private router: Router, private token: TokenStorage) { }

  ngOnInit() {
  }

  logout(): void {
    this.token.signOut();
    this.router.navigate(['login']);
  }

}
