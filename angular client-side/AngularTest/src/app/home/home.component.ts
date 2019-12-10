import { Component, ChangeDetectorRef } from '@angular/core';
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
    events: Event[] = [];

    constructor(private eventService: EventsService, private cdRef : ChangeDetectorRef) { }

    ngOnInit() {
        this.eventService.getAll().pipe(first()).subscribe(data => {
            this.events = data
            console.log(this.events);
            this.cdRef.detectChanges();
            
        })

    }

    
}


