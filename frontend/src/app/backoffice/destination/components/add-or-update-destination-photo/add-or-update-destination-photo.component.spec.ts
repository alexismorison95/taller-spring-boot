import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AddOrUpdateDestinationPhotoComponent } from './add-or-update-destination-photo.component';

describe('AddOrUpdateDestinationPhotoComponent', () => {
  let component: AddOrUpdateDestinationPhotoComponent;
  let fixture: ComponentFixture<AddOrUpdateDestinationPhotoComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ AddOrUpdateDestinationPhotoComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(AddOrUpdateDestinationPhotoComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
