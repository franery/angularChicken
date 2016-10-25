import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { RouterModule }   from '@angular/router';
import { HttpModule, JsonpModule }  from '@angular/http';
import { FormsModule } from '@angular/forms';
import { AppRoutingModule } from '../app.routing.module';

import { DatatableModule } from '../datatable/datatable.module';

import { DepositosComponent }  from './depositos.component';
import { DepositosFormComponent }  from './depositosForm.component';
import { DepositoListComponent } from './deposito-list.component';

import { ListService } from '../list.service';

@NgModule({
    imports: [
        BrowserModule,
        HttpModule,
        JsonpModule,
        FormsModule,
        AppRoutingModule,
        DatatableModule
    ],
    declarations: [
        DepositosComponent,
        DepositoListComponent,
        DepositosFormComponent
    ]
    
})
export class DepositoModule { }