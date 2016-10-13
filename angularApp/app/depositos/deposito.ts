export class Deposito {
  constructor(
    public id: number,
    public nombre: string,
    public stockHuevos: number,
    public stockMaximo: number,
    public borrado: string) { }
}