import { Component } from '@angular/core';
import { Location } from '@angular/common';

@Component({
  selector: 'listaDepositos',
  template: `
            <h1>Depositos</h1>
            <br>
            <button (click)="goBack()">back</button>
            `
})
export class DepositosComponent {

    constructor(private location: Location){}

    goBack(): void {
        this.location.back();
    }
}