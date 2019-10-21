import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import {MainmenutComponent} from './mainmenu/mainmenut.component'

const routes: Routes = [{ path: 'menu', component: MainmenutComponent },
  {path: '', redirectTo: '/menu', pathMatch: 'full' }];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
