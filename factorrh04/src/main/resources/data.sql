--Creación de la base de datos de usuarios
INSERT INTO EMPLEADO (id_Empleado, nombre, apellido_1, apellido_2, NIF, NASS, direccion, CP, email_particular, email, telefono, fecha_alta, fecha_baja, IBAN, SWIFT, sueldo_base, antiguedad, password, puesto) VALUES
('0001', 'Juan', 'Pérez', 'Gómez', '12345678Z', '01234567890', 'Calle Falsa 123', '28080', 'juan.perez@example.com', 'juan.perez@factorrh.es', '912345678', CURRENT_DATE, NULL, 'ES6600190020961234567890', 'BSCHESMMXXX', 2000.00, 0.00, 'pass1234', 'EMP'),
('0002', 'María', 'López', 'Santos', '87654321X', '09876543210', 'Avenida de la Verdad 456', '28081', 'maria.lopez@example.com', 'maria.lopez@factorrh.es', '923456789', CURRENT_DATE, NULL, 'ES6600190020962345678901', 'BBVAESMMXXX', 1500.00, 5.00, 'pass1234', 'EMP'),
('0003', 'Carlos', 'Fernández', 'Martín', '23456789Q', '10293847565', 'Plaza del Sol 78', '28082', 'carlos.fernandez@example.com', 'carlos.fernandez@factorrh.es', '934567890', CURRENT_DATE, NULL, 'ES6600190020963456789012', 'CAIXESBBXXX', 1800.00, 2.00, 'pass1234', 'EMP'),
('0004', 'Lucía', 'García', 'López', '98765432W', '56473829101', 'Paseo de la Esperanza 21', '28083', 'lucia.garcia@example.com', 'lucia.garcia@factorrh.es', '945678901', CURRENT_DATE, NULL, 'ES6600190020964567890123', 'BSABESBBXXX', 1700.00, 3.50, 'pass1234', 'EMP'),
('0005', 'David', 'Martínez', 'García', '34567890E', '10928374655', 'Calle Nueva 12', '28084', 'david.martinez@example.com', 'david.martinez@factorrh.es', '956789012', CURRENT_DATE, NULL, 'ES6600190020965678901234', 'SABADES2XXX', 1600.00, 1.00, 'pass1234', 'RH');


-- INSERT  INTO  users_roles(user_id,role_id) values(1,1);
-- INSERT  INTO  users_roles(user_id,role_id) values(2,1);
-- INSERT  INTO  users_roles(user_id,role_id) values(3,2);
-- INSERT  INTO  users_roles(user_id,role_id) values(4,2);
-- INSERT  INTO  users_roles(user_id,role_id) values(5,3);

-- INSERT INTO roles(id,name)  values(1,'COMPRADOR');
-- INSERT INTO roles(id,name)  values(2,'VENDEDOR');
-- INSERT INTO roles(id,name)  values(3,'VOLUNTARIO');