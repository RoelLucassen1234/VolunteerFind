import { Component } from '@angular/core';
import { first } from 'rxjs/operators';

import { User } from '../_models/user';
import { UserService } from '../_services/user.service';
import { AuthenticationService } from '../_services/authentication.service'
import { EventsService } from '../_services/events.service';



@Component({
    templateUrl: 'home.component.html',
    styleUrls: ['./home.component.scss']
})
export class HomeComponent {
    users: Event[] = [];

    constructor(private eventService: EventsService) { }

    ngOnInit() {
        this.eventService.getAll().pipe(first()).subscribe(users => {
            this.users = users
            console.log(this.users);
        })

    }
}


