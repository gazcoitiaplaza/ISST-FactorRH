CREATE TABLE VACACIONES (
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    nombre_usuario VARCHAR(50),
    fecha_inicio DATE,
    fecha_fin DATE,
    autorizada BOOLEAN,
    notas TEXT
);
