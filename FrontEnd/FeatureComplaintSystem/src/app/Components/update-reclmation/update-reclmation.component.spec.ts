import { ComponentFixture, TestBed } from '@angular/core/testing';

import { UpdateReclmationComponent } from './update-reclmation.component';

describe('UpdateReclmationComponent', () => {
  let component: UpdateReclmationComponent;
  let fixture: ComponentFixture<UpdateReclmationComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ UpdateReclmationComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(UpdateReclmationComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
