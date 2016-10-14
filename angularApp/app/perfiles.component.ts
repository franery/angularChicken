import { Component } from '@angular/core';
import { Location } from '@angular/common';

@Component({
  selector: 'listaPerfiles',
  template: `
            <h1>Perfiles</h1>
            <br>
            <perfil-list></perfil-list>
            <br>
            <button (click)="goBack()">back</button>
            `
})
export class PerfilesComponent {

    constructor(private location: Location){}

    goBack(): void {
        this.location.back();
    }
}