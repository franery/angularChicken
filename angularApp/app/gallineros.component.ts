import { Component } from '@angular/core';

@Component({
  selector: 'listaGallineros',
  template: `
            <h1>Gallineros</h1>
            <br>
            <gallinero-list></gallinero-list>
            <br>
            <button (click)="goBack()">back</button>
            `
})
export class GallinerosComponent { }