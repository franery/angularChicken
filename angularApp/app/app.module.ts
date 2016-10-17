import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { RouterModule }   from '@angular/router';
import { HttpModule, JsonpModule }  from '@angular/http';
import { FormsModule } from '@angular/forms';

import { DatatableComponent } from './datatable.component';
import { ColumnComponent } from './column.component';
import { AppComponent }  from './app.component';
import { AppRoutingModule } from './app.routing.module';
import { HomeComponent }  from './home.component';
import { DepositosComponent }  from './depositos/depositos.component';
import { DepositosFormComponent }  from './depositos/depositosForm.component';
import { UsuariosComponent }  from './usuarios/usuarios.component';
import { GallinerosComponent }  from './gallineros/gallineros.component';
import { PerfilesComponent }  from './perfiles/perfiles.component';
import { ParametrosComponent } from './parametros/parametros.component';
import { VentasComponent } from './ventas/ventas.component';
import { ProveedoresComponent } from './proveedores/proveedores.component';

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
    DepositoListComponent,
    DepositosFormComponent,
    UsuariosComponent,
    UsuarioListComponent,
    GallinerosComponent,
    GallineroListComponent,
    ParametrosComponent,
    ParametrosListComponent,
    VentasComponent,
    VentasListComponent,
    ProveedoresComponent,
    ProveedoresListComponent,
    PerfilesComponent,
    PerfilListComponent
  ],
  bootstrap: [
    AppComponent
  ]
})
export class AppModule { }
