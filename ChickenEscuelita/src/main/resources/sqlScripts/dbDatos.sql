use db_chicken;

insert into perfil (nombre) values
	('root');

insert into Permiso (permiso, modulo) values
	('CREAR', 'USUARIOS'),('LISTAR', 'USUARIOS'),('MODIFICAR', 'USUARIOS'),('BORRAR', 'USUARIOS'),('EXPORTAR', 'USUARIOS'),
	('CREAR', 'PROVEEDORES'),('LISTAR', 'PROVEEDORES'),('MODIFICAR', 'PROVEEDORES'),('BORRAR', 'PROVEEDORES'),('EXPORTAR', 'PROVEEDORES'),
	('CREAR', 'PARAMETROS'),('LISTAR', 'PARAMETROS'),('MODIFICAR', 'PARAMETROS'),('BORRAR', 'PARAMETROS'),('EXPORTAR', 'PARAMETROS'),
	('CREAR', 'VENTAS'),('LISTAR', 'VENTAS'),('MODIFICAR', 'VENTAS'),('BORRAR', 'VENTAS'),('EXPORTAR', 'VENTAS'),
	('CREAR', 'MOVIMIENTOS'),('LISTAR', 'MOVIMIENTOS'),('MODIFICAR', 'MOVIMIENTOS'),('BORRAR', 'MOVIMIENTOS'),('EXPORTAR', 'MOVIMIENTOS'),
	('CREAR', 'GALLINEROS'),('LISTAR', 'GALLINEROS'),('MODIFICAR', 'GALLINEROS'),('BORRAR', 'GALLINEROS'),('EXPORTAR', 'GALLINEROS'),
	('CREAR', 'DEPOSITOS'),('LISTAR', 'DEPOSITOS'),('MODIFICAR', 'DEPOSITOS'),('BORRAR', 'DEPOSITOS'),('EXPORTAR', 'DEPOSITOS'),
	('CREAR', 'PERFILES'),('LISTAR', 'PERFILES'),('MODIFICAR', 'PERFILES'),('BORRAR', 'PERFILES'),('EXPORTAR', 'PERFILES'),
	('CREAR', 'PRODUCCION'),('LISTAR', 'PRODUCCION'),('MODIFICAR', 'PRODUCCION'),('BORRAR', 'PRODUCCION'),('EXPORTAR', 'PRODUCCION');

insert into PerfilPermiso (idPerfil, idPermiso) values
	(1, 1),(1, 2),(1, 3),(1, 4),(1, 5),
	(1, 6),(1, 7),(1, 8),(1, 9),(1, 10),
	(1, 11),(1, 12),(1, 13),(1, 14),(1, 15),
	(1, 16),(1, 17),
	(1, 21),(1, 22),
	(1, 26),(1, 27),(1, 28),(1, 29),(1, 30),
	(1, 31),(1, 32),(1, 33),(1, 34),(1, 35),
	(1, 36),(1, 37),(1, 38),(1, 39),(1, 40),
	(1, 42);

insert into Usuario (nombreUsuario,nombre,apellido,contrasenia) values
	('root','DIOS','saiyajin','root');
					
insert into PerfilUsuario (idPerfil,idUsuario) values
	(1,1);

insert into Perfil(nombre) values
	('Administrador'),
    ('Contable'),
    ('Productor');

insert into PerfilPermiso(idPerfil, idPermiso) values
	(2, 1),(2, 2),(2, 3),(2, 4),(2, 5),
    (2, 11),(2, 12),(2, 13),(2, 14),(2, 15),
    (2, 36),(2, 37),(2, 38),(2, 39),(2, 40),
    (3, 16),(3, 17),
    (3, 21),(3, 22),
    (4, 6),(4, 7),(4, 8),(4, 9),(4, 10),
    (4, 26),(4, 27),(4, 28),(4, 29),(4, 30),
	(4, 31),(4, 32),(4, 33),(4, 34),(4, 35),
    (4, 42);

insert into Usuario(nombreUsuario, contrasenia, nombre, apellido) values
	('Juan', 'angular', 'Juan', 'Filimino'),
    ('Pedro', 'jquery', 'Pedro', 'Roquez'),
    ('Julian', 'javascript', 'Julian', 'Brumin');

insert into PerfilUsuario(idPerfil, idUsuario) values
	(2, 2),
    (3, 3),
    (4, 4);

insert into Proveedor(nombre, direccion, mail, telefono) values
	('Via Sol SRL', 'CalleFalsa 123', 'via.sol@gmail.com', '45447833'),
    ('Map SA', 'Viamonte 555', 'mapp@gmail.com', '47423112'),
    ('Aves SRL', 'Tucuman 436', 'aves_master@gmail.com', '45664327');

insert into Gallinero(nombre, stockGallinas, idUsuario) values
	('Gallinero #1', 20, 2),
    ('Gallinero #2', 20, 2),
    ('Gallinero #3', 40, 3);

insert into Deposito(nombre, stockHuevos, stockMaximo) values
	('Deposito #1', 0, 100),
    ('Deposito #2', 0, 100),
    ('Deposito #3', 0, 200),
    ('Deposito #4', 0, 400),
    ('Deposito #5', 0, 1000);
    
insert into Parametro(descripcion, valor) values
	('Precio Unitario', '12'),
    ('Totales', '8');
    
commit;