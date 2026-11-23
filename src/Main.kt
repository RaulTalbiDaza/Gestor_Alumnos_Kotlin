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


