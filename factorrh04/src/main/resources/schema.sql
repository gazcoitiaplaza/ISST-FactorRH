CREATE TABLE IF NOT EXISTS Empleado (
    id_Empleado VARCHAR(4) NOT NULL,
    nombre VARCHAR(40) NOT NULL,
    apellido_1 VARCHAR(40),
    apellido_2 VARCHAR(40),
    email VARCHAR(50),
    IBAN VARCHAR(24),
    password VARCHAR(50),
    
    PRIMARY KEY (id_Empleado)
);

CREATE TABLE IF NOT EXISTS authorities (
    id_Empleado VARCHAR(4) NOT NULL,
    puesto VARCHAR(10),
    CONSTRAINT fk_authorities_Empleado FOREIGN KEY(id_Empleado) REFERENCES Empleado(id_Empleado)
);
