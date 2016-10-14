import { Component, OnInit } from '@angular/core';
import { Perfil } from './perfil';
import { ListService } from '../list.service';

@Component({
  moduleId: module.id,
  selector: 'perfil-list',
  template: `
      <br>
      <datatable [dataset]=perfiles [enableFilter]=true (deleteId)="delete($event)" (modifyId)="modify($event)">
          <column [value]="'id'" [header]="'Id'"></column>
          <column [value]="'nombre'" [header]="'Nombre'"></column>
          <column [value]="'listaPermisos'" [header]="'Lista Permisos'"></column>
      </datatable>

          <div class="error" *ngIf="errorMessage">{{errorMessage}}</div>`,
  providers: [ ListService ]
})
export class PerfilListComponent implements OnInit {
  
  private perfilesListarUrl = 'http://localhost:8080/ChickenEscuelita/perfilesJson';
  private perfilesBorrarUrl = 'http://localhost:8080/ChickenEscuelita/perfilesBorrarJson';
  errorMessage: string;
  perfiles: Perfil[];

  constructor (private listService: ListService) {}

  ngOnInit() { this.getperfiles(); }

  getperfiles() {
    this.listService.getList(this.perfilesListarUrl)
                     .subscribe(
                       perfiles => this.perfiles = perfiles,
                       error =>  this.errorMessage = <any>error);
  }

  delete(objeto) {
    this.listService.delete(this.perfilesBorrarUrl, objeto).subscribe();
  }

  modify(row){
    console.log("modificar:"+row.id);
  }

}