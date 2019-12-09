import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { FormGroup, FormBuilder, Validators, FormControl, FormGroupDirective, NgForm } from '@angular/forms';
import { AuthenticationService, UserService } from '../_services';
import { first } from 'rxjs/operators';

import { ErrorStateMatcher } from '@angular/material';






export class MyErrorStateMatcher implements ErrorStateMatcher {
  isErrorState(control: FormControl | null, form: FormGroupDirective | NgForm | null): boolean {
    const invalidCtrl = !!(control && control.invalid && control.parent.dirty);
    const invalidParent = !!(control && control.parent && control.parent.invalid && control.parent.dirty);

    return (invalidCtrl || invalidParent);
  }
}

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.scss']
})
export class RegisterComponent implements OnInit {

  loginForm: FormGroup;
  loading = false;
  notsame = false;
  submitted = false;
  returnUrl: string;
  error = '';

  matcher = new MyErrorStateMatcher();

  constructor(
    private formBuilder: FormBuilder,
    private route: ActivatedRoute,
    private router: Router,
    private userService : UserService


  ) {
    this.loginForm = this.formBuilder.group({
      firstName: ['', Validators.required],
      lastName: ['', Validators.required],
      email: ['', Validators.required],
      password: ['', Validators.required],
      confirmPassword: ['', Validators.required],

    }), { validator: this.checkPasswords(this.loginForm) };
  }

  ngOnInit() {


  }



  get f() { return this.loginForm.controls; }

  onSubmit() {
    this.submitted = true;
    // stop here if form is invalid
    if (this.loginForm.invalid) {
      return;
    }

    this.checkPasswords(this.loginForm);

    if (!this.notsame) {
      this.loading = true;
      this.userService.register(this.f.firstName.value, this.f.lastName.value, this.f.email.value, this.f.password.value, this.f.confirmPassword.value)
      .subscribe(
          data => {
            this.router.navigate(['/login']);
          },
          error => {
            this.error = error;
            if(error == "OK"){
              this.router.navigate(['/login']);
            }

            this.loading = false;
          });
    }
  }


  checkPasswords(group: FormGroup) { // here we have the 'passwords' group

    let pass = group.get('password').value;
    let confirmPass = group.get('confirmPassword').value;
    console.log(pass);
    console.log(confirmPass);

    return pass === confirmPass ? null : { notsame: true };
   
  }


}

