insert into Perfil (nombre) values
('root');

insert into Permiso (permiso, modulo) values
('CREAR', 'USUARIOS'),('LISTAR', 'USUARIOS'),('MODIFICAR', 'USUARIOS'),('BORRAR', 'USUARIOS'),('EXPORTAR', 'USUARIOS'),
('CREAR', 'PROVEEDORES'),('LISTAR', 'PROVEEDORES'),('MODIFICAR', 'PROVEEDORES'),('BORRAR', 'PROVEEDORES'),('EXPORTAR', 'PROVEEDORES'),
('CREAR', 'PARAMETROS'),('LISTAR', 'PARAMETROS'),('MODIFICAR', 'PARAMETROS'),('BORRAR', 'PARAMETROS'),('EXPORTAR', 'PARAMETROS'),
('CREAR', 'VENTAS'),('LISTAR', 'VENTAS'),('MODIFICAR', 'VENTAS'),('Borrar', 'VENTAS'),('Exportar', 'VENTAS'),
('CREAR', 'MOVIMIENTOS'),('LISTAR', 'MOVIMIENTOS'),('MODIFICAR', 'MOVIMIENTOS'),('BORRAR', 'MOVIMIENTOS'),('EXPORTAR', 'MOVIMIENTOS'),
('CREAR', 'GALLINEROS'),('LISTAR', 'GALLINEROS'),('MODIFICAR', 'GALLINEROS'),('BORRAR', 'GALLINEROS'),('EXPORTAR', 'GALLINEROS'),
('CREAR', 'DEPOSITOS'),('LISTAR', 'DEPOSITOS'),('MODIFICAR', 'DEPOSITOS'),('BORRAR', 'DEPOSITOS'),('EXPORTAR', 'DEPOSITOS'),
('CREAR', 'PERFILES'),('LISTAR', 'PERFILES'),('MODIFICAR', 'PERFILES'),('BORRAR', 'PERFILES'),('EXPORTAR', 'PERFILES'),
('CREAR', 'PRODUCCION'),('LISTAR', 'PRODUCCION'),('MODIFICAR', 'PRODUCCION'),('BORRAR', 'PRODUCCION'),('EXPORTAR', 'PRODUCCION');

insert into PerfilPermiso (idPerfil, idPermiso) values
(1,1),(1,2),(1,3),(1,4),(1,5),(1,6),(1,7),(1,8),(1,9),(1,10),(1,11),(1,12),(1,13),(1,14),(1,15),(1,16),(1,17),
(1,21),(1,22),(1,26),(1,27),(1,28),(1,29),(1,30),(1,31),(1,32),(1,33),(1,34),(1,35),
(1,36),(1,37),(1,38),(1,39),(1,40),(1,42);
insert into Usuario (nombreUsuario,nombre,apellido,contrasenia) values
					('root','DIOS','saiyajin','root');
					
insert into PerfilUsuario (idPerfil,idUsuario) values
(1,1);
