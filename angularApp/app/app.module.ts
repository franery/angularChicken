import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { RouterModule }   from '@angular/router';
import { HttpModule, JsonpModule }  from '@angular/http';
import { FormsModule } from '@angular/forms';

import { DatatableComponent } from './datatable.component';
import { ColumnComponent } from './column.component';
import { AppComponent }  from './app.component';
import { AppRoutingModule } from './app.routing.module';
import { DepositosComponent }  from './depositos.component';
import { HomeComponent }  from './home.component';
import { UsuariosComponent }  from './usuarios.component';
import { GallinerosComponent }  from './gallineros.component';

import { DepositoListComponent } from './depositos/deposito-list.component';
import { GallineroListComponent } from './gallineros/gallinero-list.component';

@NgModule({
  imports: [
    BrowserModule,
    HttpModule,
    JsonpModule,
    FormsModule,
    AppRoutingModule
  ],
  declarations: [
    AppComponent,
    HomeComponent,
    DatatableComponent,
    ColumnComponent,
    DepositosComponent,
    UsuariosComponent,
    GallinerosComponent,
    DepositoListComponent,
    GallineroListComponent
  ],
  bootstrap: [
    AppComponent
  ]
})
export class AppModule { }