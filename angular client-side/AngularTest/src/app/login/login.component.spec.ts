import { async, TestBed, ComponentFixture } from '@angular/core/testing';
import { RouterTestingModule } from '@angular/router/testing';
import { LoginComponent } from './login.component';
import { DebugElement } from '@angular/core';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { By } from '@angular/platform-browser';
import { compileBaseDefFromMetadata } from '@angular/compiler';
import { MatButtonModule, MatFormFieldModule, MatInputModule, MatRippleModule } from '@angular/material';
import { MaterialModule } from '../material.module';
import { AppModule } from '../app.module';
import { HttpClientTestingModule, HttpTestingController } from '@angular/common/http/testing';
import { HttpClientModule } from '@angular/common/http';
import { AuthenticationService } from '../_services';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';



describe('LoginComponent', () => {
  let comp: LoginComponent;
  let fixture: ComponentFixture<LoginComponent>;
  let de: DebugElement;
  let el: HTMLElement;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      imports: [
        RouterTestingModule,
        BrowserAnimationsModule,
        ReactiveFormsModule,
        FormsModule,
        HttpClientTestingModule,
        MaterialModule

      ],
      declarations: [
        LoginComponent,
      ],
      

    }).compileComponents().then(() => {
      fixture = TestBed.createComponent(LoginComponent);
      fixture.detectChanges();
      comp = fixture.componentInstance;
  

    });
  }));

  it('should create the app', async(() => {
    const fixture = TestBed.createComponent(LoginComponent);
    const app = fixture.debugElement.componentInstance;
    
    expect(app).toBeTruthy();
  }));


  it('Should set submitted to true', async(() => {
    comp.onSubmit();
    expect(comp.submitted).toBeTruthy();
  }))


  it('form should be invalid with two empty values', async(() => {

    comp.loginForm.controls['username'].setValue('');
    comp.loginForm.controls['password'].setValue('');
    expect(comp.loginForm.valid).toBeFalsy();


  }))

  it('form should be invalid with one empty values of password', async(() => {
    comp.loginForm.controls['username'].setValue('passy');
    comp.loginForm.controls['password'].setValue('');
    expect(comp.loginForm.valid).toBeFalsy();


  }))

  it('form should be invalid with one empty username', async(() => {
    comp.loginForm.controls['username'].setValue('');
    comp.loginForm.controls['password'].setValue('password');
    expect(comp.loginForm.valid).toBeFalsy();


  }))
  it('form should be valid', async(() => {
    comp.loginForm.controls['username'].setValue('jenny');
    comp.loginForm.controls['password'].setValue('passy');
    expect(comp.loginForm.valid).toBeTruthy();
  }))



});
