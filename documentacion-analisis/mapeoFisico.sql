CREATE DATABASE coden_bugs;

CREATE USER 'usuario'@'localhost' IDENTIFIED BY 'ConTr@.34';

GRANT ALL PRIVILEGES ON coden_bugs.* TO 'usuario'@'localhost';

USE coden_bugs;

CREATE TABLE mueble (
    nombre_mueble VARCHAR(45) NOT NULL PRIMARY KEY,
    precio DECIMAL(7,3) NOT NULL
);

CREATE TABLE pieza (
    tipo_pieza VARCHAR(40) NOT NULL,
    precio DECIMAL(7,3) NOT NULL,
    cantidad INT DEFAULT 1,
    PRIMARY KEY(tipo_pieza, precio)
);

CREATE TABLE ensamble_pieza (
    nombre_mueble VARCHAR(45) NOT NULL,
    tipo_pieza VARCHAR(40) NOT NULL,
    cantidad_pieza INT DEFAULT 1,
    PRIMARY KEY(nombre_mueble, tipo_pieza),
    CONSTRAINT nombre_mueble_fk FOREIGN KEY (nombre_mueble)
    REFERENCES mueble(nombre_mueble),
    CONSTRAINT tipo_pieza_fk FOREIGN KEY (tipo_pieza)
    REFERENCES pieza(tipo_pieza)
);

CREATE TABLE usuario (
    nombre_usuario VARCHAR(45) NOT NULL PRIMARY KEY,
    password VARCHAR(40) NOT NULL,
    tipo ENUM('Fábrica','punto de venta','financiero', 'cancelado') NOT NULL
);

INSERT INTO usuario (nombre_usuario, password, tipo) VALUES ('jgranados','miPassword','financiero');

CREATE TABLE mueble_ensamblado (
    identificador_unico VARCHAR(45) NOT NULL PRIMARY KEY,
    nombre_mueble VARCHAR(45) NOT NULL,
    usuario_ensamblo VARCHAR(45) NOT NULL,
    fecha_ensamble DATE NOT NULL,
    costo DECIMAL(7,3) NOT NULL,
    estado ENUM('ensamblado','vendido','devuelto') NOT NULL,
    CONSTRAINT nombre_mueble_ensamblado_fk FOREIGN KEY (nombre_mueble)
    REFERENCES mueble(nombre_mueble),
    CONSTRAINT usuario_ensamblo_fk FOREIGN KEY (usuario_ensamblo)
    REFERENCES usuario(nombre_usuario)
);

CREATE TABLE cliente (
    nit VARCHAR(45) NOT NULL PRIMARY KEY,
    nombre VARCHAR(45) DEFAULT '',
    direccion VARCHAR(45) DEFAULT '---',
    departamento VARCHAR(40) DEFAULT '',
    municipio VARCHAR(40) DEFAULT ''
);

CREATE TABLE compra (
    registro_compra INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    nombre_usuario VARCHAR(45) NOT NULL,
    identificador_mueble VARCHAR(45) NOT NULL,
    nit VARCHAR(45) DEFAULT 'CF',
    fecha_compra DATE NOT NULL,
    total DECIMAL (7,3) NOT NULL,
    CONSTRAINT nombre_usuario_fk FOREIGN KEY (nombre_usuario)
    REFERENCES usuario(nombre_usuario),
    CONSTRAINT identificador_compra_fk FOREIGN KEY (identificador_mueble)
    REFERENCES mueble_ensamblado(identificador_unico)
);

CREATE TABLE devolucion (
    registro_devolucion INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    nit VARCHAR(45) NOT NULL,
    identificador_mueble VARCHAR(45) NOT NULL,
    fecha_devolucion DATE NOT NULL,
    perdida DECIMAL (7,3) NOT NULL,
    CONSTRAINT identificador_devolucion_fk FOREIGN KEY (identificador_mueble)
    REFERENCES mueble_ensamblado(identificador_unico)
);

CREATE TABLE caja (
	registro_caja INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    nombre_usuario VARCHAR(45) NOT NULL,
	identificador_mueble VARCHAR(45) NOT NULL,
    fecha_registro DATE NOT NULL,
	tipo_registro ENUM('ganancia','perdida') NOT NULL,
	ganancia DECIMAL(7,3) DEFAULT 0,
	perdida DECIMAL(7,3) DEFAULT 0,
	CONSTRAINT identificador_mueble_fk FOREIGN KEY(identificador_mueble)
    REFERENCES mueble_ensamblado(identificador_unico)
);
