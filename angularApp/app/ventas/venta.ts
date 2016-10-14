export class Venta {
  constructor(
    public id: number,
    public fecha: Date,
    public cantidad: number,
    public precio: number,
    public usuario: string,
    public proveedor:  string,
    public borrado: string    
    ){}
}