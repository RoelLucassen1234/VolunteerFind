import {
    MatButtonModule, MatCardModule, MatDividerModule, MatFormFieldModule,
    MatInputModule,
    MatTabsModule,
    MatRippleModule,

    MatMenuModule,
    MatIconModule,
    MatToolbarModule,
    MatGridListModule,
    MatTreeModule,
  } from '@angular/material';
  import { NgModule } from '@angular/core';
  
  @NgModule({
    exports: [
        
      MatButtonModule,
      MatCardModule,
      MatDividerModule,
      MatFormFieldModule,
      MatInputModule,
      MatIconModule,
      MatTabsModule,
      MatRippleModule,
      MatGridListModule
    ]
  })
  
  export class MaterialModule { }