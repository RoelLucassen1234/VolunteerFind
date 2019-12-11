import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Params } from '@angular/router';
import { EventsService } from '../_services/events.service';
import { DomSanitizer } from '@angular/platform-browser';
import { Eventment } from '../_models/eventment';


@Component({
  selector: 'app-event-page',
  templateUrl: './event-page.component.html',
  styleUrls: ['./event-page.component.css']
})
export class EventPageComponent implements OnInit {

  event : Eventment;

  constructor(private route: ActivatedRoute, private eventService: EventsService) { }

  ngOnInit() {
    this.route.params.subscribe((params: Params) => {
      this.eventService.getEvent(params.id).subscribe(data => {
        this.event = data;
      });
    console.log(this.event);
  });

}
}
