CREATE TABLE AUSENCIAS (
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    nombre_usuario VARCHAR(50),
    fecha_inicio DATE,
    fecha_fin DATE,
    tipo_ausencia VARCHAR(50),
    autorizada BOOLEAN,
    notas TEXT
);
