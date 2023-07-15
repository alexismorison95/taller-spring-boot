import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { AuthService } from '../../services/auth.service';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  public formGroup: FormGroup;

  constructor(
    private _router: Router,
    private _auth: AuthService,
    private _fb: FormBuilder
  ) { }

  ngOnInit(): void {

    this.formGroup = this._fb.group({
      username: ['mlopez', Validators.required],
      password: ['secreto', Validators.required]
    });
  }

  login() {

    this._auth.authenticate(this.formGroup.value, () => {

        this._router.navigateByUrl('/backoffice');
    });

    return false;
  }

}
