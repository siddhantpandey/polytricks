import {Injectable} from '@angular/core';

import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable()
export class AuthService {

  baseUrl: 'http://localhost:6556/email2sms/';

  constructor(private http: HttpClient) {
  }

  attemptAuth(ussername: string, password: string): Observable<any> {
    const credentials = {username: ussername, password: password};
    console.log('attempAuth ::');
    return this.http.post<any>('http://localhost:6556/token/generate-token', credentials);
  }

  isAuthenticated() {
    // get the auth token from localStorage
    let token = sessionStorage.getItem('AuthToken');

    // check if token is set, then...
    if (token) {
        return true;
    }

    return false;
}

parseJwt (token) {
  var base64Url = token.split('.')[1];
  var base64 = base64Url.replace(/-/g, '+').replace(/_/g, '/');
  return JSON.parse(window.atob(base64));
};

}
