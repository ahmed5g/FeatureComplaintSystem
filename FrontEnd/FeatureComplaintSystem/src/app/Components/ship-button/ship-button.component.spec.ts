import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ShipButtonComponent } from './ship-button.component';

describe('ShipButtonComponent', () => {
  let component: ShipButtonComponent;
  let fixture: ComponentFixture<ShipButtonComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ShipButtonComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(ShipButtonComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
