import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { HttpModule, JsonpModule }  from '@angular/http';
import { FormsModule } from '@angular/forms';

import { DepositoModule } from './depositos/deposito.module';
import { GallineroModule }  from './gallineros/gallinero.module';
import { ParametroModule } from './parametros/parametro.module';
import { AppRoutingModule } from './app.routing.module';

import { AppComponent }  from './app.component';
import { HomeComponent }  from './home.component';

@NgModule({
    imports: [
        BrowserModule,
        HttpModule,
        JsonpModule,
        FormsModule,
        DepositoModule,
        GallineroModule,
        ParametroModule,
        AppRoutingModule
    ],
    declarations: [
        AppComponent,
        HomeComponent
    ],
    bootstrap: [ AppComponent ]
})
export class AppModule { }
