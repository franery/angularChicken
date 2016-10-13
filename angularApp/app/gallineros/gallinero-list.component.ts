import { Component, OnInit } from '@angular/core';
import { Gallinero } from './gallinero';
import { ListService } from '../list.service';

@Component({
  moduleId: module.id,
  selector: 'gallinero-list',
  template: `
      <br>
      <datatable [dataset]=gallineros [enableFilter]=true (deleteId)="delete($event)" (modifyId)="modify($event)">
          <column [value]="'id'" [header]="'Id'"></column>
          <column [value]="'nombre'" [header]="'Nombre'"></column>
          <column [value]="'usuarioId'" [header]="'Usuario Id'"></column>
          <column [value]="'usuarioNombre'" [header]="'Usuario Nombre'"></column>
          <column [value]="'stockGallinas'" [header]="'Stock Gallinas'"></column>
          <column [value]="'borrado'" [header]="'Borrado'"></column>
      </datatable>

          <div class="error" *ngIf="errorMessage">{{errorMessage}}</div>`,
  providers: [ ListService ]
})
export class GallineroListComponent implements OnInit {
  
  private gallinerosUrl = 'http://localhost:8080/ChickenEscuelita/gallinerosJson';  // URL to web API
  errorMessage: string;
  gallineros: Gallinero[];

  constructor (private listService: ListService) {}

  ngOnInit() { this.getGallineros(); }

  getGallineros() {
    this.listService.getList(this.gallinerosUrl)
                     .subscribe(
                       gallineros => this.gallineros = gallineros,
                       error =>  this.errorMessage = <any>error);
  }
  delete(id){
    console.log("deletear "+id);
  }
  modify(row){
    console.log("modifiquear "+row.id );
  }
}