import { Component } from '@angular/core';
import { Location } from '@angular/common';

@Component({
  selector: 'listaDepositos',
  template: `
            <h1>Depositos</h1>
            <br>
            <deposito-list></deposito-list>
            <br>
            <button (click)="goBack()">back</button>
            `,
    providers: [Location]
})
export class DepositosComponent {

    constructor(private location: Location){}

    goBack(): void {
        this.location.back();
    }
}