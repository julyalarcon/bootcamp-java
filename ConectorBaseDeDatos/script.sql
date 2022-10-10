drop database if exists practicaweb ;
create database if not exists practicaweb;
use practicaweb;

create table busquedas(
	id int not null auto_increment,
	texto varchar(2000) not null, 
	url varchar(2000) not null,
	contenidoWeb varchar(2000) not null,
	fecha datetime not null,
	primary key (id)
);