import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { User } from '../model/user.model';
import { UserService } from '../services/user.service';

@Component({
  selector: 'app-add-user',
  templateUrl: './add-user.component.html',
  styleUrls: ['./add-user.component.css']
})
export class AddUserComponent implements OnInit {

  user: User

  constructor(private route: ActivatedRoute,
     private router: Router, 
     private userService: UserService) { }

  ngOnInit(): void {
    this.user = new User();
  }

  onSubmit() {
    this.userService.save(this.user).subscribe(
      (user: User) => {
        if (user != null)
        {
          this.gotoUserList();
        }
        else
        {
          alert("User already present with email : " + this.user.email);
        }
      },
      error => {
        console.log(error);
      });
  }

  gotoUserList() {
    this.router.navigate(['/users']);
  }

}
