-- Crear antes: CREATE DATABASE inventario;
-- Luego ejecutar este script conectado a inventario.

DROP TABLE IF EXISTS usuarios CASCADE;
DROP TABLE IF EXISTS productos CASCADE;

CREATE TABLE productos (
    id          BIGSERIAL PRIMARY KEY,
    nombre      VARCHAR(100) NOT NULL,
    categoria   VARCHAR(50)  NOT NULL,
    stock       INTEGER      NOT NULL CHECK (stock >= 0),
    precio      DECIMAL(10, 2) NOT NULL CHECK (precio >= 0.01),
    activo      BOOLEAN      NOT NULL DEFAULT TRUE,
    creado_en   TIMESTAMPTZ  NOT NULL DEFAULT now()
);

CREATE TABLE usuarios (
    id       BIGSERIAL PRIMARY KEY,
    username VARCHAR(50)  NOT NULL UNIQUE,
    password VARCHAR(100) NOT NULL,
    rol      VARCHAR(30)  NOT NULL,
    activo   BOOLEAN      NOT NULL DEFAULT TRUE
);

INSERT INTO productos (id, nombre, categoria, stock, precio, activo, creado_en) VALUES
(1,  'Arroz flor',             'Granos',   120, 0.95, TRUE,  now()),
(2,  'Azucar blanca',          'Granos',    80, 1.10, TRUE,  now()),
(3,  'Aceite vegetal',         'Aceites',   45, 2.50, TRUE,  now()),
(4,  'Leche entera',           'Lacteos',   60, 0.85, TRUE,  now()),
(5,  'Pan de yuca',            'Panaderia', 30, 0.50, TRUE,  now()),
(6,  'Platano verde',          'Verduras', 200, 0.25, TRUE,  now()),
(7,  'Tomate rinon',           'Verduras',  90, 0.40, TRUE,  now()),
(8,  'Pollo entero',           'Carnes',    25, 3.80, TRUE,  now()),
(9,  'Queso fresco',           'Lacteos',   40, 2.20, TRUE,  now()),
(10, 'Cafe molido',            'Bebidas',   55, 4.50, TRUE,  now()),
(11, 'Frijol rojo',            'Granos',    70, 1.30, TRUE,  now()),
(12, 'Producto inactivo demo', 'Otros',      5, 1.00, FALSE, now()),
(13, 'Maiz suave',             'Granos',    40, 0.75, FALSE, now());

SELECT setval(pg_get_serial_sequence('productos', 'id'), (SELECT MAX(id) FROM productos));
