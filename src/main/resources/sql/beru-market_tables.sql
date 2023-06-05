CREATE TABLE `admin` (
  `id` integer PRIMARY KEY,
  `nombre` varchar(255),
  `correo_electronico` varchar(255),
  `contrasena` varchar(255),
  `fecha_creacion` timestamp
);

CREATE TABLE `clientes` (
  `id` varchar(255) PRIMARY KEY,
  `admin_id` integer,
  `nombre` varchar(255),
  `apellidos` varchar(255),
  `celular` varchar(255),
  `direccion` varchar(255),
  `correo_electronico` varchar(255)
);

CREATE TABLE `compras` (
  `id` integer PRIMARY KEY,
  `id_cliente` varchar(255),
  `fecha` timestamp,
  `medio_pago` varchar(255),
  `comentario` varchar(255),
  `estado` varchar(255)
);

CREATE TABLE `productos` (
  `id` integer PRIMARY KEY,
  `id_categoria` integer,
  `nombre` varchar(255),
  `codigo_barras` varchar(255),
  `precio_venta` integer,
  `cantidad_stock` integer,
  `estado` boolean
);

CREATE TABLE `categorias` (
  `id` integer PRIMARY KEY,
  `descripcion` varchar(255),
  `estado` boolean
);

CREATE TABLE `compras_productos` (
  `id_compra` integer,
  `id_producto` integer,
  `cantidad` integer,
  `total` integer,
  `estado` boolean
);

ALTER TABLE `clientes` ADD FOREIGN KEY (`admin_id`) REFERENCES `admin` (`id`);

ALTER TABLE `compras` ADD FOREIGN KEY (`id`) REFERENCES `clientes` (`id`);

ALTER TABLE `productos` ADD FOREIGN KEY (`id_categoria`) REFERENCES `categorias` (`id`);

ALTER TABLE `compras_productos` ADD FOREIGN KEY (`id_compra`) REFERENCES `productos` (`id`);

ALTER TABLE `compras_productos` ADD FOREIGN KEY (`id_producto`) REFERENCES `compras` (`id`);
