// Alumno.kt
// Data class que representa a un alumno del grupo

data class Alumno(
    val nombre: String,
    val apellidos: String,
    val nota: Double
) {
        companion object {
            // Nota mínima para aprobar
            const val NOTA_APROBADO = 5.0
        }

        // Nombre completo del alumno
        fun nombreCompleto(): String = "$nombre $apellidos"

        // Texto para mostrar al alumno en consola
        fun descripcion(): String = "${nombreCompleto()} - Nota: $nota"

        // Aprobado: nota igual o superior a 5
        fun esAprobado(): Boolean = nota >= NOTA_APROBADO

        // Suspenso: nota inferior a 5
        fun esSuspenso(): Boolean = !esAprobado()

        // Coincidencia parcial en nombre o apellidos, sin distinguir mayúsculas
        fun coincideCon(texto: String): Boolean =
            nombre.contains(texto, ignoreCase = true) ||
                    apellidos.contains(texto, ignoreCase = true)
    }