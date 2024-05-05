CREATE TABLE VACACIONES (
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    nombre_usuario VARCHAR(50),
    fecha_inicio DATE,
    fecha_fin DATE,
    tipo_vacaciones VARCHAR(50),
    autorizada BOOLEAN,
    notas TEXT
);
