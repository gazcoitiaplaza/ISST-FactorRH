-- Inserción de datos de ejemplo en la tabla Empleado
INSERT INTO empleado (id_empleado, nombre, apellido_1, apellido_2, email, IBAN, password) VALUES
('0001', 'Alvaro', 'Colin', 'Cosano', 'alvaro.colin@factorrh.com', 'ES6600190020961234567890', 'pass1234'),
('0002', 'Guillermo', 'Azcoitia', 'Plaza', 'guillermo.azcoitia@factorrh.com', 'ES6600190020962345678901', 'pass1234'),
('0003', 'Andres', 'Gil', 'Oliva', 'andres.gil@factorrh.com', 'ES6600190020963456789012', 'pass1234'),
('0004', 'Juan', 'Torres', 'Babe', 'juan.torres@factorrh.com', 'ES6600190020964567890123', 'pass1234'),
('0005', 'Alejandro', 'Arrunada', 'Morales', 'alejandro.arrunada@factorrh.com', 'ES6600190020965678901234', 'pass1234');

INSERT INTO authorities (email, authority) VALUES
('alvaro.colin@factorrh.com', 'ROLE_EMP'),
('guillermo.azcoitia@factorrh.com', 'ROLE_EMP'),
('andres.gil@factorrh.com', 'ROLE_EMP'),
('guijuan.torres@factorrh.com', 'ROLE_EMP'),
('alejandro.arrunada@factorrh.com', 'ROLE_RH');


