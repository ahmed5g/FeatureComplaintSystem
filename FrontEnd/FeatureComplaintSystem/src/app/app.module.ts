import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { ShippingPageComponent } from './Components/shipping-page/shipping-page.component';
import { AddReclamationComponent } from './Components/add-reclamation/add-reclamation.component';
import { FormsModule , ReactiveFormsModule} from '@angular/forms';
import { SideBarComponent } from './Components/side-bar/side-bar.component';
import { NavBarComponent } from './Components/nav-bar/nav-bar.component';
import { ListeReclmationsComponent } from './Components/liste-reclmations/liste-reclmations.component';
import { HttpClientModule } from '@angular/common/http';
import { ShipButtonComponent } from './Components/ship-button/ship-button.component';
import { UpdateReclmationComponent } from './Components/update-reclmation/update-reclmation.component';
import { SearchReclamationComponent } from './Components/search-reclamation/search-reclamation.component';
import { SearchPipe } from './search.pipe';

@NgModule({
  declarations: [
    AppComponent,
    ShippingPageComponent,
    AddReclamationComponent,
    SideBarComponent,
    NavBarComponent,
    ListeReclmationsComponent,
    ShipButtonComponent,
    UpdateReclmationComponent,
    SearchReclamationComponent,
    SearchPipe
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    ReactiveFormsModule,
    HttpClientModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
