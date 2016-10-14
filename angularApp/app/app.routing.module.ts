import { NgModule } from '@angular/core';
import { RouterModule } from '@angular/router';

import { HomeComponent } from './home.component';
import { DepositosComponent }  from './depositos.component';
import { UsuariosComponent }  from './usuarios.component';
import { GallinerosComponent }  from './gallineros.component';
import { PerfilesComponent }  from './perfiles.component';

@NgModule({
  imports: [
    RouterModule.forRoot([
      { path: 'depositos', component: DepositosComponent },
      { path: 'usuarios', component: UsuariosComponent },
      { path: 'gallineros', component: GallinerosComponent },
      { path: 'perfiles', component: PerfilesComponent },
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