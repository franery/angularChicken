import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { RouterModule }   from '@angular/router';
import { HttpModule, JsonpModule }  from '@angular/http';
import { FormsModule } from '@angular/forms';
import { DepositoModule } from './depositos/deposito.module';

import { AppComponent }  from './app.component';
import { AppRoutingModule } from './app.routing.module';
import { HomeComponent }  from './home.component';
import { GallineroModule }  from './gallineros/gallinero.module';
import { PerfilesComponent }  from './perfiles/perfiles.component';
import { ParametroModule } from './parametros/parametro.module';
import { VentasComponent } from './ventas/ventas.component';
import { ProveedoresComponent } from './proveedores/proveedores.component';

import { VentasListComponent } from './ventas/ventas-list.component';
import { ProveedoresListComponent } from './proveedores/proveedores-list.component';

import { UsuarioListComponent } from './usuarios/usuario-list.component';
import { PerfilListComponent } from './perfiles/perfil-list.component';

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
