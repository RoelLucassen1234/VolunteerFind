import { Component, ChangeDetectorRef } from '@angular/core';
import { first } from 'rxjs/operators';

import { User } from '../_models/user';
import { UserService } from '../_services/user.service';
import { AuthenticationService } from '../_services/authentication.service'
import { EventsService } from '../_services/events.service';
import { Eventment } from '../_models/eventment';
import { DomSanitizer } from '@angular/platform-browser';



@Component({
    templateUrl: 'home.component.html',
    styleUrls: ['./home.component.scss']
})
export class HomeComponent {
    events: Eventment[] = [];
    genuineImage : String;
    _sanitizer : DomSanitizer;

    constructor(private eventService: EventsService, private cdRef : ChangeDetectorRef, _sanitizer : DomSanitizer) { 
        
        
    }

    ngOnInit() {
        this.eventService.getAll().pipe(first()).subscribe(data => {
            this.events = data
            console.log(this.events);
        
            this.cdRef.detectChanges();

            
        })

    }



    
}


