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


INSERT INTO Proveedores (nombre_proveedor, telefono_proveedor, direccion, email_proveedor) VALUES
('Autopartes Global', 5551010, 'Calle 10 #45-12', 'ventas@autoglobal.com'),
('Repuestos El Rayo', 5552020, 'Av. Central 789', 'contacto@elrayo.com'),
('TecnoMotores', 5553030, 'Carrera 50 #12-30', 'info@tecnomotores.com'),
('Distribuidora Norte', 5554040, 'Calle Norte 45', 'norte_dist@mail.com'),
('Importadora Oriental', 5555050, 'Zona Industrial 4', 'import_oriental@parts.com'),
('Frenos y Más', 5556060, 'Transversal 8 #99', 'frenosymas@servicio.com'),
('Baterías Premium', 5557070, 'Av. Principal 101', 'ventas@batpremium.com'),
('Lubricantes Pro', 5558080, 'Calle 22 #5-10', 'admin@lubripro.com'),
('Carrocería Express', 5559090, 'Sector Sur Bloque 2', 'express@carroceria.com'),
('Electrónicos Auto', 5550000, 'Calle de la Tecnología 3', 'e-auto@parts.com');


INSERT INTO Empleados (nombre_empleado, apellido_empleado, puesto_empleado, email_empleado) VALUES
('Juan', 'Pérez', 'Vendedor', 'juan.perez@taller.com'),
('María', 'García', 'Cajera', 'maria.garcia@taller.com'),
('Carlos', 'López', 'Vendedor', 'carlos.lopez@taller.com'),
('Ana', 'Martínez', 'Gerente', 'ana.mtz@taller.com'),
('Luis', 'Rodríguez', 'Vendedor', 'luis.rod@taller.com'),
('Elena', 'Sánchez', 'Vendedor', 'elena.s@taller.com'),
('Pedro', 'Gómez', 'Almacenista', 'pedro.g@taller.com'),
('Lucía', 'Díaz', 'Cajera', 'lucia.diaz@taller.com'),
('Roberto', 'Ruiz', 'Vendedor', 'roberto.r@taller.com'),
('Sofía', 'Castro', 'Vendedor', 'sofia.c@taller.com');


INSERT INTO Repuestos (nombre_repuesto, categoria_repuesto, precio_compra, precio_venta, id_proveedor) VALUES
('Pastillas de Freno', 'Frenos', 15.50, 25.00, 6),
('Filtro de Aceite', 'Motor', 5.00, 12.00, 8),
('Batería 12V', 'Eléctrico', 45.00, 85.00, 7),
('Amortiguador Delantero', 'Suspensión', 30.00, 55.00, 1),
('Bujía Iridium', 'Motor', 4.00, 9.50, 3),
('Kit de Embrague', 'Transmisión', 120.00, 210.00, 2),
('Faro Halógeno', 'Iluminación', 25.00, 48.00, 10),
('Radiador', 'Refrigeración', 60.00, 110.00, 5),
('Correa de Distribución', 'Motor', 18.00, 35.00, 3),
('Espejo Lateral', 'Carrocería', 22.00, 42.00, 9);


INSERT INTO Ventas (fecha_venta, cantidad, total, id_empleado, id_repuesto) VALUES
('2024-05-01', 2, 50.00, 1, 1),
('2024-05-01', 1, 12.00, 3, 2),
('2024-05-02', 1, 85.00, 5, 3),
('2024-05-02', 2, 110.00, 6, 4),
('2024-05-03', 4, 38.00, 9, 5),
('2024-05-03', 1, 210.00, 1, 6),
('2024-05-04', 2, 96.00, 10, 7),
('2024-05-04', 1, 110.00, 5, 8),
('2024-05-05', 1, 35.00, 3, 9),
('2024-05-05', 2, 84.00, 6, 10);

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


