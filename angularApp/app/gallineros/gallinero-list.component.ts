import { Component, OnInit } from '@angular/core';
import { Gallinero } from './gallinero';
import { GallineroService } from './gallinero.service';

@Component({
  moduleId: module.id,
  selector: 'gallinero-list',
  template: `
      <br>
      <datatable [dataset]=gallineros [enableFilter]=true>
          <column [value]="'id'" [header]="'Id'"></column>
          <column [value]="'nombre'" [header]="'Nombre'"></column>
          <column [value]="'usuarioId'" [header]="'Usuario Id'"></column>
          <column [value]="'usuarioNombre'" [header]="'Usuario Nombre'"></column>
          <column [value]="'stockGallinas'" [header]="'Stock Gallinas'"></column>
          <column [value]="'borrado'" [header]="'Borrado'"></column>
      </datatable>

          <div class="error" *ngIf="errorMessage">{{errorMessage}}</div>`,
  providers: [ GallineroService ]
})
export class GallineroListComponent implements OnInit {
  errorMessage: string;
  gallineros: Gallinero[];

  constructor (private gallineroService: GallineroService) {}

  ngOnInit() { this.getGallineros(); }

  getGallineros() {
    this.gallineroService.getGallineros()
                     .subscribe(
                       gallineros => this.gallineros = gallineros,
                       error =>  this.errorMessage = <any>error);
  }

}