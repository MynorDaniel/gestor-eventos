-- Esquema

CREATE DATABASE gestor_eventos;

USE gestor_eventos;

-- Tabla participante

CREATE TABLE participante (
    correo VARCHAR(320),
    nombre VARCHAR(45) NOT NULL,
    tipo ENUM('ESTUDIANTE', 'PROFESIONAL', 'INVITADO') NOT NULL,
    institucion VARCHAR(150) NOT NULL,
    PRIMARY KEY (correo)
);

-- Tabla evento

CREATE TABLE evento (
    codigo VARCHAR(15),
    ubicacion VARCHAR(150) NOT NULL,
    cupo_maximo INT NOT NULL,
    titulo VARCHAR(200) NOT NULL,
    tipo ENUM('CHARLA', 'CONGRESO', 'TALLER', 'DEBATE') NOT NULL,
    fecha DATE NOT NULL,
    precio DOUBLE DEFAULT 0.00,
    PRIMARY KEY (codigo)
);

-- Tabla inscripcion

CREATE TABLE inscripcion (
    codigo_evento VARCHAR(15),
    correo_participante VARCHAR(320),
    tipo ENUM('ASISTENTE', 'CONFERENCISTA', 'TALLERISTA', 'OTRO') NOT NULL,
    confirmada BOOL DEFAULT 0 NOT NULL,
    PRIMARY KEY (codigo_evento, correo_participante),
    CONSTRAINT fk_evento_inscripcion FOREIGN KEY (codigo_evento) REFERENCES evento (codigo),
    CONSTRAINT fk_participante_inscripcion FOREIGN KEY (correo_participante) REFERENCES participante (correo)
);

-- Tabla pago

CREATE TABLE pago (
    codigo_evento VARCHAR(15),
    correo_participante VARCHAR(320),
    monto DOUBLE NOT NULL,
    metodo_pago ENUM('EFECTIVO', 'TRANSFERENCIA', 'TARJETA') NOT NULL,
    PRIMARY KEY (codigo_evento, correo_participante),
    CONSTRAINT fk_inscripcion_pago FOREIGN KEY (codigo_evento, correo_participante) REFERENCES inscripcion (codigo_evento, correo_participante)
);

-- Tabla actividad

CREATE TABLE actividad (
    codigo VARCHAR(15),
    correo_impartidor VARCHAR(320),
    codigo_evento VARCHAR(15),
    hora_inicio TIME NOT NULL,
    hora_fin TIME NOT NULL,
    cupo_maximo INT NOT NULL,
    tipo ENUM('CHARLA', 'TALLER', 'DEBATE', 'OTRA') NOT NULL,
    titulo VARCHAR(200) NOT NULL,
    PRIMARY KEY (codigo),
    CONSTRAINT fk_participante_actividad FOREIGN KEY (correo_impartidor) REFERENCES participante (correo),
    CONSTRAINT fk_evento_actividad FOREIGN KEY (codigo_evento) REFERENCES evento (codigo)
);

-- Tabla asistencia

CREATE TABLE asistencia (
    codigo_actividad VARCHAR(15),
    correo_participante VARCHAR(320),
    PRIMARY KEY (codigo_actividad, correo_participante),
    CONSTRAINT fk_actividad_asistencia FOREIGN KEY (codigo_actividad) REFERENCES actividad (codigo),
    CONSTRAINT fk_participante_asistencia FOREIGN KEY (correo_participante) REFERENCES participante (correo)
);












