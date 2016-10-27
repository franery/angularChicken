import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
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
        BrowserModule,
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
    ],
    exports: [
        DepositosComponent,
        DepositosFormComponent,
        DepositoRoutingModule
        ]
})
export class DepositoModule { }