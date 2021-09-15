import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs/internal/Observable';
import { Injectable } from '@angular/core';
import { environment } from 'src/environments/environment';
import { User } from '../model/user.model';

@Injectable()
export class UserService {

    private userServiceUrl: string;

    constructor(private http: HttpClient) {
        this.userServiceUrl = environment.user_service_backend_url;
    }

    public findAll(): Observable<User[]> {
        return this.http.get<User[]>(this.userServiceUrl + "findAllUsers");
    }

    public save(user: User) {
        return this.http.post<User>(this.userServiceUrl + "addUser", user);
    }

    public deleteUser(user: User) {
        return this.http.delete<User>(this.userServiceUrl.concat("deleteUser/" + user.id));
    }

    public getUserById(id: Number) {
        return this.http.get<User>(this.userServiceUrl + 'findById/' + id);
    }

    public updateuser(id: Number, user: User) {
        return this.http.put<User>(this.userServiceUrl + 'updateUser/' + id, user);
    }

}