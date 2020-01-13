import { Component, OnInit } from '@angular/core';
import { UserService, AuthenticationService } from '../_services';
import { ActivatedRoute, Params } from '@angular/router';
import { User } from '../_models';
import { DatePipe, formatDate } from '@angular/common';

@Component({
  selector: 'app-userprofile',
  templateUrl: './userprofile.component.html',
  styleUrls: ['./userprofile.component.scss']
})
export class UserprofileComponent implements OnInit {
   user : User;
   pipe = new DatePipe('en-US'); // Use your own locale
 format = 'dd/MM/yyyy';
 myDate : Date;
 locale = 'en-US';

  constructor(private route: ActivatedRoute, private userService: UserService, private authenticationService : AuthenticationService) { 

  }

  ngOnInit() {
  
    this.route.params.subscribe((params: Params) => {
      this.userService.getCertainUser(params.id).subscribe(data => {
      
        this.user = data;
        this.getCorrectDate();
      });
  }
  );
  

  }

getCorrectDate(){
 console.log('date');
  this.myDate = new Date(this.user.date);
  console.log(this.myDate);
  this.user.date = this.myDate.toLocaleDateString('nl-NL');
  console.log(this.user.date);
}

}
