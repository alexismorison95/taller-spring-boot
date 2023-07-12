import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { BackofficeRoutingModule } from './backoffice-routing.module';
import { HomeComponent as HotelHomeComponent } from './hotel/pages/home/home.component';
import { DestinationHomeComponent } from './destination/pages/destination-home/destination-home.component';
import { BackofficeComponent } from './backoffice.component';
import { AddOrUpdateHotelModalComponent } from './hotel/components/add-or-update-hotel-modal/add-or-update-hotel-modal.component';
import { SharedModule } from '../shared/modules/shared.module';
import { UpdateDestinationComponent } from './destination/pages/update-destination/update-destination.component';
import { AddOrUpdateDestinationPhotoComponent } from './destination/components/add-or-update-destination-photo/add-or-update-destination-photo.component';
import { AddDestinationComponent } from './destination/components/add-destination/add-destination.component';

@NgModule({
  declarations: [
    BackofficeComponent,
    HotelHomeComponent,
    DestinationHomeComponent,
    AddOrUpdateHotelModalComponent,
    UpdateDestinationComponent,
    AddOrUpdateDestinationPhotoComponent,
    AddDestinationComponent
  ],
  imports: [
    CommonModule,
    BackofficeRoutingModule,
    SharedModule
  ]
})
export class BackofficeModule { }
