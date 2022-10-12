drop database if exists tareaJSP;
create database if not exists tareaJSP;
use tareaJSP;

create table usuarios(
	correo varchar(100) not null primary key,
	clave blob,
	fechaUltimoAcceso datetime not null,
	intentosFallidos tinyint not null default 0
);

create table if not exists empleados(
	tipoDocumento varchar(10) not null,
	numeroDocumento varchar(20) not null,
	nombre varchar(50) null,
	apellido varchar(50) null,
	edad int null,
	fechaNacimiento date null,
	primary key(tipoDocumento, numeroDocumento)
);

-- para borrar un registro de la tabla
delete from usuarios where correo='user1@educacionit.com';