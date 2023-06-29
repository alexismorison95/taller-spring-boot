import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';

const routes: Routes = [
  { path: '', redirectTo: '/backoffice', pathMatch: 'full' }, 
  { path: 'backoffice', loadChildren: () => import('src/app/backoffice/backoffice.module').then(mod => mod.BackofficeModule) }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
