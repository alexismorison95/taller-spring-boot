import { Component, OnInit } from '@angular/core';
import { AuthService } from './auth/services/auth.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-backoffice',
  templateUrl: './backoffice.component.html',
  styleUrls: ['./backoffice.component.css']
})
export class BackofficeComponent implements OnInit {

  constructor(
    public _auth: AuthService,
    private _router: Router
  ) { }

  ngOnInit(): void {
  }

  logout() {

    this._auth.logout();

    this._router.navigateByUrl('/backoffice/login');
  }

}
