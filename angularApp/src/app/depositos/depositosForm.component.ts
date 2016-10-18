import { Component, OnInit } from '@angular/core';
import { Location } from '@angular/common';
import { Deposito } from './deposito';
import { ListService } from '../list.service';

@Component({
  
  selector: 'deposito-form',
  template: `
            <div [hidden]="submitted">
                <form (ngSubmit)="onSubmit()">
                    <label for="nombre">Nombre</label>
                    <input [(ngModel)]="deposito.nombre" id="nombre" name="nombre">
                    <label for="deposito.stockMaximo">Stock Maximo</label>
                    <input [(ngModel)]="deposito.stockMaximo" id="stockMaximo" name="stockMaximo">
                </form>
                <button (click)="submit()">Crear</button>
            </div>
            `,
  providers: [ ListService ]
})

export class DepositosFormComponent implements OnInit{

    private depositosNuevoUrl = 'http://localhost:8080/ChickenEscuelita/depositosNuevoJson';
    deposito: Deposito;
    submitted = false;
    errores: Object;
    constructor (private listService: ListService, private location: Location) {}

    ngOnInit() {
        this.deposito = new Deposito(null, null, null, null, null);
    }

    onSubmit() {
        this.submitted = true;
    }

    submit() {
        this.listService.add(this.depositosNuevoUrl, this.deposito).subscribe(
            errores => this.errores = errores,
            () => this.location.back(),
            () => console.log("error: " + this.errores));
    }
}