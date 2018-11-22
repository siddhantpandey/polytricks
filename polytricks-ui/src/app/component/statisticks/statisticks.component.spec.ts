import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { StatisticksComponent } from './statisticks.component';

describe('StatisticksComponent', () => {
  let component: StatisticksComponent;
  let fixture: ComponentFixture<StatisticksComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ StatisticksComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(StatisticksComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
