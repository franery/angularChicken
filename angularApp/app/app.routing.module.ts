import { NgModule }     from '@angular/core';
import { RouterModule } from '@angular/router';

import { DepositosComponent }  from './depositos.component';
import { UsuariosComponent }  from './usuarios.component';
import { GallinerosComponent }  from './gallineros.component';

@NgModule({
  imports: [
    RouterModule.forRoot([
      {path: 'depositos', component: DepositosComponent},
      { path: 'usuarios', component: UsuariosComponent },
      { path: 'gallineros', component: GallinerosComponent }
    ])
  ],
  exports: [
    RouterModule
  ]
})
export class AppRoutingModule {}