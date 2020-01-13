import { Injectable } from '@angular/core';
import { Company } from '../_models/company';
import { HttpClient } from '@angular/common/http';
import { RestService } from './rest.service';

@Injectable({
  providedIn: 'root'
})
export class CompanyService {

  constructor(private http: HttpClient, private rest : RestService) { }

getCompany(companyId : number){
  console.log(this.rest.getRestUrl() + '/company/ ' + companyId); 
  return this.http.get<Company>(this.rest.getRestUrl() + '/company/' + companyId);
  
}

}
