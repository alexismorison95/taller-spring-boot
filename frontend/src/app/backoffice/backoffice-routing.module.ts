import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { HomeComponent as HotelHomeComponent } from './hotel/pages/home/home.component';
import { BackofficeComponent }  from './backoffice.component';
import { DestinationHomeComponent } from './destination/pages/destination-home/destination-home.component';
import { UpdateDestinationComponent } from './destination/pages/update-destination/update-destination.component';
import { LoginComponent } from './auth/pages/login/login.component';
import { ChildGuard } from '../shared/guards/child.guard';

const routes: Routes = [
  { 
    path: '', 
    component: BackofficeComponent, 
    children: [
      { path: 'login', component: LoginComponent },
      { path: 'destination', component: DestinationHomeComponent, canActivate: [ChildGuard] },
      { path: 'destination/hotelByDestination/:id', component: HotelHomeComponent, canActivate: [ChildGuard] },
      { path: 'destination/updateDestination/:id', component: UpdateDestinationComponent, canActivate: [ChildGuard] }
    ] 
  }
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class BackofficeRoutingModule { }
