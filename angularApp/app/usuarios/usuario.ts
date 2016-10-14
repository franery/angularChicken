import { Perfil } from '../perfiles/perfil';

export class Usuario {
  constructor(
    public id: number,
    public nombre: string,
    public nombreUsuario: string,
    public apellido: string,
    public listaPerfiles: Perfil[],
    public listaPerfilesString: string,
    public borrado: string) { }
}