import {Component, OnInit} from '@angular/core';

import {Router} from '@angular/router';
import { MatTableDataSource } from '@angular/material';
import { User } from './user';
import { UserService } from 'src/app/app.service';

@Component({
  selector: 'app-root',
  templateUrl: './user.component.html',
  styleUrls: ['./user.component.css']
})
export class UserComponent implements OnInit {
  displayedColumns = ['id', 'username', 'uName', 'uEmailId'];
  dataSource = new MatTableDataSource<User>();
  constructor(private router: Router, private userService: UserService) {
  }
  ngOnInit(): void {
    this.userService.getUsers().subscribe(
      data => {
        this.dataSource.data = data;
        console.log(this.dataSource);
      }
    );
  }
}

