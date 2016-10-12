import { NgModule }      from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { RouterModule }   from '@angular/router';

import { AppComponent }  from './app.component';
import { AppRoutingModule } from './app.routing.module';
import { DepositosComponent }  from './depositos.component';
import { HomeComponent }  from './home.component';
import { UsuariosComponent }  from './usuarios.component';
import { GallinerosComponent }  from './gallineros.component';

@NgModule({
  imports: [
    BrowserModule,
    AppRoutingModule
  ],
  declarations: [
    AppComponent,
    HomeComponent,
    DepositosComponent,
    UsuariosComponent,
    GallinerosComponent
  ],
  bootstrap: [
    AppComponent
  ]
})
export class AppModule { }
