import { NgModule } from '@angular/core';
import { RouterModule } from '@angular/router';

import { HomeComponent } from './home.component';

import { DepositosComponent }  from './depositos/depositos.component';
import { DepositosFormComponent } from './depositos/depositosForm.component';
import { GallinerosComponent }  from './gallineros/gallineros.component';
import { ParametrosComponent }  from './parametros/parametros.component';

@NgModule({
  imports: [
    RouterModule.forRoot([
      { path: 'depositos', component: DepositosComponent },
      { path: 'depositosForm', component: DepositosFormComponent },
      { path: 'gallineros', component: GallinerosComponent },
      { path: 'parametros', component: ParametrosComponent },
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