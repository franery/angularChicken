import { Component } from '@angular/core';
import { Location } from '@angular/common';

@Component({
  selector: 'listaProveedores',
  template: `
            <h1>Proveedores</h1>
            <br>
            <proveedores-list></proveedores-list>
            <br>
            <button (click)="goBack()">back</button>
            `
})
export class ProveedoresComponent {

    constructor(private location: Location){}

    goBack(): void {
        this.location.back();
    }
}