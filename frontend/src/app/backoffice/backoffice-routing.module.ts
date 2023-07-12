import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { HomeComponent as HotelHomeComponent } from './hotel/pages/home/home.component';
import { BackofficeComponent }  from './backoffice.component';
import { DestinationHomeComponent } from './destination/pages/destination-home/destination-home.component';
import { UpdateDestinationComponent } from './destination/pages/update-destination/update-destination.component';

const routes: Routes = [
  { 
    path: '', 
    component: BackofficeComponent, 
    children: [
      { path: 'destination', component: DestinationHomeComponent },
      { path: 'destination/hotelByDestination/:id', component: HotelHomeComponent },
      { path: 'destination/updateDestination/:id', component: UpdateDestinationComponent }
    ] 
  }
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class BackofficeRoutingModule { }
