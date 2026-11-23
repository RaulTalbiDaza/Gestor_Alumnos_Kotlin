// Main.kt
// UD01_Actividad09_GestorAlumnos - Gestor de alumnos de consola en Kotlin

fun main() {
    // Lista mutable donde se guardan todos los alumnos
    val alumnos = mutableListOf<Alumno>()
    var opcion: Int? = null

    // Fase 3: el menú se repite hasta elegir 8 (Salir)
    do {
        mostrarMenu()
        opcion = readLine()?.trim()?.toIntOrNull()

    } while (opcion != 8)
}

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



