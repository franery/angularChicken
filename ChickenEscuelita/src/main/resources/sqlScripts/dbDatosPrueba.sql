use db_chicken;

insert into Perfil (nombre) values
('root');

insert into Permiso (nombre) values
('usuariosC'),
('usuariosR'),
('usuariosU'),
('usuariosD'),
('parametrosC'),
('parametrosR'),
('parametrosU'),
('parametrosD'),
('proveedoresC'),
('proveedoresR'),
('proveedoresU'),
('proveedoresD'),
('depositosC'),
('depositosR'),
('depositosU'),
('depositosD'),
('gallinerosC'),
('gallinerosR'),
('gallinerosU'),
('gallinerosD'),
('ventasC'),
('ventasR'),
('movimientosC'),
('movimientosR'),
('produccion'),
('perfilC'),
('perfilR'),
('perfilU'),
('perfilD');

insert into PerfilPermiso (idPerfil, idPermiso) values
(1,1),(1,2),(1,3),(1,4),(1,5),(1,6),(1,7),(1,8),(1,9),(1,10),(1,11),(1,12),(1,13),(1,14),(1,15),(1,16),(1,17),(1,18),
(1,19),(1,20),(1,21),(1,22),(1,23),(1,24),(1,25),(1,26),(1,27),(1,28),(1,29);

insert into Usuario (nombreUsuario,nombre,apellido,contrasenia) values
					('root','root','root','root'),
					('Admin','SoyAdmin','Ape','cc'),
                    ('Productor','SoyProduc','Prod','cc'),
                    ('ProductorCopia','SoyPCopia','Cop','cc'),
                    ('ContableCopia','SoyCCopia','ContCopia','cc'),
                    ('Contable','SoyCont','Cont','cc');
       
insert into PerfilUsuario (idPerfil,idUsuario) values
(1,1);
             
insert into Proveedor (nombre,direccion,mail,telefono) values 
						('MaplesSRL','CalleFalsa123','pepe@maples.com','4777-7777'),
                        ('AveCaesarSRL','CalleVerdadera456','jorge@acaesar.com','4788-8888'),
                        ('ViasolSRL','CalleMentirosa789','julian@viasol.com','4799-9999');

insert into Deposito (nombre,stockHuevos,stockMaximo) values
						('Deposito1',0,100),
                        ('Deposito2',0,200),
                        ('Deposito3',0,300);
                        
insert into Gallinero (nombre,idUsuario,stockGallinas) values
						('Gallinero1',2,50),
                        ('Gallinero2',2,500),
                        ('Gallinero3',3,1000);
                        
insert into Movimiento (fecha,cantidad,idGallinero,idDeposito) values
						('20100421',30,1,1),
                        ('20100422',35,2,2),
                        ('20100423',40,3,3),
                        ('20100424',45,1,1),
                        ('20100425',50,2,2),
                        ('20100426',55,3,3),
                        ('20100427',60,1,1);
                        
insert into Venta (fecha,cantidad,precio,idProveedor,idUsuario) values
					('20100527',30,99.99,1,4),
                    ('20100627',35,99.99,2,5),
                    ('20100727',40,99.99,3,4),
                    ('20100827',45,99.99,1,5),
                    ('20100927',50,99.99,2,4),
                    ('20101027',55,99.99,3,5),
                    ('20101127',60,99.99,1,4);