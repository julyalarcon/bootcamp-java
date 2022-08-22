use banco;

select * from sucursales 

select count(*) from sucursales

select count(ciudad) from sucursales

select count(id) from clientes

select id_cliente, cuenta_ahorros from productos where id_producto <>1;

select empleado, jefe from empleados where id_empleado <>1;

select id_cliente, prestamo from productos order by prestamo asc;

select datediff('2022-08-22', '2018-09-12') 

select empleado, floor((datediff(now(),fecha_incorporacion))) from empleados

select id_empleado, empleado, 
year (fecha_incorporacion) as anio, 
month (fecha_incorporacion) as mes,
jefe
from empleados 
group by id_empleado, year (fecha_incorporacion), month (fecha_incorporacion);

select id_empleado, empleado, 
year (fecha_incorporacion) as anio, 
month (fecha_incorporacion) as mes,
jefe
from empleados 
where  year(fecha_incorporacion) = 2018
group by id_empleado, year (fecha_incorporacion), month (fecha_incorporacion);

select banco.productos.cuenta_corriente  from banco.productos 

