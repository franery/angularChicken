drop database db_chicken;
CREATE DATABASE db_chicken;
USE db_chicken;


create TABLE Usuario (
    id bigint(10) primary key auto_increment,
    nombreUsuario varchar(50) NOT NULL,
    nombre varchar(50) NOT NULL,
    apellido varchar(50) NOT NULL,
    contrasenia varchar(50) NOT NULL,
    perfil varchar(50) NOT NULL
);


CREATE TABLE Proveedor (
    id bigint(10) primary key AUTO_INCREMENT,
    nombre varchar(50) NOT NULL,
	direccion varchar(50) NOT NULL,
    mail varchar(50) NOT NULL,
    telefono  varchar(50) NOT NULL
);

CREATE TABLE Gallinero (
	id bigint(10) primary key auto_increment,
    nombre varchar(50) NOT NULL,
    stockGallinas bigint(10) NOT NULL,
    idUsuario bigint(10) not null,
    foreign key (idUsuario)
        References Usuario (id)
);


CREATE TABLE Deposito (
    id bigint(10) primary key auto_increment,
    nombre varchar(100) not null,
    stockMaximo bigint(10) not null,
    stockHuevos bigint(10) default 0
);


create table Movimiento (
	id bigint(10) primary key auto_increment,
    fecha date not null,
    cantidad bigint(10) not null,
    idGallinero bigint(10) not null,
    idDeposito bigint(10) not null,
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
    foreign key (idProveedor) references Proveedor (id),
    foreign key (idUsuario) references usuario (id)
);

create table Parametro (
	id bigint(10) primary key auto_increment,
    descripcion varchar(50) not null,
    valor  varchar(50) not null
);

select * from Parametro;

insert into Parametro ( descripcion , valor ) values ('hola','pibe');