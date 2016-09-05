use db_chicken;

insert into Usuario (nombreUsuario,nombre,apellido,perfil,contrasenia) values
					('Admin','SoyAdmin','Ape',0,'cc'),
                    ('Productor','SoyProduc','Prod',2,'cc'),
                    ('ProductorCopia','SoyPCopia','Cop',2,'cc'),
                    ('ContableCopia','SoyCCopia','ContCopia',1,'cc'),
                    ('Contable','SoyCont','Cont',1,'cc');
                    
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
					('20100527',20,99.99,1,4),
                    ('20100627',25,99.99,2,5),
                    ('20100727',30,99.99,3,4),
                    ('20100827',35,99.99,1,5),
                    ('20100927',40,99.99,2,4),
                    ('20101027',45,99.99,3,5);
