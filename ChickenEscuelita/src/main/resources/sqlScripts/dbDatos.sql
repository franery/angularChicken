insert into Perfil (nombre) values
('root');

insert into Permiso (permiso, modulo) values
('Listar', 'usuarios'),('Modificar', 'usuarios');

insert into PerfilPermiso (idPerfil, idPermiso) values
(1,1),(1,2);

insert into Usuario (nombreUsuario,nombre,apellido,contrasenia) values
					('root','DIOS','saiyajin','root');
					
insert into PerfilUsuario (idPerfil,idUsuario) values
(1,1);
