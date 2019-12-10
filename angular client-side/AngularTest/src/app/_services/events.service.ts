import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { RestService } from './rest.service'
@Injectable({
  providedIn: 'root'
})
export class EventsService {

  constructor(private http: HttpClient, private rest : RestService) { }

  getAll() {
   return this.http.get<Event[]>(this.rest.getRestUrl() + `/events`);
  }
}
