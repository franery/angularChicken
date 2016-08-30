create database db_chicken;

use db_chicken;

create sequence

create table Usuario (
	id bigint(10) primary key not null auto_increment,
	nombreUsuario varchar(50) not null,
    nombre varchar(50) not null,
    apellido varchar(50) not null,
    perfil varchar(50) not null,
    contrasenia bigint(50) not null
);

create table Proveedor (
	id bigint(10) primary key auto_increment,
    nombre varchar(50) not null,
    direccion varchar(50) not null,
    mail varchar(50) not null,
    telefono varchar(50) not null
);

create table Gallinero (
	id bigint(10) primary key auto_increment,
    nombre varchar(50) not null,
    idUsuario bigint(10) not null,
    stockGallinas bigint(10) not null,
	foreign key (idUsuario) references Usuario (id)	on delete cascade
);

create table Deposito (
	id bigint(10) primary key auto_increment,
    nombre varchar(50) not null,
    stockHuevos bigint(10) default 0,
    stockMaximo bigint(10) not null
);

create table Movimiento (
	id bigint(10) primary key auto_increment,
    fecha date not null,
    cantidad bigint(10) not null,
    idGallinero bigint(10) not null,
    idDeposito bigint(10) not null,
    foreign key (idGallinero) references Gallinero (id) on delete cascade,
	foreign key (idDeposito) references Deposito (id) on delete cascade
);

create table Venta (
	id bigint(10) primary key auto_increment,
    fecha date not null,
    cantidad bigint(10) not null,
    precio float not null,
    idProveedor bigint(10) not null,
    idUsuario bigint(10) not null,
    foreign key (idProveedor) references Proveedor (id) on delete cascade,
	foreign key (idUsuario) references Usuario (id) on delete cascade
);

create table Parametro (
	id bigint(10) primary key auto_increment,
    descripcion varchar(50) not null,
    valor varchar(50) not null
);


delete from Parametro;
select * from Parametro;


use db_chicken;

select * from Usuario;
select * from Movimiento;
select * from gallinero;
select * from deposito;
insert into Usuario(nombreUsuario,nombre,apellido,perfil,contrasenia) values ('Probando','pepe','dd',2,'cc');
insert into Gallinero(nombre,idUsuario,stockGallinas) values ('Gall1',112,50),('Gall2',112,60);
insert into Movimiento(fecha,cantidad,idGallinero,idDeposito) values ('2000-11-11',20,52,66),('2000-11-12',30,53,66);
delete from Movimiento;
delete from Venta;
delete from Proveedor;
delete from Deposito;
delete from Gallinero;
delete from Usuario;
