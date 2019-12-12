import { TestBed, getTestBed } from "@angular/core/testing";

import { EventsService } from "./events.service";

import { HttpTestingController, HttpClientTestingModule } from "@angular/common/http/testing";

import { Eventment } from "../_models/eventment";

import { RouterTestingModule } from "@angular/router/testing";

import { RestService } from "./rest.service";

describe('restService', () => {
    let injector: TestBed;
    let service: RestService;
    let httpMock: HttpTestingController;
  

    beforeEach(() => {
      TestBed.configureTestingModule({
        imports: [HttpClientTestingModule],
        providers: [RestService],
      });
      injector = getTestBed();
      service = injector.get(RestService);
      httpMock = injector.get(HttpTestingController);
    });
  
    afterEach(() => {
      httpMock.verify();
    });
  
    it('should be created', () => {
      const service: RestService = TestBed.get(RestService);
      expect(service).toBeTruthy();
    });

    it('right link with  getRestUrl()', () => {
        let url = service.getRestUrl();
          expect('http://localhost:2020').toEqual(url);
      });

});