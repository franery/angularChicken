import { NgModule } from '@angular/core';
import { RouterModule } from '@angular/router';

import { HomeComponent } from './home.component';
import { DepositosComponent }  from './depositos/depositos.component';
import { DepositosFormComponent } from './depositos/depositosForm.component';
import { UsuariosComponent }  from './usuarios/usuarios.component';
import { GallinerosComponent }  from './gallineros/gallineros.component';
import { PerfilesComponent }  from './perfiles/perfiles.component';
import { ParametrosComponent }  from './parametros/parametros.component';
import { VentasComponent }  from './ventas/ventas.component';
import { ProveedoresComponent }  from './proveedores/proveedores.component';

@NgModule({
  imports: [
    RouterModule.forRoot([
      { path: 'depositos', component: DepositosComponent },
      { path: 'depositosForm', component: DepositosFormComponent },
      { path: 'parametros', component: ParametrosComponent },
      { path: 'gallineros', component: GallinerosComponent },
      { path: 'home', component: HomeComponent },
      { path: '', component: HomeComponent },
      { path: '**', component: HomeComponent }
    ])
  ],
  exports: [
    RouterModule
  ]
})
export class AppRoutingModule {}