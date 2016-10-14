import { Component } from '@angular/core';

@Component({
  selector: 'listaUsuarios',
  template: `
            <h1>Usuarios</h1>
            <br>
            <usuario-list></usuario-list>
            <br>
            <button (click)="goBack()">back</button>
            `
})
export class UsuariosComponent { }