import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { MainmenutComponent } from './mainmenut.component';

describe('MainmenutComponent', () => {
  let component: MainmenutComponent;
  let fixture: ComponentFixture<MainmenutComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ MainmenutComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(MainmenutComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
