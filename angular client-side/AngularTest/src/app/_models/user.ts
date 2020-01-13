import { Event } from '@angular/router';

export class User {
    id: number;
    email: string;
    // password: string;
    firstName: string;
    lastName: string;
    token?: string;
    events : Event[];
  date: string;
}