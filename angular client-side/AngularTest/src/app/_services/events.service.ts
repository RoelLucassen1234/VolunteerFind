import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { RestService } from './rest.service'
import { Eventment } from '../_models/eventment';
import { Event } from '@angular/router';
import { User } from '../_models';



const httpOptions = {
  headers: new HttpHeaders({'Content-Type': 'application/json'})
};

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

   updateEvent(event : Eventment){
 
     return this.http.put<Eventment>(this.rest.getRestUrl() + '/events/', event, httpOptions );
   }
}
