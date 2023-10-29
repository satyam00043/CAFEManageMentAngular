import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { BestSellerComponent } from './best-seller/best-seller.component';
import { HomeComponent } from './home/home.component';
import { FullComponent } from './layout/full/full.component';
import { HeaderComponent } from './layout/full/header/header.component';
import { SidebarComponent } from './layout/full/sidebar/sidebar.component';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { Material } from './shared/material';
import { Shared } from './shared/shared';
import { DashboardComponent } from './dashboard/dashboard.component';

@NgModule({
  declarations: [
    AppComponent,
    BestSellerComponent,
    HomeComponent,
    FullComponent,
    HeaderComponent,
    SidebarComponent,
    DashboardComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    ReactiveFormsModule,Material,Shared
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
