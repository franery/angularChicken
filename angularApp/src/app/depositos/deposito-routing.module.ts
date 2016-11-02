import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { DepositosComponent }  from './depositos.component';
import { DepositosFormComponent } from './depositosForm.component';

//routes es opcional porque no estamos usando loadChildren
export const routes: Routes = [
      { path: '', component: DepositosComponent },
      { path: 'depositosForm',  component: DepositosFormComponent }
    ]

@NgModule({
  imports: [ RouterModule.forChild(routes) ],
  exports: [ RouterModule ]
})
export class DepositoRoutingModule {}