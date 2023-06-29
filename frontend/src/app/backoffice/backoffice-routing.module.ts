import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { HomeComponent as HotelHomeComponent } from './hotel/pages/home/home.component';
import { BackofficeComponent }  from './backoffice.component';

const routes: Routes = [
  { 
    path: '', 
    component: BackofficeComponent, 
    children: [
      { path: 'hotel', component: HotelHomeComponent}
    ] 
  }
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class BackofficeRoutingModule { }
