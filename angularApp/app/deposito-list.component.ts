import { Component, OnInit } from '@angular/core';
import { Deposito } from './deposito';
import { DepositoService } from './deposito.service';

@Component({
  moduleId: module.id,
  selector: 'deposito-list',
  template: `
      <br>
      <datatable [dataset]=depositos>
          <column [value]="'id'" [header]="'Id'"></column>
          <column [value]="'nombre'" [header]="'Nombre'"></column>
          <column [value]="'stockMaximo'" [header]="'Stock Maximo'"></column>
      </datatable>

          <div class="error" *ngIf="errorMessage">{{errorMessage}}</div>`,
  providers: [ DepositoService ]
})
export class DepositoListComponent implements OnInit {
  errorMessage: string;
  depositos: Deposito[];

  constructor (private depositoService: DepositoService) {}

  ngOnInit() { this.getDepositos(); }

  getDepositos() {
    this.depositoService.getDepositos()
                     .subscribe(
                       depositos => this.depositos = depositos,
                       error =>  this.errorMessage = <any>error);
  }

}