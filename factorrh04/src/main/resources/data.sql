--Creación de la base de datos de usuarios
INSERT INTO EMPLEADO (id_Empleado, nombre, apellido_1, apellido_2, email, IBAN, password, puesto) VALUES
('01', 'Juan', 'Pérez', 'Gómez', 'juan.perez@factorrh.es', 'ES6600190020961234567890', 'pass1234', 'EMP'),
('02', 'María', 'López', 'Santos', 'maria.lopez@factorrh.es', 'ES6600190020962345678901', 'pass1234', 'EMP'),
('03', 'Carlos', 'Fernández', 'Martín', 'carlos.fernandez@factorrh.es', 'ES6600190020963456789012', 'pass1234', 'EMP'),
('04', 'Lucía', 'García', 'López', 'lucia.garcia@factorrh.es', 'ES6600190020964567890123', 'pass1234', 'EMP'),
('05', 'David', 'Martínez', 'García', 'david.martinez@factorrh.es', 'ES6600190020965678901234', 'pass1234', 'RH');


-- INSERT  INTO  users_roles(user_id,role_id) values(1,1);
-- INSERT  INTO  users_roles(user_id,role_id) values(2,1);
-- INSERT  INTO  users_roles(user_id,role_id) values(3,2);
-- INSERT  INTO  users_roles(user_id,role_id) values(4,2);
-- INSERT  INTO  users_roles(user_id,role_id) values(5,3);

-- INSERT INTO roles(id,name)  values(1,'COMPRADOR');
-- INSERT INTO roles(id,name)  values(2,'VENDEDOR');
-- INSERT INTO roles(id,name)  values(3,'VOLUNTARIO');