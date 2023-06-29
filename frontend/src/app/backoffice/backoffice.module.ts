import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { BackofficeRoutingModule } from './backoffice-routing.module';
import { HomeComponent } from './hotel/pages/home/home.component';
import { BackofficeComponent } from './backoffice.component';
import { NgbModule } from '@ng-bootstrap/ng-bootstrap';
import { AddHotelComponent } from './hotel/components/add-hotel/add-hotel.component';

@NgModule({
  declarations: [
    BackofficeComponent,
    HomeComponent,
    AddHotelComponent
  ],
  imports: [
    CommonModule,
    BackofficeRoutingModule,
    NgbModule
  ]
})
export class BackofficeModule { }
