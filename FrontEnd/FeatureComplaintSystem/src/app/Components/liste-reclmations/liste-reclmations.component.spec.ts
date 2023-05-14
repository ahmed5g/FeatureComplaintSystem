import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ListeReclmationsComponent } from './liste-reclmations.component';

describe('ListeReclmationsComponent', () => {
  let component: ListeReclmationsComponent;
  let fixture: ComponentFixture<ListeReclmationsComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ListeReclmationsComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(ListeReclmationsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
