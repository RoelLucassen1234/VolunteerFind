import { Routes, RouterModule } from '@angular/router';

import { MainmenutComponent } from './mainmenu/mainmenut.component';
import { LoginComponent } from './login/login.component';
import { AuthGuard } from '../app/authentication/auth-guard';

const appRoutes: Routes = [
    {
        path: '',
        component: MainmenutComponent,
        canActivate: [AuthGuard]
    },
    {
        path: 'login',
        component: LoginComponent
    },

    // otherwise redirect to home
    { path: '', pathMatch: 'full', redirectTo: 'login' },
];

export const routing = RouterModule.forRoot(appRoutes);