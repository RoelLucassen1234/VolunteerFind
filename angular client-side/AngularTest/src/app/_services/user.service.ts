import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';

import { User } from '../_models';
import { RestService } from './rest.service';
import { UserView } from '../_models/user copy';

@Injectable({ providedIn: 'root' })
export class UserService {
  private user: UserView;
  constructor(private http: HttpClient, private restServer: RestService) { }

  getAll() {
    return this.http.get<User[]>(this.restServer.getRestUrl() + `/users`);
  }

  register(firstName: string, lastName: string, email: string, password: string, confPass: string) {
    this.user = new UserView();
    this.user.firstName = firstName;
    this.user.lastName = lastName;
    this.user.email = email;
    this.user.password = password;
    this.user.confirmPass = confPass;

    console.log(this.restServer.getRestUrl() + '/users')
    return this.http.post('http://localhost:2020/users', this.user);
  }

  getCertainUser(userId : number){
    
    return this.http.get<User>(this.restServer.getRestUrl() + '/users/ ' + userId);
  }
}