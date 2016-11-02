import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { GallinerosComponent }  from './gallineros.component';

///routes es opcional porque no estamos usando loadChildren
export const routes: Routes = [
      { path: '', component: GallinerosComponent },
    ]

@NgModule({
  imports: [ RouterModule.forChild(routes) ],
  exports: [ RouterModule ]
})
export class GallineroRoutingModule {}