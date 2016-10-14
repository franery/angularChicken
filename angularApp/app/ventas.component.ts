import { Component } from '@angular/core';
import { Location } from '@angular/common';

@Component({
  selector: 'listaVentas',
  template: `
            <h1>Ventas</h1>
            <br>
            <ventas-list></ventas-list>
            <br>
            <button (click)="goBack()">back</button>
            `
})
export class VentasComponent {

    constructor(private location: Location){}

    goBack(): void {
        this.location.back();
    }
}