CREATE TABLE IF NOT EXISTS empleado (
    id_empleado VARCHAR(2) NOT NULL,
    nombre VARCHAR(40) NOT NULL,
    apellido1 VARCHAR(40),
    apellido2 VARCHAR(40),
    email VARCHAR(50) NOT NULL PRIMARY KEY,
    IBAN VARCHAR(24),
    password VARCHAR(50) NOT NULL,
    
    PRIMARY KEY (id_Empleado)
);

CREATE TABLE IF NOT EXISTS authorities (
    email VARCHAR(50) NOT NULL,
    authority VARCHAR(50),
    CONSTRAINT fk_authorities_empleado FOREIGN KEY(email) REFERENCES empleado(email)
);
