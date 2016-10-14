import { Component, OnInit } from '@angular/core';
import { Proveedor } from './proveedor';
import { ListService } from '../list.service';

@Component({
  moduleId: module.id,
  selector: 'proveedores-list',
  template: `
          <br>
          <datatable [dataset]=proveedores [enableFilter]=true (deleteId)="delete($event)" (modifyId)="modify($event)">
              <column [value]="'id'" [header]="'Id'"></column>
              <column [value]="'nombre'" [header]="'Nombre'"></column>
              <column [value]="'direccion'" [header]="'Direccion'"></column>
              <column [value]="'mail'" [header]="'Mail'"></column>
              <column [value]="'telefono'" [header]="'Telefono'"></column>
          </datatable>

          <div class="error" *ngIf="errorMessage">{{errorMessage}}</div>
          `,
  providers: [ ListService ]
})
export class ProveedoresListComponent implements OnInit {
  
  private proveedoresListarUrl = 'http://localhost:8080/ChickenEscuelita/proveedoresJson';
  private proveedoresBorrarUrl = 'http://localhost:8080/ChickenEscuelita/proveedoresBorrarJson';
  errorMessage: string;
  proveedores: Proveedor[];

  constructor (private listService: ListService) {}

  ngOnInit() { this.getProveedores(); }

  getProveedores() {
    this.listService.getList(this.proveedoresListarUrl)
                     .subscribe(
                       proveedores => this.proveedores = proveedores,
                       error =>  this.errorMessage = <any>error);
  }

  delete(objeto) {
    this.listService.delete(this.proveedoresBorrarUrl, objeto).subscribe();
  }

  modify(row){
    console.log("modificar:"+row.id);
  }

}