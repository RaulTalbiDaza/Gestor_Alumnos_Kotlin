# UD01_Actividad09_GestorAlumnos

Aplicación de consola desarrollada en **Kotlin** para gestionar la información básica del alumnado de un grupo: registrar estudiantes, almacenar sus notas, calcular la media del grupo y filtrar el alumnado aprobado y suspenso.

- **Módulo:** PMDM (Programación Multimedia y Dispositivos Móviles)
- **Unidad:** UD01. Introducción
- **Actividad:** 09. Gestor de alumnos en Kotlin
- **Autor/a:** *Raúl Talbi Daza*

## Requisitos

- IntelliJ IDEA (Community o Ultimate)
- JDK 17 o superior
- Kotlin (incluido en IntelliJ IDEA)

## Estructura del proyecto

```
UD01_Actividad09_GestorAlumnos/
├── src/
│   └── main/
│         ├── Alumno.kt   # data class Alumno y sus métodos
│         └── Main.kt     # menú principal y funciones de la aplicación
└── README.md
```

## Ejecución

1. Clonar o descomprimir el proyecto.
2. Abrirlo con IntelliJ IDEA.
3. Ejecutar la función `main` del archivo `Main.kt` con el botón ▶.

## Funcionalidades

Al iniciar, el programa muestra el siguiente menú, que se repite hasta elegir la opción 8:

```
===== GESTOR DE ALUMNOS =====
1. Registrar alumno
2. Listar alumnos
3. Calcular media del grupo
4. Mostrar aprobados
5. Mostrar suspensos
6. Buscar alumno
7. Eliminar alumno
8. Salir
Seleccione una opción:
```

| Opción | Descripción |
|--------|-------------|
| 1. Registrar alumno | Pide nombre, apellidos y nota final (0-10) y añade el alumno a la lista. |
| 2. Listar alumnos | Muestra todos los alumnos numerados con su nota. |
| 3. Calcular media | Calcula la media de las notas del grupo. |
| 4. Mostrar aprobados | Lista los alumnos con nota igual o superior a 5. |
| 5. Mostrar suspensos | Lista los alumnos con nota inferior a 5. |
| 6. Buscar alumno | Busca por nombre o apellidos, con coincidencias parciales y sin distinguir mayúsculas. |
| 7. Eliminar alumno | Muestra la lista y elimina el alumno cuyo número se indique. |
| 8. Salir | Finaliza el programa. |

## Diseño

### `Alumno.kt`

`data class Alumno(nombre, apellidos, nota)` con los siguientes métodos:

- `nombreCompleto()`: devuelve nombre y apellidos.
- `descripcion()`: texto con el formato `Ana García López - Nota: 8.5`.
- `esAprobado()` / `esSuspenso()`: comparan la nota con `NOTA_APROBADO` (5.0).
- `coincideCon(texto)`: comprueba si el texto aparece en el nombre o en los apellidos.

### `Main.kt`

Los alumnos se almacenan en una `MutableList<Alumno>`. El código se organiza en funciones:

- `mostrarMenu()`
- `registrarAlumno(alumnos: MutableList<Alumno>)`
- `listarAlumnos(alumnos: List<Alumno>)`
- `calcularMedia(alumnos: List<Alumno>): Double`
- `mostrarAprobados(alumnos: List<Alumno>)`
- `mostrarSuspensos(alumnos: List<Alumno>)`
- `buscarAlumno(alumnos: List<Alumno>)`
- `eliminarAlumno(alumnos: MutableList<Alumno>)`

## Validaciones

- Opción de menú no válida (letras, números fuera de rango o entrada vacía).
- Nombre o apellidos vacíos.
- Nota no numérica, inferior a 0 o superior a 10 (se admite coma o punto decimal).
- Cálculo de la media con la lista vacía.
- Búsqueda vacía o sin resultados.
- Eliminación con un número inexistente o con la lista vacía.
- Mensajes específicos cuando no hay aprobados o suspensos.

## Pruebas realizadas

| Prueba | Resultado esperado |
|--------|--------------------|
| Registrar alumno con datos válidos | "Alumno registrado correctamente." |
| Registrar con nombre vacío | Mensaje de error y no se añade |
| Registrar con nota 11 o -1 | "La nota debe estar entre 0 y 10." |
| Registrar con nota "abc" | "La nota debe ser un valor numérico." |
| Listar con lista vacía | "No hay alumnos registrados." |
| Media con lista vacía | Mensaje de aviso, sin calcular |
| Media con varios alumnos | Media correcta con dos decimales |
| Aprobados / suspensos | Cada alumno aparece en el listado que le corresponde |
| Buscar "gar" | Encuentra "García" |
| Buscar texto inexistente | "No se han encontrado alumnos con ese criterio." |
| Eliminar número válido | "Alumno eliminado correctamente." |
| Eliminar número inexistente | "Número no válido. El alumno no existe." |
| Opción 9 o texto en el menú | "Opción no válida." |
| Opción 8 | El programa termina |

