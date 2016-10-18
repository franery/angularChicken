import { Component, OnInit } from '@angular/core';
import { Usuario } from './usuario';
import { ListService } from '../list.service';

@Component({
  
  selector: 'usuario-list',
  template: `
      <br>
      <datatable [dataset]=usuarios [enableFilter]=true (deleteId)="delete($event)" (modifyId)="modify($event)">
          <column [value]="'id'" [header]="'Id'"></column>
          <column [value]="'nombreUsuario'" [header]="'Nombre usuario'"></column>
          <column [value]="'nombre'" [header]="'Nombre'"></column>
          <column [value]="'apellido'" [header]="'Apellido'"></column>
          <column [value]="'listaPerfilesString'" [header]="'Perfiles'"></column>
      </datatable>

          <div class="error" *ngIf="errorMessage">{{errorMessage}}</div>`,
  providers: [ ListService ]
})
export class UsuarioListComponent implements OnInit {
  
  private usuariosListarUrl = 'http://localhost:8080/ChickenEscuelita/usuariosJson';
  private usuariosBorrarUrl = 'http://localhost:8080/ChickenEscuelita/usuariosBorrarJson';
  errorMessage: string;
  usuarios: Usuario[];
  probando:void;

  constructor (private listService: ListService) {}

  ngOnInit() { this.getUsuarios(); }

  getUsuarios() {
      this.listService.getList(this.usuariosListarUrl)
                      .subscribe(
                        usuarios => this.usuarios = usuarios,
                        error =>  this.errorMessage = <any>error,
                        () => this.setPerfiles());
  }

  setPerfiles() {
      for(var i = 0; i < this.usuarios.length; i++) {
          var listaPerfiles = this.usuarios[i].listaPerfiles;
          var perfiles = "";
          for (var j = 0; j < listaPerfiles.length; j++) {
              perfiles += listaPerfiles[j].nombre + " ";
          }
          this.usuarios[i].listaPerfilesString = perfiles;
      }
  }

  delete(objeto: any) {
    this.listService.delete(this.usuariosBorrarUrl, objeto).subscribe();
  }

  modify(row: any){
    console.log("modificar:"+row.id);
  }

}