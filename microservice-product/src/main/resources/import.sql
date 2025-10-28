-- ===============================================
-- INSERCIÓN DE CATEGORÍAS
-- ===============================================

INSERT INTO category (name) VALUES
            ('Electrónica'),
            ('Hogar y Cocina'),
            ('Ropa y Accesorios'),
            ('Videojuegos'),
            ('Libros');

-- ===============================================
-- INSERCIÓN DE PRODUCTOS
-- ===============================================

INSERT INTO product (name, description, stock, price, category_id) VALUES
            ('Smartphone Samsung A54', 'Teléfono Android de 6.6" con cámara de 50MP y batería de 5000mAh', 25, 329.99, 1),
            ('Laptop Lenovo IdeaPad 3', 'Portátil con Intel i5, 8GB RAM, SSD 512GB y pantalla FHD de 15.6"', 12, 589.99, 1),
            ('Audífonos Bluetooth JBL Tune 510BT', 'Auriculares inalámbricos con hasta 40 horas de batería', 40, 49.99, 1),

            ('Freidora de aire Philips', 'Freidora sin aceite con capacidad de 4.1 litros', 18, 139.90, 2),
            ('Set de cuchillos Tramontina', 'Juego de 6 cuchillos de acero inoxidable con mango ergonómico', 30, 45.50, 2),

            ('Camisa Casual Hombre', 'Camisa manga larga de algodón, color azul', 50, 25.00, 3),
            ('Pantalón Jeans Mujer Levi’s', 'Jeans skinny de mezclilla con elasticidad', 35, 59.99, 3),

            ('Control PS5 DualSense', 'Mando inalámbrico original para PlayStation 5', 22, 69.99, 4),
            ('Juego The Witcher 3 (PS5)', 'Edición completa con expansiones y mejoras gráficas', 15, 49.90, 4),

            ('Libro "Clean Code"', 'Guía sobre buenas prácticas de programación de Robert C. Martin', 28, 34.99, 5);
