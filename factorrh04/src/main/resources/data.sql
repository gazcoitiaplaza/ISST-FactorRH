-- Inserción de datos de ejemplo en la tabla Empleado
INSERT INTO Empleado (id_Empleado, nombre, apellido_1, apellido_2, email, IBAN, password) VALUES
('0001', 'Alvaro', 'Colin', 'Cosano', 'juan.perez@example.com', 'ES6600190020961234567890', 'pass1234'),
('0002', 'Guillermo', 'Azcoitia', 'Plaza', 'maria.lopez@example.com', 'ES6600190020962345678901', 'pass1234'),
('0003', 'Andres', 'Gil', 'Oliva', 'carlos.fernandez@example.com', 'ES6600190020963456789012', 'pass1234'),
('0004', 'Juan', 'Torres', 'Babe', 'lucia.garcia@example.com', 'ES6600190020964567890123', 'pass1234'),
('0005', 'David', 'Martinez', 'Garcia', 'david.martinez@example.com', 'ES6600190020965678901234', 'pass1234');

INSERT INTO authorities (id_Empleado, puesto) VALUES
('0001', 'ROLE_EMP'),
('0002', 'ROLE_EMP'),
('0003', 'ROLE_EMP'),
('0004', 'ROLE_EMP'),
('0005', 'ROLE_RH');
