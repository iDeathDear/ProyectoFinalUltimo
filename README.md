# 🖥️ Sistema de Gestión de Ventas - NOVOX

Este proyecto consiste en el desarrollo de un *Sistema de Gestión de Registro de Ventas* para la empresa *NOVOX S.A.C, dedicada a la comercialización de dispositivos tecnológicos. Fue desarrollado como parte del curso **Integrador I* de la carrera de Ingeniería de Software.

## 📌 Objetivos

- Automatizar el proceso de ventas.
- Registrar productos, controlar stock y gestionar usuarios.
- Simplificar la gestión del inventario.
- Generar reportes de ventas y reducir errores manuales.

---

## ⚙️ Tecnologías y Herramientas

- *Java 17*
- *NetBeans IDE*
- *Swing (Interfaz gráfica)*
- *MySQL*
- *JDBC (Java Database Connectivity)*
- *FlatLaf* para estilos visuales modernos.
- *Patrón DAO (Data Access Object)* para acceso a base de datos.
- *MVC + Principios SOLID*
- Git + GitHub para control de versiones

---

## 🧱 Estructura del Proyecto

ProyectoFinal/
│
├── src/
│   ├── conexion/           # Clase Conexion.java (gestión conexión a MySQL)
│   ├── dao/                # Interfaces DAO
│   ├── dao/impl/           # Implementaciones DAOImpl
│   ├── datos/              # Clases de entidad (Producto, Usuario, Venta, etc.)
│   ├── controlador/        # Controladores (Ctrl_Producto, Ctrl_Venta, etc.)
│   └── vista/              # Interfaces gráficas (JDProducto, JDVenta, etc.)
│
├── bd/novox.sql            # Script de creación de base de datos
└── README.md               # Documentación del proyecto

---

## 📋 Módulos Implementados

### ✅ Gestión de Usuarios
- Registro y autenticación.
- Validaciones (DNI solo números y 8 dígitos, celular 9 dígitos, clave oculta).
- Interfaz Registrar.java y GestionarUsuario.java.

### ✅ Gestión de Productos
- Registro, búsqueda, edición y eliminación de productos.
- Campos: modelo, marca, almacenamiento, color, precio.
- Sin campos de stock ni descripción.
- Conectado al DAO mediante Ctrl_Producto y ProductoDAOImpl.

### ✅ Gestión de Stock
- Vista JDStock.
- Permite agregar stock a un producto ya registrado.
- Consulta mediante combinación de modelo, marca, almacenamiento, color.
- DAO: StockDAO y StockDAOImpl.

### ✅ Registro de Ventas
- Vista JDVenta.
- Registro de ventas sin cliente por ahora.
- ComboBox para seleccionar producto por atributos.
- Validación de stock disponible antes de añadir al carrito.
- Registro de venta y detalle_venta en la base de datos.
- DAO: VentaDAO, DetalleVentaDAO, DetalleVentaDAOImpl.

---

## 🧠 Patrones y Principios Aplicados

- *DAO*: Aisla la lógica de persistencia de la lógica de negocio.
- *MVC*: Separación clara entre vistas (vista), controladores (controlador) y modelo (datos).
- *SOLID*: Especialización de responsabilidades por clase.
- *Clean Code*: Métodos pequeños, claros y nombrados con intención.

---

## 🗃️ Base de Datos

- MySQL con las siguientes tablas principales:
  - usuario
  - producto
  - stock
  - venta
  - detalle_venta

Incluye claves foráneas entre venta y detalle_venta, y relación entre producto y stock.

---

## 🚀 Instrucciones para Ejecutar

1. *Clonar el repositorio*
   ```bash
   git clone https://github.com/tuusuario/ProyectoFinalNOVOX.git

	2.	Importar en NetBeans
	•	Abrir NetBeans
	•	File > Open Project > Seleccionar la carpeta ProyectoFinal
	3.	Configurar Base de Datos
	•	Crear la base de datos novox desde el archivo bd/novox.sql
	•	Asegurarse de que los credenciales en la clase Conexion.java coincidan
	4.	Ejecutar el proyecto
	•	Ejecutar la clase Menu.java o Login.java

⸻

📌 Estado del Proyecto

✅ Usuarios
✅ Productos
✅ Stock
✅ Ventas sin cliente
✅ Validación de stock
🔜 Módulo de clientes
🔜 Reportes y dashboard

⸻![Uploading image.png…]()


✍️ Autores
	•	Diego Quispe Ramírez
	•	Proyecto académico para la Universidad

⸻

📄 Licencia

Este proyecto fue desarrollado con fines educativos. No se autoriza su uso con fines comerciales sin permiso.
