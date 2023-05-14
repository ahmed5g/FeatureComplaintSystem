import { TestBed } from '@angular/core/testing';

import { ComplaintService } from './reclamations.service';

describe('ReclamationsService', () => {
  let service: ComplaintService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(ComplaintService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
