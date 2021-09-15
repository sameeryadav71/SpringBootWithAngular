import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { AddUserComponent } from './user/add-user/add-user.component';
import { UpdateUserComponent } from './user/update-user/update-user.component';
import { ViewUserComponent } from './user/view-user/view-user.component';

const routes: Routes = [
  { path: 'users', component: ViewUserComponent },
  { path: 'adduser', component: AddUserComponent },
  { path: 'updateuser/:id',component: UpdateUserComponent},
  { path: '', component:ViewUserComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
