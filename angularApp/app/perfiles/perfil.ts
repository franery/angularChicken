import { Permiso } from './permiso';

export class Perfil {
  constructor(
    public id: number,
    public nombre: string,
    public listaPermisos: Permiso[],
    public listaPermisosString: string) { }
}