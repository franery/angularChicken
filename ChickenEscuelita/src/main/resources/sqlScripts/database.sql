drop database db_chicken;

create database db_chicken;

use db_chicken;

create table Perfil (
	id bigint(10) primary key not null auto_increment,
	nombre varchar(50) unique not null
);

create table Permiso (
	id bigint(10) primary key not null auto_increment,
	permiso varchar(50) not null,
	modulo varchar(50) not null
);

create table PerfilPermiso (
	id bigint(10) primary key not null auto_increment,
	idPerfil bigint(10) not null,
	idPermiso bigint(10) not null,
    foreign key (idPerfil) references Perfil (id) on delete cascade,
    foreign key (idPermiso) references Permiso (id)
);


create table Usuario (
	id bigint(10) primary key not null auto_increment,
	nombreUsuario varchar(50) not null,
    nombre varchar(50) not null,
    apellido varchar(50) not null,
    contrasenia varchar(50) not null,
    borrado boolean default false not null
);

create table PerfilUsuario (
	id bigint(10) primary key not null auto_increment,
	idPerfil bigint(10) not null,
	idUsuario bigint(10) not null,
    foreign key (idPerfil) references Perfil (id) on delete cascade,
    foreign key (idUsuario) references Usuario (id) on delete cascade
);

create table Proveedor (
	id bigint(10) primary key auto_increment,
    nombre varchar(50) not null,
    direccion varchar(50) not null,
    mail varchar(50) not null,
    telefono varchar(50) not null,
    borrado boolean default false not null
);

create table Gallinero (
	id bigint(10) primary key auto_increment,
    nombre varchar(50) not null,
    idUsuario bigint(10),
    stockGallinas bigint(10) not null,
    borrado boolean default false not null,
	foreign key (idUsuario) references Usuario (id)
);

create table Deposito (
	id bigint(10) primary key auto_increment,
    nombre varchar(50) not null,
    stockHuevos bigint(10) default 0,
    stockMaximo bigint(10) not null,
    borrado boolean default false not null
);

create table Movimiento (
	id bigint(10) primary key auto_increment,
    fecha date not null,
    cantidad bigint(10) not null,
    idGallinero bigint(10) not null,
    idDeposito bigint(10) not null,
    borrado boolean default false not null,
    foreign key (idGallinero) references Gallinero (id),
	foreign key (idDeposito) references Deposito (id)
);

create table Venta (
	id bigint(10) primary key auto_increment,
    fecha date not null,
    cantidad bigint(10) not null,
    precio float not null,
    idProveedor bigint(10) not null,
    idUsuario bigint(10) not null,
    borrado boolean default false not null,
    foreign key (idProveedor) references Proveedor (id),
	foreign key (idUsuario) references Usuario (id)
);

create table Parametro (
	id bigint(10) primary key auto_increment,
    descripcion varchar(50) not null,
    valor varchar(50) not null,
    borrado boolean default false not null
);
