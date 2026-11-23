// Main.kt
// UD01_Actividad09_GestorAlumnos - Gestor de alumnos de consola en Kotlin

fun main() {
    // Lista mutable donde se guardan todos los alumnos
    val alumnos = mutableListOf<Alumno>()
    var opcion: Int? = null

    fun mostrarMenu() {
        println("===== GESTOR DE ALUMNOS =====")
        println("0. Salir")
        println("1. Registrar alumno")
        println("2. Listar alumnos")
        println("3. Calcular media del grupo")
        println("4. Mostrar aprobados")
        println("5. Mostrar suspensos")
        println("6. Buscar alumno")
        println("7. Eliminar alumno")
        print("Seleccione una opción: ")
    }

    // Fase 4: registro con validaciones
    fun registrarAlumno(alumnos: MutableList<Alumno>) {
        print("Introduce el nombre: ")
        val nombre = readLine()?.trim().orEmpty()
        if (nombre.isEmpty()) {
            println("El nombre no puede estar vacío.")
            return
        }

        print("Introduce los apellidos: ")
        val apellidos = readLine()?.trim().orEmpty()
        if (apellidos.isEmpty()) {
            println("Los apellidos no pueden estar vacíos.")
            return
        }

        print("Introduce la nota final: ")
        // Se acepta coma o punto como separador decimal
        val nota = readLine()?.trim()?.replace(',', '.')?.toDoubleOrNull()
        if (nota == null) {
            println("La nota debe ser un valor numérico.")
            return
        }
        if (nota < 0.0 || nota > 10.0) {
            println("La nota debe estar entre 0 y 10.")
            return
        }
    }

    // Fase 5: listado numerado
    fun listarAlumnos(alumnos: List<Alumno>) {
        if (alumnos.isEmpty()) {
            println("No hay alumnos registrados.")
            return
        }
        alumnos.forEachIndexed { indice, alumno ->
            println("${indice + 1}. ${alumno.descripcion()}")
        }
    }

    // Fase 6: media de todas las notas (se asume lista no vacía; se controla en main)
    fun calcularMedia(alumnos: List<Alumno>): Double {
        if (alumnos.isEmpty()) return 0.0
        return alumnos.map { it.nota }.average()
    }

    // Fase 7: filtrado con filter
    fun mostrarAprobados(alumnos: List<Alumno>) {
        println("===== ALUMNOS APROBADOS =====")
        val aprobados = alumnos.filter { it.esAprobado() }
        if (aprobados.isEmpty()) {
            println("No hay alumnos aprobados.")
        } else {
            aprobados.forEach { println(it.descripcion()) }
        }
    }

    fun mostrarSuspensos(alumnos: List<Alumno>) {
        println("===== ALUMNOS SUSPENSOS =====")
        val suspensos = alumnos.filter { it.esSuspenso() }
        if (suspensos.isEmpty()) {
            println("No hay alumnos suspensos.")
        } else {
            suspensos.forEach { println(it.descripcion()) }
        }
    }

    // Fase 8: búsqueda parcial, sin distinguir mayúsculas
    fun buscarAlumno(alumnos: List<Alumno>) {
        print("Introduce el texto a buscar: ")
        val texto = readLine()?.trim().orEmpty()
        if (texto.isEmpty()) {
            println("Debes introducir un texto para buscar.")
            return
        }

        val encontrados = alumnos.filter { it.coincideCon(texto) }

        if (encontrados.isEmpty()) {
            println("No se han encontrado alumnos con ese criterio.")
        } else {
            encontrados.forEach { println(it.descripcion()) }
        }
    }

    // Fase 9: eliminar mostrando la lista y pidiendo el número
    fun eliminarAlumno(alumnos: MutableList<Alumno>) {
        if (alumnos.isEmpty()) {
            println("No hay alumnos registrados.")
            return
        }

        listarAlumnos(alumnos)
        print("Introduce el número del alumno a eliminar: ")
        val numero = readLine()?.trim()?.toIntOrNull()

        if (numero == null || numero < 1 || numero > alumnos.size) {
            println("Número no válido. El alumno no existe.")
            return
        }

        alumnos.removeAt(numero - 1)
        println("Alumno eliminado correctamente.")
    }

    // Fase 3: el menú se repite hasta elegir 8 (Salir)
    do {
        mostrarMenu()
        opcion = readLine()?.trim()?.toIntOrNull()

        // Fase 3: el menú se repite hasta elegir 8 (Salir)
        do {
            mostrarMenu()
            opcion = readLine()?.trim()?.toIntOrNull()

            when (opcion) {
                1 -> registrarAlumno(alumnos)
                2 -> listarAlumnos(alumnos)
                3 -> {
                    // Fase 6: controlar lista vacía antes de calcular la media
                    if (alumnos.isEmpty()) {
                        println("No hay alumnos registrados. No se puede calcular la media.")
                    } else {
                        println("La media del grupo es: ${"%.2f".format(calcularMedia(alumnos))}")
                    }
                }
                4 -> mostrarAprobados(alumnos)
                5 -> mostrarSuspensos(alumnos)
                6 -> buscarAlumno(alumnos)
                7 -> eliminarAlumno(alumnos)
                8 -> println("Saliendo del programa. ¡Hasta pronto!")
                else -> println("Opción no válida. Introduce un número del 1 al 8.")
            }
            println()

    } while (opcion != 8)
}



