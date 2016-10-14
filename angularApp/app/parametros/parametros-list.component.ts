import { Component, OnInit } from '@angular/core';
import { Parametro } from './parametro';
import { ListService } from '../list.service';

@Component({
  moduleId: module.id,
  selector: 'parametros-list',
  template: `
          <br>
          <datatable [dataset]=parametros [enableFilter]=true (deleteId)="delete($event)" (modifyId)="modify($event)">
              <column [value]="'id'" [header]="'Id'"></column>
              <column [value]="'descripcion'" [header]="'Descripcion'"></column>
              <column [value]="'valor'" [header]="'Valor'"></column>
          </datatable>

          <div class="error" *ngIf="errorMessage">{{errorMessage}}</div>
          `,
  providers: [ ListService ]
})
export class ParametrosListComponent implements OnInit {
  
  private parametrosListarUrl = 'http://localhost:8080/ChickenEscuelita/parametrosJson';
  private parametrosBorrarUrl = 'http://localhost:8080/ChickenEscuelita/parametrosBorrarJson';
  errorMessage: string;
  parametros: Parametro[];

  constructor (private listService: ListService) {}

  ngOnInit() { this.getParametros(); }

  getParametros() {
    this.listService.getList(this.parametrosListarUrl)
                     .subscribe(
                       parametros => this.parametros = parametros,
                       error =>  this.errorMessage = <any>error);
  }

  delete(objeto) {
    this.listService.delete(this.parametrosBorrarUrl, objeto).subscribe();
  }

  modify(row){
    console.log("modificar:"+row.id);
  }

}