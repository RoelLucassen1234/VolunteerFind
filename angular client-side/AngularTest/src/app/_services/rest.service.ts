import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class RestService {

  private restUrl: string;

  constructor(private http : HttpClient) { 
    this.restUrl = 'http://localhost:2020';
  }

  getRestUrl(){
    return this.restUrl;
  }
}
