import { HttpClient, HttpParams } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { environment } from '../../environments/environment.development';
import { BehaviorSubject, map, Observable } from 'rxjs';
import { User } from '../models/user';

@Injectable({
  providedIn: 'root'
})
export class AuthenticationService {

  authUrl = environment.authApiUrl;

  constructor(private readonly httpClient: HttpClient) { }

  currentUser = new BehaviorSubject<User | null>(null);

  currentUser$ = this.currentUser.asObservable();

  token = new BehaviorSubject<string | null>(null);

  checkUsernameAvailability(username: string): Observable<boolean> {
    const params = new HttpParams().set('username', username);
    return this.httpClient.get<boolean>(`${this.authUrl}/auth/username-available`, { params }).pipe(
      map((response: any) => {
        return response;
      })
    );
  }

  register(newUser: any) {
    return this.httpClient.post<User>(`${this.authUrl}/auth/register`, newUser).pipe(
      map(user => {
        if (user) {
          this.currentUser.next(user);
          localStorage.setItem("token", user.token);
          return true;
        }
        return false;
      })
    )    
  }

  login(usernameOrEmail: string, password: string) : Observable<boolean> {
    return this.httpClient.post<{token: string}>(`${this.authUrl}/auth/login`, { identifier: usernameOrEmail, password: password }).pipe(
      map((response: any) => {
        if (response) {
          this.token.next(response.token);
          this.currentUser.next(response);
          localStorage.setItem("token", response.token);
          return true;
        }
        return false;
      } )
    )
  }

  getToken() {
    return localStorage.getItem('token');
  }

  logout() {
    localStorage.removeItem('token');
    this.currentUser.next(null);
  }
}
