drop database if exists banco;

create database if not exists banco; 

use banco;

/*==============================================================*/
/* Tabla: sucursales                                             */
/*==============================================================*/
create table if not exists sucursales (
	id varchar (10) not null,
	nombre varchar(50) not null unique,
	ciudad varchar(50) not null,
	primary key(id)
);

insert into sucursales (id,nombre,ciudad) values ('1BO1','Mandalay','Bogota');
insert into sucursales (id,nombre,ciudad) values ('1CA1','Crucero','Cali');
insert into sucursales (id,nombre,ciudad) values ('1ME1','Bombay','Medellin');

select id,nombre,ciudad from sucursales

/*==============================================================*/
/* Tabla: clientes                                               */
/*==============================================================*/
create table if not exists clientes (
   	id varchar(15) not null,
	nombre varchar(150) not null,
   	direccion varchar(150) not null,
   	ciudad_cliente varchar (30) not null,
   	primary key (id)
);

insert into clientes (id,nombre,direccion,ciudad_cliente) values ('23123453','Lucas Sanchez', 'Calle 180#12-32','Bogota');
insert into clientes (id,nombre,direccion,ciudad_cliente) values ('23456789','María Perez','Calle 23#120-12','Cali');
insert into clientes (id,nombre,direccion,ciudad_cliente) values ('23456769','Juan Lopez', 'Calle 8#12-23','Medellin');
insert into clientes (id,nombre,direccion,ciudad_cliente) values ('89004321','Martin Suarez', 'Calle 123#45-33','Bogota');
insert into clientes (id,nombre,direccion,ciudad_cliente) values ('56784987','David Jaramillo', 'Calle 33#08-10','Cali');


select id, nombre, direccion, ciudad_cliente from clientes 

/*==============================================================*/
/* Tabla: empleados                                               */
/*==============================================================*/
create table if not exists empleados (
   	id_empleado varchar(15),
	empleado varchar(150) not null,
   	telefono varchar(150) not null,
   	jefe varchar(150) not null,
  	id_jefe varchar(15) not null,
  	id_sucursal varchar (10) not null,
  	fecha_incorporacion date not null,
  	primary key (id_empleado), 	
  	foreign key (id_sucursal) references sucursales (id)
);

insert into empleados (id_empleado,empleado,telefono,jefe,id_jefe,id_sucursal,fecha_incorporacion) values ('348643','Maria Delgado','5432123','Pedro Marin','796233','1BO1','2020-01-23');
insert into empleados (id_empleado,empleado,telefono,jefe,id_jefe,id_sucursal,fecha_incorporacion) values ('345632','Sara Ruiz', '5634578','Sofia Rey','872341','1CA1','2018-09-12');
insert into empleados (id_empleado,empleado,telefono,jefe,id_jefe,id_sucursal,fecha_incorporacion) values ('542356','Luisa Lopez', '6748973','Pablo Mora','665588','1ME1','2017-09-1');


select id_empleado,empleado,telefono,jefe,id_jefe,id_sucursal,fecha_incorporacion from empleados

/*==============================================================*/
/* Tabla: productos                                             */
/*==============================================================*/
create table if not exists productos (
	id_producto bigint not null auto_increment, 
	id_cliente varchar(15) not null,
   	cuenta_ahorros varchar (50),
   	cuenta_corriente varchar (50),
   	prestamo varchar (150),
   	id_empleado varchar(15),
   	primary key (id_producto),
   	foreign key (id_cliente) references clientes (id),
   	foreign key (id_empleado) references empleados (id_empleado)
);

insert into productos (id_cliente,cuenta_ahorros,cuenta_corriente,prestamo,id_empleado) values ('23123453','809234567','','1300000','348643');
insert into productos (id_cliente,cuenta_ahorros,cuenta_corriente,prestamo,id_empleado) values ('23456789','809234567','','','345632');
insert into productos (id_cliente,cuenta_ahorros,cuenta_corriente,prestamo,id_empleado) values ('23456769','813245678','451200321','35000000','542356');

select id_cliente,cuenta_ahorros,cuenta_corriente,prestamo,id_empleado from productos 
