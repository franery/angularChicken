import { Component, OnInit } from '@angular/core';
import { Deposito } from './deposito';
import { ListService } from '../list.service';
import { Router } from '@angular/router';

import { Observable } from 'rxjs/Observable';

@Component({
  
  selector: 'deposito-list',
  template: `
          <br>
          <button (click)="nuevo()" class="btn btn-success pull-left">Nuevo</button>
          <br>
          <datatable [dataset]=depositos [enableFilter]=true (deleteId)="delete($event)" (modifyId)="modify($event)">
              <column [value]="'id'" [header]="'Id'"></column>
              <column [value]="'nombre'" [header]="'Nombre'"></column>
              <column [value]="'stockHuevos'" [header]="'Stock Huevos'"></column>
              <column [value]="'stockMaximo'" [header]="'Stock Maximo'"></column>
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

  constructor (private listService: ListService, private router: Router) {}

  ngOnInit() {
    this.getDepositos();
  }

  nuevo() {
    this.router.navigate(['/depositosForm']);
  }

  getDepositos() {
    this.listService.getList(this.depositosListarUrl)
                     .subscribe(
                       depositos => this.depositos = depositos,
                       error =>  this.errorMessage = <any>error);
  }

  delete(objeto: any) {
    let lista: Deposito[];
    this.listService.delete(this.depositosBorrarUrl, objeto).subscribe(null,null,
    ()=>this.listService.getList(this.depositosListarUrl)
                     .subscribe(
                       depositos => {lista = depositos;
                       this.depositos = lista},
                       error =>  this.errorMessage = <any>error));
  }

  modify(row: any){
    console.log("modificar:"+row.id);
  }
}