import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { ExchangeComponent } from './exchange/exchange.component';
import {HttpClientModule} from "@angular/common/http";
import { CurrencyMapComponent } from './currency-map/currency-map.component';

@NgModule({
  declarations: [
    AppComponent,
    ExchangeComponent,
    CurrencyMapComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
