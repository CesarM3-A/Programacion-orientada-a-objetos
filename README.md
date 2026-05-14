# Sistema de Biblioteca - POO

## Descripción del Proyecto

El presente proyecto consiste en el desarrollo de un sistema de gestión de biblioteca utilizando Programación Orientada a Objetos (POO) en Java.

El sistema permite administrar:

- Registro de libros
- Registro de usuarios
- Préstamos de libros
- Devoluciones
- Validación de cédula ecuatoriana
- Control de multas
- Búsqueda de libros por título y género
- Reportes finales de usuarios

El proyecto fue desarrollado aplicando conceptos fundamentales de Programación Orientada a Objetos como:

- Clases y objetos
- Encapsulamiento
- Herencia
- Abstracción
- Polimorfismo
- Métodos
- Arreglos
- ArrayList
- Condicionales
- Ciclos repetitivos

---

# Integrantes del Proyecto

- Mateo Josue Valdivieso Tapia — Líder de Desarrollo
- Jean Paul Aguilar Morocho — Diseñador
- César Mateo Arias Briceño — Control de Calidad

---

# Tecnologías Utilizadas

- Java
- NetBeans
- GitHub

---

# Estructura del Proyecto

```plaintext
ProyectoBiblioPOO/
│
├── src/
│   └── proyectobibliopoo/
│       ├── Principal.java
│       ├── Biblioteca.java
│       ├── Libro.java
│       ├── Usuario.java
│       ├── Persona.java
│       ├── Prestamo.java
│       └── ValidacionCedula.java
│
├── README.md
│
└── .gitignore
```

---

# Explicación de las Clases

## Principal.java

Clase principal encargada de controlar toda la ejecución del sistema.

### Funciones principales
- Crear la biblioteca
- Registrar libros
- Registrar usuarios
- Validar cédulas
- Realizar préstamos
- Registrar devoluciones
- Buscar libros por género
- Generar reportes finales

### Procesos realizados
1. Registro de 8 libros
2. Registro de 3 usuarios
3. Validación de cédula
4. Realización de 5 préstamos
5. Registro de devoluciones
6. Búsqueda por género
7. Generación de reportes

---

## Biblioteca.java

Clase encargada de administrar toda la lógica del sistema.

### Funciones principales
- Registrar libros
- Registrar usuarios
- Mostrar libros disponibles
- Buscar libros por título
- Buscar libros por género
- Realizar préstamos
- Generar reportes
- Obtener préstamos activos

### Estructuras utilizadas

#### Arreglo de libros

```java
private Libro[] catalogo = new Libro[20];
```

#### Listas dinámicas

```java
private ArrayList<Usuario> listaUsuarios = new ArrayList<>();
private ArrayList<Prestamo> listaPrestamos = new ArrayList<>();
```

### Funciones implementadas

```java
registrarLibro()
registrarUsuario()
mostrarLibrosDisponibles()
buscarPorTitulo()
buscarPorGenero()
realizarPrestamo()
generarReporte()
obtenerPrestamoActivo()
```

---

# Libro.java

Clase que representa un libro dentro de la biblioteca.

### Atributos

```java
private String titulo;
private String autor;
private String genero;
private boolean disponible;
```

### Funciones
- Verificar disponibilidad
- Registrar préstamo
- Registrar devolución
- Mostrar información del libro

### Métodos implementados

```java
estaDisponible()
prestar()
devolver()
getTitulo()
getGenero()
toString()
```

---

# Persona.java

Clase abstracta utilizada como base para la clase Usuario.

### Conceptos aplicados
- Abstracción
- Herencia
- Polimorfismo

### Atributos

```java
protected String nombre;
protected String apellido;
protected String cedula;
```

### Método abstracto

```java
public abstract void mostrarInformacion();
```

---

# Usuario.java

Clase que representa a los usuarios registrados.

La clase hereda de `Persona`.

### Funciones principales
- Controlar préstamos
- Controlar multas
- Validar cantidad máxima de libros
- Mostrar información del usuario

### Restricciones implementadas
- Máximo 3 libros prestados
- Usuarios con multa no pueden solicitar libros

### Métodos implementados

```java
puedePedirLibro()
incrementarLibros()
decrementarLibros()
setMulta()
getMontoMulta()
mostrarInformacion()
isMultaPendiente()
getLibrosPrestados()
getNombreCompleto()
```

---

# Prestamo.java

Clase encargada de gestionar préstamos y devoluciones.

### Funciones
- Registrar préstamos
- Calcular multas
- Cerrar préstamos
- Controlar préstamos activos

### Regla implementada

Si el préstamo supera los 7 días:
- se genera una multa de $0.50 por cada día extra.

### Ejemplo

```java
if (diasPrestado > 7) {
    return (diasPrestado - 7) * 0.50;
}
```

### Métodos implementados

```java
calcularMulta()
cerrarPrestamo()
getLibro()
getUsuario()
isActivo()
```

---

# ValidacionCedula.java

Clase encargada de validar la cédula ecuatoriana.

### Validaciones implementadas
- Longitud de 10 dígitos
- Código de provincia válido
- Tercer dígito permitido
- Algoritmo oficial ecuatoriano
- Verificación del dígito comprobador

### Método principal

```java
validarCedula(String cedula);
```

### Proceso de validación

1. Verificar longitud
2. Validar provincia
3. Validar tercer dígito
4. Aplicar coeficientes
5. Calcular suma
6. Obtener dígito verificador
7. Comparar resultados

---

# Funcionalidades del Sistema

## Gestión de Libros
- Registrar libros
- Mostrar libros disponibles
- Buscar libros por título
- Buscar libros por género

## Gestión de Usuarios
- Registrar usuarios
- Validar cédula ecuatoriana
- Mostrar información

## Gestión de Préstamos
- Realizar préstamos
- Registrar devoluciones
- Controlar disponibilidad
- Calcular multas

## Reportes
- Reporte final de usuarios
- Estado de multas
- Cantidad de libros prestados

---

# Flujo del Sistema

```plaintext
Inicio del Sistema
        ↓
Registro de Libros
        ↓
Registro de Usuarios
        ↓
Validación de Cédula
        ↓
Préstamos
        ↓
Devoluciones
        ↓
Búsquedas
        ↓
Reporte Final
```

---

# Conceptos de POO Aplicados

| Concepto | Aplicación |
|---|---|
| Encapsulamiento | Uso de atributos private |
| Herencia | Usuario hereda de Persona |
| Abstracción | Clase abstracta Persona |
| Polimorfismo | Método mostrarInformacion() |
| Objetos | Libros, usuarios y préstamos |
| Métodos | Gestión del sistema |
| Arreglos | Catálogo de libros |
| ArrayList | Usuarios y préstamos |

---

# Diagrama UML

<img width="1600" height="944" alt="1" src="https://github.com/user-attachments/assets/012f21b8-5127-4baa-ae68-2ce8edd41724" />

---

# Distribución del Trabajo

## Mateo Josue Valdivieso Tapia
- Desarrollo principal del sistema
- Integración de clases
- Lógica general

## Jean Paul Aguilar Morocho
- Diseño del proyecto
- Interfaz en consola
- Organización visual

## César Mateo Arias Briceño
- Validaciones
- Control de calidad
- Pruebas del sistema
- Verificación de errores
  
---

# Objetivo Académico

El objetivo de este proyecto es fortalecer el aprendizaje de Programación Orientada a Objetos mediante la implementación de un sistema funcional que utilice clases, herencia, arreglos, listas dinámicas, validaciones y control de procesos.

---
# Realizamos la revision al grupo 1:

No tuvo errores
