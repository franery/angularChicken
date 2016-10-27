import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { RouterModule }   from '@angular/router';
import { HttpModule, JsonpModule }  from '@angular/http';
import { FormsModule } from '@angular/forms';

import { GallineroRoutingModule } from './gallinero-routing.module';
import { DatatableModule } from '../datatable/datatable.module';

import { GallinerosComponent }  from './gallineros.component';
import { GallineroListComponent } from './gallinero-list.component';

@NgModule({
    imports: [
        BrowserModule,
        HttpModule,
        JsonpModule,
        FormsModule,
        GallineroRoutingModule,
        DatatableModule
    ],
    declarations: [
        GallinerosComponent,
        GallineroListComponent
    ],
    exports: [ 
        GallinerosComponent
        ]
})
export class GallineroModule { }