export class Permiso {
  constructor(
    public id: number,
    public operacion: string,
    public modulo: string,
    public nombreModulo: string,
    public nombreOperacion: string) { }
}