import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { BehaviorSubject, Observable } from 'rxjs';
import { map } from 'rxjs/operators';

import { User } from '../_models/user';

@Injectable({ providedIn: 'root' })
export class AuthenticationService {
    private currentUserSubject: BehaviorSubject<User>;
    domain: string = 'http://localhost:2020';
    public currentUser: Observable<User>;
    token: String = "";

    constructor(private http: HttpClient) {
        this.currentUserSubject = new BehaviorSubject<User>(JSON.parse(localStorage.getItem('currentUser')));
        this.currentUser = this.currentUserSubject.asObservable();
    }

    public get currentUserValue(): User {
        return this.currentUserSubject.value;
    }

    login(username: string, password: string) {

        return this.http.post<any>(this.domain + `/users/authentication`, { username, password })
            .pipe(map(user => {
                // login successful if there's a jwt token in the response
                console.log(user);

                if (user && user.token) {
                    console.log("here");
                    // store user details and jwt token in local storage to keep user logged in between page refreshes
                    localStorage.setItem('currentUser', user.token);
                    this.currentUserSubject.next(user);
                }
                console.log("Done")

                return user;
            }));
    }

    logout() {
        // remove user from local storage to log user out
        localStorage.removeItem('currentUser');
        this.currentUserSubject.next(null);
    }

    getUserFromSession() {

        this.token = localStorage.getItem('currentUser');
        console.log(this.domain + `/users/session/` + this.token);
        return this.http.get<User>(this.domain + '/users/session/' + this.token);
    }
}