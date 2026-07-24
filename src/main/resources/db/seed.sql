INSERT INTO productos (nombre, categoria, stock, precio, activo)
SELECT v.nombre, v.categoria, v.stock, v.precio, v.activo
FROM (VALUES
    ('Arroz flor', 'Granos', 120, 0.95::numeric, TRUE),
    ('Azucar blanca', 'Granos', 80, 1.10::numeric, TRUE),
    ('Aceite vegetal', 'Aceites', 45, 2.50::numeric, TRUE),
    ('Leche entera', 'Lacteos', 60, 0.85::numeric, TRUE),
    ('Pan de yuca', 'Panaderia', 30, 0.50::numeric, TRUE),
    ('Platano verde', 'Verduras', 200, 0.25::numeric, TRUE),
    ('Tomate rinon', 'Verduras', 90, 0.40::numeric, TRUE),
    ('Pollo entero', 'Carnes', 25, 3.80::numeric, TRUE),
    ('Queso fresco', 'Lacteos', 40, 2.20::numeric, TRUE),
    ('Cafe molido', 'Bebidas', 55, 4.50::numeric, TRUE),
    ('Frijol rojo', 'Granos', 70, 1.30::numeric, TRUE),
    ('Producto inactivo demo', 'Otros', 5, 1.00::numeric, FALSE)
) AS v(nombre, categoria, stock, precio, activo)
WHERE NOT EXISTS (SELECT 1 FROM productos LIMIT 1);

INSERT INTO usuarios (username, password, rol, activo)
SELECT 'user', '$2b$10$0wq86GLRYM4wDnVPV62Tu.pi7tdMWE8cusqU1XXNtKpsNIdD.7N8S', 'ROLE_USER', TRUE
WHERE NOT EXISTS (SELECT 1 FROM usuarios WHERE username = 'user');

INSERT INTO usuarios (username, password, rol, activo)
SELECT 'admin', '$2b$10$oqVIdgKmP3HaqIvTXUkMnuFE07F5DHi0iCe6ulh2kzKQfYteSNEDu', 'ROLE_ADMIN', TRUE
WHERE NOT EXISTS (SELECT 1 FROM usuarios WHERE username = 'admin');
