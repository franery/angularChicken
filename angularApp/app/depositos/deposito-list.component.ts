import { Component, OnInit } from '@angular/core';
import { Deposito } from './deposito';
import { ListService } from '../list.service';

import { Observable } from 'rxjs/Observable';

@Component({
  moduleId: module.id,
  selector: 'deposito-list',
  template: `
          <br>
          <datatable [dataset]=depositos [enableFilter]=true (deleteId)="delete($event)" (modifyId)="modify($event)">
              <column [value]="'id'" [header]="'Id'"></column>
              <column [value]="'nombre'" [header]="'Nombre'"></column>
              <column [value]="'stockMaximo'" [header]="'Stock Maximo'"></column>
              <column [value]="'stockHuevos'" [header]="'Stock Maximo'"></column>
              <column [value]="'borrado'" [header]="'Borrado'"></column>
          </datatable>

          <div class="error" *ngIf="errorMessage">{{errorMessage}}</div>
          `,
  providers: [ ListService ]
})
export class DepositoListComponent implements OnInit {
  
  private depositosListarUrl = 'http://localhost:8080/ChickenEscuelita/depositosJson';
  private depositosBorrarUrl = 'http://localhost:8080/ChickenEscuelita/depositosBorrarJson';
  errorMessage: string;
  depositos: Deposito[];

  constructor (private listService: ListService) {}

  ngOnInit() { this.getDepositos(); }

  getDepositos() {
    this.listService.getList(this.depositosListarUrl)
                     .subscribe(
                       depositos => this.depositos = depositos,
                       error =>  this.errorMessage = <any>error);
  }

  delete(objeto) {
    let lista: Deposito[];
    this.listService.delete(this.depositosBorrarUrl, objeto).subscribe(null,null,
    ()=>this.listService.getList(this.depositosListarUrl)
                     .subscribe(
                       depositos => {lista = depositos;
                       this.depositos = lista},
                       error =>  this.errorMessage = <any>error));
  }

  modify(row){
    console.log("modificar:"+row.id);
  }
}