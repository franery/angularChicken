export class Venta {
  constructor(
    public id: number,
    public fecha: Date,
    public cantidad: number,
    public precio: number,
    public usuarioId: string,
    public usuarioNombre: string,
    public proveedorId: string,
    public proveedorNombre: string,
    public borrado: string    
    ){}
}