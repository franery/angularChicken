import { Component, OnInit } from '@angular/core';
import { Venta } from './venta';
import { ListService } from '../list.service';

@Component({
  
  selector: 'ventas-list',
  template: `
          <br>
          <datatable [dataset]=ventas [enableFilter]=true (deleteId)="delete($event)" (modifyId)="modify($event)">
              <column [value]="'id'" [header]="'Id'"></column>
              <column [value]="'fecha'" [header]="'Fecha'"></column>
              <column [value]="'cantidad'" [header]="'Cantidad'"></column>
              <column [value]="'precio'" [header]="'Precio'"></column>
              <column [value]="'usuarioNombre'" [header]="'Usuario'"></column>
              <column [value]="'proveedorNombre'" [header]="'Proveedor'"></column>
          </datatable>

          <div class="error" *ngIf="errorMessage">{{errorMessage}}</div>
          `,
  providers: [ ListService ]
})
export class VentasListComponent implements OnInit {
  
  private ventasListarUrl = 'http://localhost:8080/ChickenEscuelita/ventasJson';
  errorMessage: string;
  ventas: Venta[];

  constructor (private listService: ListService) {}

  ngOnInit() { this.getVentas(); }

  getVentas() {
    this.listService.getList(this.ventasListarUrl)
                     .subscribe(
                       ventas => this.ventas = ventas,
                       error =>  this.errorMessage = <any>error);
  }

  delete(row: any) {
    console.log("modificar:"+row.id);
  }

  modify(row: any){
    console.log("modificar:"+row.id);
  }

}