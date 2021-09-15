import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { User } from '../model/user.model';
import { UserService } from '../services/user.service';

@Component({
  selector: 'app-update-user',
  templateUrl: './update-user.component.html',
  styleUrls: ['./update-user.component.css']
})
export class UpdateUserComponent implements OnInit {

  id: number;
  user: User;

  constructor(    private route: ActivatedRoute, 
    private router: Router,
    private userService: UserService) { }

  ngOnInit(): void {
    this.user = new User();
    this.id = this.route.snapshot.params['id'];
    this.userService.getUserById(this.id)
      .subscribe((data:User) => {
        this.user = data;
      }, 
      error => console.log(error)
      );
  }

  updateUser() {
    this.userService.updateuser(this.id,this.user).subscribe(
      (data:User) => {
        this.gotoUserList();
      },
       error => console.log(error));
  }

  onSubmit() {
    this.updateUser();
  }

  gotoUserList() {
    this.router.navigate(['/users']);
  }

}
