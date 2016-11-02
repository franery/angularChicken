import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';

import { DatatableComponent } from './datatable.component';
import { ColumnComponent } from './column.component';

@NgModule({
    imports: [
        CommonModule,
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