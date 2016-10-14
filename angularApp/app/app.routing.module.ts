import { NgModule } from '@angular/core';
import { RouterModule } from '@angular/router';

import { HomeComponent } from './home.component';
import { DepositosComponent }  from './depositos.component';
import { UsuariosComponent }  from './usuarios.component';
import { GallinerosComponent }  from './gallineros.component';
import { PerfilesComponent }  from './perfiles.component';
import { ParametrosComponent }  from './parametros.component';
import { VentasComponent }  from './ventas.component';
import { ProveedoresComponent }  from './proveedores.component';

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