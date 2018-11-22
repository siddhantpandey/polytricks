import { TestBed, inject } from '@angular/core/testing';

import { Token.SotrageService } from './token.sotrage.service';

describe('Token.SotrageService', () => {
  beforeEach(() => {
    TestBed.configureTestingModule({
      providers: [Token.SotrageService]
    });
  });

  it('should be created', inject([Token.SotrageService], (service: Token.SotrageService) => {
    expect(service).toBeTruthy();
  }));
});
