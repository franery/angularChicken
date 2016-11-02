import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { RouterModule }   from '@angular/router';
import { HttpModule, JsonpModule }  from '@angular/http';
import { FormsModule } from '@angular/forms';

import { DepositoRoutingModule } from './deposito-routing.module';
import { DatatableModule } from '../datatable/datatable.module';

import { DepositosComponent }  from './depositos.component';
import { DepositosFormComponent }  from './depositosForm.component';
import { DepositoListComponent } from './deposito-list.component';

@NgModule({
    imports: [
        CommonModule,
        HttpModule,
        JsonpModule,
        FormsModule,
        DatatableModule,
        DepositoRoutingModule
    ],
    declarations: [
        DepositosComponent,
        DepositoListComponent,
        DepositosFormComponent
    ]
})
export class DepositoModule { }