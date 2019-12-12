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
  joinable : Boolean = false;

  constructor(private route: ActivatedRoute, private eventService: EventsService, private authenticationService : AuthenticationService) { }

  ngOnInit() {
    console.log(this.route.params);
    this.route.params.subscribe((params: Params) => {
      this.eventService.getEvent(params.id).subscribe(data => {
        this.event = data;
      });
  }
  )

  this.ngGetUserInfo();
  console.log(this.event.users);
  console.log(this.user);

  if(this.event.users.length > 0)
  if(this.event.users.some(e => e.id == this.user.id)){
    this.joinable = false;
  }else{
    this.joinable = true;
  }
  };


  joinOrLeave(){
    if (this.joinable){
      this.event.users.push(this.user);
      this.eventService.updateEvent(this.event);
      this.joinable = false;

    }else
    {
this.event.users = this.event.users.filter(e => e.id != this.user.id);
this.joinable = true;
    }
  }



  ngGetUserInfo(){
   this.authenticationService.getUserFromSession().subscribe(a => {
      this.user = a;
    });
   
  }


}
