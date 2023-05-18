import { Component, NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { HomePageComponent } from './Components/home-page/home-page.component';
import { ShippingPageComponent } from './Components/shipping-page/shipping-page.component';
import { AddReclamationComponent } from './Components/add-reclamation/add-reclamation.component';
import { ListeReclmationsComponent } from './Components/liste-reclmations/liste-reclmations.component';
import { UpdateReclmationComponent } from './Components/update-reclmation/update-reclmation.component';

const routes: Routes = [
  {path : '', component : HomePageComponent},
  {path : 'set/:id', component : ShippingPageComponent},
  {path : 'addReclmation', component : AddReclamationComponent},
  {path : 'ListeReclamations', component: ListeReclmationsComponent},
  { path: 'update/:id', component: UpdateReclmationComponent }
  
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
