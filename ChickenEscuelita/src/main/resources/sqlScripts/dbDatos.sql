insert into Perfil (nombre) values
('root');

insert into Permiso (permiso, modulo) values
('Crear', 'USUARIOS'),('Listar', 'USUARIOS'),('Modificar', 'USUARIOS'),('Borrar', 'USUARIOS'),('Exportar', 'USUARIOS'),
('Crear', 'PROVEEDORES'),('Listar', 'PROVEEDORES'),('Modificar', 'PROVEEDORES'),('Borrar', 'PROVEEDORES'),('Exportar', 'PROVEEDORES'),
('Crear', 'PARAMETROS'),('Listar', 'PARAMETROS'),('Modificar', 'PARAMETROS'),('Borrar', 'PARAMETROS'),('Exportar', 'PARAMETROS'),
('Crear', 'VENTAS'),('Listar', 'VENTAS'),('Modificar', 'VENTAS'),('Borrar', 'VENTAS'),('Exportar', 'VENTAS'),
('Crear', 'MOVIMIENTOS'),('Listar', 'MOVIMIENTOS'),('Modificar', 'MOVIMIENTOS'),('Borrar', 'MOVIMIENTOS'),('Exportar', 'MOVIMIENTOS'),
('Crear', 'GALLINEROS'),('Listar', 'GALLINEROS'),('Modificar', 'GALLINEROS'),('Borrar', 'GALLINEROS'),('Exportar', 'GALLINEROS'),
('Crear', 'DEPOSITOS'),('Listar', 'DEPOSITOS'),('Modificar', 'DEPOSITOS'),('Borrar', 'DEPOSITOS'),('Exportar', 'DEPOSITOS'),
('Crear', 'PERFILES'),('Listar', 'PERFILES'),('Modificar', 'PERFILES'),('Borrar', 'PERFILES'),('Exportar', 'PERFILES'),
('Crear', 'PRODUCCION'),('Listar', 'PRODUCCION'),('Modificar', 'PRODUCCION'),('Borrar', 'PRODUCCION'),('Exportar', 'PRODUCCION');

insert into PerfilPermiso (idPerfil, idPermiso) values
(1,1),(1,2),(1,3),(1,4),(1,5),(1,6),(1,7),(1,8),(1,9),(1,10),(1,11),(1,12),(1,13),(1,14),(1,15),(1,16),(1,17),
(1,21),(1,22),(1,26),(1,27),(1,28),(1,29),(1,30),(1,31),(1,32),(1,33),(1,34),(1,35),
(1,36),(1,37),(1,38),(1,39),(1,40),(1,42);
insert into Usuario (nombreUsuario,nombre,apellido,contrasenia) values
					('root','DIOS','saiyajin','root');
					
insert into PerfilUsuario (idPerfil,idUsuario) values
(1,1);
