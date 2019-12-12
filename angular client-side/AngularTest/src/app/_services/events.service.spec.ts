import { TestBed, getTestBed } from '@angular/core/testing';

import { EventsService } from './events.service';
import { Event, ActivatedRoute } from '@angular/router';
import { Eventment } from '../_models/eventment';
import { HttpTestingController, HttpClientTestingModule } from '@angular/common/http/testing';
import { RestService } from './rest.service';
import { RouterTestingModule } from '@angular/router/testing';
import { MaterialModule } from '../material.module';
import { of } from 'rxjs';

describe('EventsService', () => {
  let injector: TestBed;
  let service: EventsService;
  let httpMock: HttpTestingController;

  const dummyEventListResponse: Eventment[] = [{
    id: 1,
    name: "Test_1",
    description: "Test is testing",
    image: null,
    numberOfPeople: 8,
    company: {
      id: 1,
      name: "company",
      description: "company",
      Image: null,
      events: null
    },
    users: null

  },
  {
    id: 2,
    name: "Test_2",
    description: "Test is testing",
    image: null,
    numberOfPeople: 8,
    company: {
      id: 1,
      name: "company",
      description: "company",
      Image: null,
      events: null
    },
    users: null
  }]

  const dummyEventResponse: Eventment = {
    id: 1,
    name: "Test_1",
    description: "Test is testing",
    image: null,
    numberOfPeople: 8,
    company: {
      id: 1,
      name: "company",
      description: "company",
      Image: null,
      events: null
    },
    users: null
  };



  beforeEach(() => {
    TestBed.configureTestingModule({
      imports: [HttpClientTestingModule, MaterialModule, RouterTestingModule.withRoutes([])],
      providers: [EventsService, RestService, ],
    });
    injector = getTestBed();
    service = injector.get(EventsService);
    httpMock = injector.get(HttpTestingController);
  });

  afterEach(() => {
    httpMock.verify();
  });



  it('getAllEvents() should return data', () => {
    service.getAll().subscribe((res) => {
      console.log(res);
      expect(res).toEqual(dummyEventListResponse);
    });

    const req = httpMock.expectOne('http://localhost:2020/events');
    expect(req.request.method).toBe('GET');
    req.flush(dummyEventListResponse);

  });

  it('getEvent() should return data', () => {
    service.getEvent(1).subscribe((res) => {
      console.log(res);
      expect(res).toEqual(dummyEventResponse);
    });
    const req = httpMock.expectOne('http://localhost:2020/events/1');
    expect(req.request.method).toBe('GET');
    req.flush(dummyEventResponse);
  });


});
