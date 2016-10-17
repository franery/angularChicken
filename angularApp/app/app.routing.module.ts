import { NgModule } from '@angular/core';
import { RouterModule } from '@angular/router';

import { HomeComponent } from './home.component';
import { DepositosComponent }  from './depositos/depositos.component';
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
      { path: 'usuarios', component: UsuariosComponent },
      { path: 'gallineros', component: GallinerosComponent },
      { path: 'perfiles', component: PerfilesComponent },
      { path: 'parametros', component: ParametrosComponent },
      { path: 'ventas', component: VentasComponent },
      { path: 'proveedores', component: ProveedoresComponent },
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