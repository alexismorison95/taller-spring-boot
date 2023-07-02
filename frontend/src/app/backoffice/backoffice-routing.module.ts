import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { HomeComponent as HotelHomeComponent } from './hotel/pages/home/home.component';
import { BackofficeComponent }  from './backoffice.component';
import { DestinationHomeComponent } from './destination/pages/destination-home/destination-home.component';

const routes: Routes = [
  { 
    path: '', 
    component: BackofficeComponent, 
    children: [
      { path: 'destination', component: DestinationHomeComponent},
      { path: 'destination/hotelByDestination/:id', component: HotelHomeComponent}
    ] 
  }
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class BackofficeRoutingModule { }
