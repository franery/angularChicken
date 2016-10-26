import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { FormsModule } from '@angular/forms';

import { DatatableComponent } from './datatable.component';
import { ColumnComponent } from './column.component';

@NgModule({
    imports: [
        BrowserModule,
        FormsModule        
    ],
    declarations: [
        DatatableComponent,
        ColumnComponent
    ],
    exports: [
        DatatableComponent,
        ColumnComponent
    ]
    
})
export class DatatableModule { }