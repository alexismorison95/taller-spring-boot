import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { BackofficeRoutingModule } from './backoffice-routing.module';
import { HomeComponent as HotelHomeComponent } from './hotel/pages/home/home.component';
import { DestinationHomeComponent } from './destination/pages/destination-home/destination-home.component';
import { BackofficeComponent } from './backoffice.component';
import { AddOrUpdateHotelModalComponent } from './hotel/components/add-or-update-hotel-modal/add-or-update-hotel-modal.component';
import { SharedModule } from '../shared/modules/shared.module';
import { AddOrUpdateDestinationModalComponent } from './destination/components/add-or-update-destination-modal/add-or-update-destination-modal.component';

@NgModule({
  declarations: [
    BackofficeComponent,
    HotelHomeComponent,
    DestinationHomeComponent,
    AddOrUpdateHotelModalComponent,
    AddOrUpdateDestinationModalComponent
  ],
  imports: [
    CommonModule,
    BackofficeRoutingModule,
    SharedModule
  ]
})
export class BackofficeModule { }
