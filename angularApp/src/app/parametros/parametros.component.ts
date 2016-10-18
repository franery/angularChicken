import { Component } from '@angular/core';
import { Location } from '@angular/common';

@Component({
  selector: 'listaParametros',
  template: `
            <h1>Parametros</h1>
            <br>
            <parametros-list></parametros-list>
            <br>
            <button (click)="goBack()">back</button>
            `
})
export class ParametrosComponent {

    constructor(private location: Location){}

    goBack(): void {
        this.location.back();
    }
}