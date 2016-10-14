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
import { PerfilesComponent }  from './perfiles.component';
import { ParametrosComponent } from './parametros.component';
import { VentasComponent } from './ventas.component';
import { ProveedoresComponent } from './proveedores.component';

import { VentasListComponent } from './ventas/ventas-list.component';
import { ProveedoresListComponent } from './proveedores/proveedores-list.component';
import { ParametrosListComponent } from './parametros/parametros-list.component';
import { DepositoListComponent } from './depositos/deposito-list.component';
import { GallineroListComponent } from './gallineros/gallinero-list.component';
import { UsuarioListComponent } from './usuarios/usuario-list.component';
import { PerfilListComponent } from './perfiles/perfil-list.component';

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
    ParametrosComponent,
    ParametrosListComponent,
    VentasComponent,
    VentasListComponent,
    ProveedoresComponent,
    ProveedoresListComponent,
    PerfilesComponent,
    DepositoListComponent,
    GallineroListComponent,
    UsuarioListComponent,
    PerfilListComponent
  ],
  bootstrap: [
    AppComponent
  ]
})
export class AppModule { }
