import { Component, OnInit } from '@angular/core';
import { CompanyService } from '../_services/company.service';
import { Company } from '../_models/company';
import { Params, ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-companyprofile',
  templateUrl: './companyprofile.component.html',
  styleUrls: ['./companyprofile.component.scss']
})
export class CompanyprofileComponent implements OnInit {

  company : Company;
  constructor(private route: ActivatedRoute, private companyService : CompanyService) { }

  ngOnInit() {
    this.route.params.subscribe((params: Params) => {
      this.companyService.getCompany(params.id).subscribe(data => {
      
        this.company = data;
        console.log(this.company);
      });
  }
  );
  

  }

  getInfo(){
    console.log(this.company);
  }

}
