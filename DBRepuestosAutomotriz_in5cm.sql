Drop database if exists DBRepuestosAutomotriz_in5cm;
create database DBRepuestosAutomotriz_in5cm;
use DBRepuestosAutomotriz_in5cm;

create table Proveedores(
	id_proveedor int auto_increment not null,
 	nombre_proveedor varchar(60) not null,
 	telefono_proveedor int not null,
 	direccion varchar(100) not null,
 	email_proveedor varchar(100) not null,
 	primary key PK_id_proveedor(id_proveedor)
);

create table Empleados(
	id_empleado int auto_increment not null,
 	nombre_empleado varchar(60) not null,
 	apellido_empleado varchar(60) not null,
 	puesto_empleado varchar(20) null,
 	email_empleado varchar(100) not null,
 	primary key PK_id_empleado(id_empleado)
);

create table Repuestos(
	id_repuesto int auto_increment not null,
 	nombre_repuesto varchar(60) not null,
 	categoria_repuesto varchar(60) not null,
 	precio_compra double not null,
 	precio_venta double not null,
 	id_proveedor int not null,
 	primary key PK_id_repuesto(id_repuesto),
 	constraint FK_repuesto_proveedor foreign key (id_proveedor)
	references Proveedores(id_proveedor) on delete cascade
);

create table Ventas(
	id_venta int auto_increment not null,
 	fecha_venta date not null,
 	cantidad int not null,
 	total double not null,
	id_empleado int not null,
 	id_repuesto int not null,
 	primary key PK_id_venta(id_venta),
 	constraint FK_ventas_empleado foreign key (id_empleado)
	references Empleados(id_empleado) on delete cascade,
 	constraint FK_ventas_repuestos foreign key (id_repuesto)
	references Repuestos(id_repuesto) on delete cascade
);

-- CREATE - PROVEEDORES --
DELIMITER $$
CREATE PROCEDURE sp_AgregarProveedores(
	IN p_nombre_proveedor VARCHAR(60),
	IN p_telefono_proveedor INT,
	IN p_direccion VARCHAR(100),
	IN p_email_proveedor VARCHAR(100)
)
BEGIN
	INSERT INTO Proveedores(nombre_proveedor, telefono_proveedor, direccion, email_proveedor)
	VALUES (p_nombre_proveedor, p_telefono_proveedor, p_direccion, p_email_proveedor);
END$$
DELIMITER ;

-- READ - PROVEEDORES --
DELIMITER $$
CREATE PROCEDURE sp_LeerProveedores(
)
BEGIN
	SELECT * FROM Proveedores;
END$$
DELIMITER ;

-- UPDATE - PROVEEDORES --
DELIMITER $$
CREATE PROCEDURE sp_ModificarProveedores(
	IN p_id_proveedor INT,
	IN p_nombre_proveedor VARCHAR(60),
	IN p_telefono_proveedor INT,
	IN p_direccion VARCHAR(100),
	IN p_email_proveedor VARCHAR(100)
)
BEGIN
	UPDATE Proveedores SET 
	nombre_proveedor = p_nombre_proveedor,
	telefono_proveedor = p_telefono_proveedor,
	direccion = p_direccion,
	email_proveedor = p_email_proveedor
	WHERE id_proveedor = p_id_proveedor;
END$$
DELIMITER ;

-- DELETE - PROVEEDORES --
DELIMITER $$
CREATE PROCEDURE sp_EliminarProveedores(
	IN p_id_proveedor INT
)
BEGIN
	DELETE FROM Proveedores WHERE id_proveedor = p_proveedor;
END$$
DELIMITER :

-- CREATE - EMPLEADOS --
DELIMITER $$
CREATE PROCEDURE sp_AgregarEmpleados(
 	IN p_nombre_empleado VARCHAR(60),
 	IN p_apellido_empleado VARCHAR(60),
 	IN p_puesto_empleado VARCHAR(20),
 	IN p_email_empleado VARCHAR(100)
)
BEGIN
	INSERT INTO Empleados(nombre_empleado, apellido_empleado, puesto_empleado, email_empleado)
	VALUES (p_nombre_empleado, p_apellido_empleado, p_puesto_empleado, p_email_empleado);
END$$
DELIMITER ;

-- READ - EMPLEADOS --
DELIMITER $$
CREATE PROCEDURE sp_LeerEmpleados(
)
BEGIN
	SELECT * FROM Empleados;
END$$
DELIMITER ;

-- UPDATE - EMPLEADOS --
DELIMITER $$
CREATE PROCEDURE sp_ModificarEmpleados(
	IN p_id_empleado INT,
	IN p_nombre_empleado VARCHAR(60),
 	IN p_apellido_empleado VARCHAR(60),
 	IN p_puesto_empleado VARCHAR(20),
 	IN p_email_empleado VARCHAR(100)
)
BEGIN
	UPDATE Empleados SET 
	nombre_empleado = p_nombre_empleado,
	apellido_empleado = p_apellido_empleado,
	puesto_empleado = p_puesto_empleado,
	email_empleado = p_email_empleado
	WHERE id_empleado = p_id_empleado;
END$$
DELIMITER ;

-- DELETE - EMPLEADOS --
DELIMITER $$
CREATE PROCEDURE sp_EliminarEmpleados(
	IN p_id_empleado INT
)
BEGIN
	DELETE FROM Empleados WHERE id_empleado = p_id_empleado;
END$$
DELIMITER ;

-- CREATE - REPUESTOS --
DELIMITER $$
CREATE PROCEDURE sp_AgregarRepuestos(
 	IN p_nombre_repuesto VARCHAR(60),
 	IN p_categoria_repuesto VARCHAR(60),
 	IN p_precio_compra DOUBLE,
 	IN p_precio_venta DOUBLE,
 	IN p_id_proveedor INT
)
BEGIN
	INSERT INTO Repuestos(nombre_repuesto, categoria_repuesto, precio_compra, precio_venta, id_proveedor)
	VALUES (p_nombre_repuesto, p_categoria_repuesto, p_precio_compra, p_precio_venta, p_id_proveedor);
END$$
DELIMITER ;

-- READ - REPUESTOS --
DELIMITER $$
CREATE PROCEDURE sp_LeerRepuestos(
)
BEGIN
	SELECT * FROM Repuestos;
END$$
DELIMITER ;

-- UPDATE - REPUESTOS --
DELIMITER $$
CREATE PROCEDURE sp_ModificarRepuestos(
	IN p_id_repuesto INT,
 	IN p_nombre_repuesto VARCHAR(60),
 	IN p_categoria_repuesto VARCHAR(60),
 	IN p_precio_compra DOUBLE,
 	IN p_precio_venta DOUBLE,
 	IN p_id_proveedor INT
)
BEGIN
	UPDATE Repuestos SET 
	nombre_repuesto = p_nombre_repuesto,
	categoria_repuesto = p_categoria_repuesto,
	precio_compra = p_precio_compra,
	precio_venta = p_precio_venta,
	id_proveedor = p_id_proveedor
	WHERE id_repuesto = p_id_repuesto;
END$$
DELIMITER ;

-- DELETE - REPUESTOS --
DELIMITER $$
CREATE PROCEDURE sp_EliminarRepuestos(
	IN p_id_repuesto INT
)
BEGIN
	DELETE FROM Repuestos WHERE id_repuesto = p_id_repuesto;
END$$
DELIMITER ;


-- CREATE - VENTAS --
DELIMITER $$
CREATE PROCEDURE sp_AgregarVentas(
 	IN p_fecha_venta DATE,
 	IN p_cantidad INT,
 	IN p_total DOUBLE,
	IN p_id_empleado INT,
 	IN p_id_repuesto INT
)
BEGIN
	INSERT INTO Ventas(fecha_venta, cantidad, total, id_empleado, id_repuesto)
	VALUES (p_fecha_venta, p_cantidad, p_total, p_id_empleado, p_id_repuesto);
END$$
DELIMITER ;

-- READ - VENTAS --
DELIMITER $$
CREATE PROCEDURE sp_LeerVentas(
)
BEGIN
	SELECT * FROM Ventas;
END$$
DELIMITER ;

-- UPDATE - VENTAS --
DELIMITER $$
CREATE PROCEDURE sp_ModificarVentas(
	IN p_id_venta INT,
 	IN p_fecha_venta DATE,
 	IN p_cantidad INT,
 	IN p_total DOUBLE,
	IN p_id_empleado INT,
 	IN p_id_repuesto INT
)
BEGIN
	UPDATE Ventas SET 
	fecha_venta = p_fecha_venta,
	cantidad = p_cantidad,
	total = p_total,
	id_empleado = p_id_empleado,
	id_repuesto = p_id_repuesto
	WHERE id_venta = p_id_venta;
END$$
DELIMITER ;

-- DELETE - VENTAS --
DELIMITER $$
CREATE PROCEDURE sp_EliminarVentas(
	IN p_id_venta INT
)
BEGIN
	DELETE FROM Ventas WHERE id_venta = p_id_venta;
END$$
DELIMITER ;

CALL sp_AgregarProveedores('Autopartes Global', 5551010, 'Calle 10 #45-12',   'ventas@autoglobal.com');
CALL sp_AgregarProveedores('Repuestos El Rayo', 5552020, 'Av. Central 789',   'contacto@elrayo.com');
CALL sp_AgregarProveedores('TecnoMotores'     , 5553030, 'Carrera 50 #12-30', 'info@tecnomotores.com');
CALL sp_AgregarProveedores('Distribuidora Norte', 5554040, 'Calle Norte 45', 'norte_dist@mail.com');
CALL sp_AgregarProveedores('Importadora Oriental', 5555050, 'Zona Industrial 4', 'import_oriental@parts.com');
CALL sp_AgregarProveedores('Frenos y Más', 5556060, 'Transversal 8 #99', 'frenosymas@servicio.com');
CALL sp_AgregarProveedores('Baterías Premium', 5557070, 'Av. Principal 101', 'ventas@batpremium.com');
CALL sp_AgregarProveedores('Lubricantes Pro', 5558080, 'Calle 22 #5-10', 'admin@lubripro.com');
CALL sp_AgregarProveedores('Carrocería Express', 5559090, 'Sector Sur Bloque 2', 'express@carroceria.com');
CALL sp_AgregarProveedores('Electrónicos Auto', 5550000, 'Calle de la Tecnología 3', 'e-auto@parts.com');

CALL sp_AgregarEmpleados('Juan', 'Pérez', 'Vendedor', 'juan.perez@taller.com');
CALL sp_AgregarEmpleados('María', 'García', 'Cajera', 'maria.garcia@taller.com');
CALL sp_AgregarEmpleados('Carlos', 'López', 'Vendedor', 'carlos.lopez@taller.com');
CALL sp_AgregarEmpleados('Ana', 'Martínez', 'Gerente', 'ana.mtz@taller.com');
CALL sp_AgregarEmpleados('Luis', 'Rodríguez', 'Vendedor', 'luis.rod@taller.com');
CALL sp_AgregarEmpleados('Elena', 'Sánchez', 'Vendedor', 'elena.s@taller.com');
CALL sp_AgregarEmpleados('Pedro', 'Gómez', 'Almacenista', 'pedro.g@taller.com');
CALL sp_AgregarEmpleados('Lucía', 'Díaz', 'Cajera', 'lucia.diaz@taller.com');
CALL sp_AgregarEmpleados('Roberto', 'Ruiz', 'Vendedor', 'roberto.r@taller.com');
CALL sp_AgregarEmpleados('Sofía', 'Castro', 'Vendedor', 'sofia.c@taller.com');

CALL sp_AgregarRepuestos('Pastillas de Freno', 'Frenos', 15.50, 25.00, 6);
CALL sp_AgregarRepuestos('Filtro de Aceite', 'Motor', 5.00, 12.00, 8);
CALL sp_AgregarRepuestos('Batería 12V', 'Eléctrico', 45.00, 85.00, 7);
CALL sp_AgregarRepuestos('Amortiguador Delantero', 'Suspensión', 30.00, 55.00, 1);
CALL sp_AgregarRepuestos('Bujía Iridium', 'Motor', 4.00, 9.50, 3);
CALL sp_AgregarRepuestos('Kit de Embrague', 'Transmisión', 120.00, 210.00, 2);
CALL sp_AgregarRepuestos('Faro Halógeno', 'Iluminación', 25.00, 48.00, 10);
CALL sp_AgregarRepuestos('Radiador', 'Refrigeración', 60.00, 110.00, 5);
CALL sp_AgregarRepuestos('Correa de Distribución', 'Motor', 18.00, 35.00, 3);
CALL sp_AgregarRepuestos('Espejo Lateral', 'Carrocería', 22.00, 42.00, 9);

CALL sp_AgregarVentas('2024-05-01', 2, 50.00, 1, 1);
CALL sp_AgregarVentas('2024-05-01', 1, 12.00, 3, 2);
CALL sp_AgregarVentas('2024-05-02', 1, 85.00, 5, 3);
CALL sp_AgregarVentas('2024-05-02', 2, 110.00, 6, 4);
CALL sp_AgregarVentas('2024-05-03', 4, 38.00, 9, 5);
CALL sp_AgregarVentas('2024-05-03', 1, 210.00, 1, 6);
CALL sp_AgregarVentas('2024-05-04', 2, 96.00, 10, 7);
CALL sp_AgregarVentas('2024-05-04', 1, 110.00, 5, 8);
CALL sp_AgregarVentas('2024-05-05', 1, 35.00, 3, 9);
CALL sp_AgregarVentas('2024-05-05', 2, 84.00, 6, 10);

SELECT * FROM Proveedores;
SELECT * FROM Empleados;
SELECT * FROM Repuestos;
SELECT * FROM Ventas;