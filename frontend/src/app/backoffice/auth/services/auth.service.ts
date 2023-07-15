import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { environment } from 'src/environments/environment';
import { TokenInfo } from '../models/token-info';
import { Credential } from '../models/credential';

@Injectable({
  providedIn: 'root'
})
export class AuthService {

  private readonly cBASE_URL = environment.api.url + 'public/authenticate';

  authenticated = false;

  constructor(private _http: HttpClient) { 

    const authToken = localStorage.getItem('jwt');

    if (authToken) {
      this.authenticated = true;
    }
  }

  authenticate(credentials: Credential, callback) {

    this._http.post<TokenInfo>(this.cBASE_URL, credentials).subscribe(response => {

      if (response.jwtToken) {

        this.authenticated = true; 

        localStorage.setItem('jwt', response.jwtToken);
      } 
      else {
        this.authenticated = false;
      }
      
      return callback && callback();
    });
  }

  logout() {

    this.authenticated = false;

    localStorage.removeItem('jwt');
  }
}
