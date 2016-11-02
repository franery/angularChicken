import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';

import { HomeComponent } from './home.component';
import { ParametrosComponent }  from './parametros/parametros.component';

export const routes: Routes = [
      { path: '', component: HomeComponent },
      { path: 'parametros', component: ParametrosComponent },
      { path: 'depositos', loadChildren: './depositos/deposito.module#DepositoModule' },
      { path: 'gallineros', loadChildren: './gallineros/gallinero.module#GallineroModule' },
      { path: '**', component: HomeComponent }
    ]

@NgModule({
  imports: [ RouterModule.forRoot(routes) ],
  exports: [ RouterModule ]
})
export class AppRoutingModule {}