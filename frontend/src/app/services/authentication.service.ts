import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { environment } from '../../environments/environment.development';
import { BehaviorSubject, map, Observable } from 'rxjs';
import { User } from '../models/user';

@Injectable({
  providedIn: 'root'
})
export class AuthenticationService {

  constructor(private readonly httpClient: HttpClient) { }

  currentUser = new BehaviorSubject<User | null>(null);

  currentUser$ = this.currentUser.asObservable();

  token = new BehaviorSubject<string | null>(null);

  register(newUser: any) {
    return this.httpClient.post<User>(`${environment.authApiUrl}/register`, newUser).pipe(
      map(user => {
        console.log(user);
        if (user) {
          this.currentUser.next(user);
          console.log("current user:", this.currentUser);
          localStorage.setItem("token", user.token);
          return true;
        }
        return false;
      })
    )    
  }

  login(email: string, password: string) : Observable<boolean> {
    return this.httpClient.post<string>(`${environment.authApiUrl}/login`, { email: email, password: password }).pipe(
      map((response: any) => {
        console.log(response);
        if (response) {
          this.token.next(response.token);
          this.currentUser.next(response);
          return true;
        }
        return false;
      } )
    )
  }

  getToken() {
    console.log(this.token.subscribe());
    return this.token.subscribe();
  }

  logout() {
    localStorage.removeItem('user');
    this.currentUser.next(null);
  }
}
