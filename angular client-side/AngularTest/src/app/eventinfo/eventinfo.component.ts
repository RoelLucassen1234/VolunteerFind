import { Component, OnInit } from '@angular/core';
import { Eventment } from '../_models/eventment';
import { ActivatedRoute, Params } from '@angular/router';
import { EventsService } from '../_services/events.service';
import { AuthenticationService } from '../_services';
import { User } from '../_models';

@Component({
  selector: 'app-eventinfo',
  templateUrl: './eventinfo.component.html',
  styleUrls: ['./eventinfo.component.css']
})
export class EventinfoComponent implements OnInit {

  event : Eventment;
  user : User;

  constructor(private route: ActivatedRoute, private eventService: EventsService, private authenticationService : AuthenticationService) { }

  ngOnInit() {
    console.log(this.route.params);
    this.route.params.subscribe((params: Params) => {
      this.eventService.getEvent(params.id).subscribe(data => {
        this.event = data;

      });
   
  }

    )
    
  };


  ngShowInfo(){
   this.authenticationService.getUserFromSession().subscribe(a => {
      this.user = a;
      console.log(this.user);
    });
   
  }


}
