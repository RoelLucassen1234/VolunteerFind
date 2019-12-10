import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { RestService } from './rest.service'
import { Eventment } from '../_models/eventment';
@Injectable({
  providedIn: 'root'
})
export class EventsService {

  constructor(private http: HttpClient, private rest : RestService) { }

  getAll() {
   return this.http.get<Eventment[]>(this.rest.getRestUrl() + `/events`);
  }

  getEvent(eventId : number) {
    return this.http.get<Eventment>(this.rest.getRestUrl() + `/events/` + eventId );
   }
}
