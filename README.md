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

_______
   DIAGRAMAS

   Diagramas BPMN
   
   <img width="1245" height="572" alt="image" src="https://github.com/user-attachments/assets/38911a4c-6836-4077-bbc2-fd1e5d19fb3a" />

   
   Diagrama Casos de Uso 
   
   <img width="600" height="688" alt="image" src="https://github.com/user-attachments/assets/6005ef3c-429b-45bf-90a4-049c76f2fa08" />

   
   Diagrama ER
   
   <img width="1190" height="782" alt="DER" src="https://github.com/user-attachments/assets/e0e2508a-457a-43b2-959c-454bce63d82a" />


   Diagrama Logico
   
   <img width="820" height="742" alt="DLOGICO" src="https://github.com/user-attachments/assets/db4d4ba5-b240-4296-acad-09ba91ad63f3" />

   
   Diagrama de Gantt

   <img width="965" height="403" alt="image" src="https://github.com/user-attachments/assets/75d39370-e96b-4767-973e-99cb8f1e27a5" />

   <img width="1487" height="236" alt="image" src="https://github.com/user-attachments/assets/efa291c2-4af1-422f-9da5-aefc6e08bc1e" />

   <img width="937" height="140" alt="image" src="https://github.com/user-attachments/assets/df421879-bf4c-48c2-a7a3-5fd652ef3a66" />

   <img width="1328" height="223" alt="image" src="https://github.com/user-attachments/assets/79df7ba5-7f0d-49b6-afbc-2746ff60b61a" />

   
   Capturas del Aplicativo
   LOGIN
   
   <img width="1332" height="852" alt="image" src="https://github.com/user-attachments/assets/cb2dcd7e-18c4-419a-8803-a3a63883bc6b" />
   
   MENU PRINCIPAL
   
   <img width="1156" height="710" alt="image" src="https://github.com/user-attachments/assets/cfb013d0-bc25-48bf-b129-639a9d8795a7" />

   
   GESTIONAR USUARIOS
   
   <img width="1155" height="808" alt="image" src="https://github.com/user-attachments/assets/04b5318d-165b-452b-936c-e45f9f9a6cf4" />


   VENTAS
   
   <img width="992" height="856" alt="image" src="https://github.com/user-attachments/assets/6f18e18b-5438-4926-8c84-ca38f6a016d1" />


   STOCK

   <img width="1118" height="806" alt="image" src="https://github.com/user-attachments/assets/b02252aa-67fa-4174-8d02-2c4de9566d3b" />



✍️ Autores

	•	Diego Quispe Ramírez
        •       Jorge Quispe Villarroel
	•	Jhonatan Ochante Ricapa
	•	Proyecto académico para la Universidad

⸻

📄 Licencia

Este proyecto fue desarrollado con fines educativos. No se autoriza su uso con fines comerciales sin permiso.
