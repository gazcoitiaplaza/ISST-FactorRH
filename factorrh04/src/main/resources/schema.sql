CREATE TABLE IF NOT EXISTS Empleado (
    id_Empleado VARCHAR(4) NOT NULL,
    nombre VARCHAR(40) NOT NULL,
    apellido_1 VARCHAR(40),
    apellido_2 VARCHAR(40),
    email VARCHAR(50),
    IBAN VARCHAR(24),
    password VARCHAR(50),
    puesto VARCHAR(5),
    PRIMARY KEY (id_Empleado)
);
