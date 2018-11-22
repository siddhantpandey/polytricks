import { TestBed, inject } from '@angular/core/testing';

import { CustommaterialService } from './material.module';

describe('CustommaterialService', () => {
  beforeEach(() => {
    TestBed.configureTestingModule({
      providers: [CustommaterialService]
    });
  });

  it('should be created', inject([CustommaterialService], (service: CustommaterialService) => {
    expect(service).toBeTruthy();
  }));
});
