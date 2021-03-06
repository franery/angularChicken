import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { RouterModule }   from '@angular/router';
import { HttpModule, JsonpModule }  from '@angular/http';
import { FormsModule } from '@angular/forms';

import { GallineroRoutingModule } from './gallinero-routing.module';
import { DatatableModule } from '../datatable/datatable.module';

import { GallinerosComponent }  from './gallineros.component';
import { GallineroListComponent } from './gallinero-list.component';

@NgModule({
    imports: [
        CommonModule,
        HttpModule,
        JsonpModule,
        FormsModule,
        GallineroRoutingModule,
        DatatableModule
    ],
    declarations: [
        GallinerosComponent,
        GallineroListComponent
    ]
})
export class GallineroModule { }