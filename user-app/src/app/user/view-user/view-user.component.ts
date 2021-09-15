import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { User } from '../model/user.model';
import { UserService } from '../services/user.service';

@Component({
  selector: 'app-view-user',
  templateUrl: './view-user.component.html',
  styleUrls: ['./view-user.component.css']
})
export class ViewUserComponent implements OnInit {

  users: User[] = [];

  constructor(private userService: UserService,
    private router: Router) { }

  ngOnInit(): void {
    this.userService.findAll().subscribe((userData: User[]) => {
      this.users = userData;
    },
      error => {
        console.log(error);
      }
    )
  }

  deleteUser(user: User): void {
    this.userService.deleteUser(user)
      .subscribe(data => {
        this.users = this.users.filter(u => u !== user);
      },
        error => {
          console.log(error);
        }
      )
  }

  editUser(user: User): void {
    this.router.navigate(['updateuser', user.id]);
  }

}
