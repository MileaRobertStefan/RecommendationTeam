import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { RecommendationComponentComponent } from './recommendation-component.component';

describe('RecommendationComponentComponent', () => {
  let component: RecommendationComponentComponent;
  let fixture: ComponentFixture<RecommendationComponentComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ RecommendationComponentComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(RecommendationComponentComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
