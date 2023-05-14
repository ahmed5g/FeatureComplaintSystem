import { ComponentFixture, TestBed } from '@angular/core/testing';

import { SearchReclamationComponent } from './search-reclamation.component';

describe('SearchReclamationComponent', () => {
  let component: SearchReclamationComponent;
  let fixture: ComponentFixture<SearchReclamationComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ SearchReclamationComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(SearchReclamationComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
