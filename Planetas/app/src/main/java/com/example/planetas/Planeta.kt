package com.example.planetas
// Definir una enumeración para los tipos de planetas
enum class TipoPlaneta {
    ROCOSO, GASEOSO, HELADO
}

// Definir la clase Planeta
class Planeta(
    val nombre: String,
    val masa: Double, // en kilogramos
    val radio: Double, // en metros
    val distanciaAlSol: Double, // en kilómetros
    val tipo: TipoPlaneta,
    val gravedad: Double // en m/s^2
) {
    // Función para imprimir los detalles del planeta
    fun mostrarDetalles() {
        println("Nombre: $nombre")
        println("Masa: $masa kg")
        println("Radio: $radio metros")
        println("Distancia al Sol: $distanciaAlSol km")
        println("Tipo: $tipo")
        println("Gravedad: $gravedad m/s^2")
    }
}

/*fun main() {
    // Crear una instancia de un planeta
    val tierra = Planeta("Tierra", 5.972e24, 6371e3, 149.6e6, TipoPlaneta.ROCOSO, 9.81)

    // Mostrar los detalles del planeta



        val planetas = arrayOf(
        Planeta("Mercurio", 3.3011e23, 2.4397e6, 57.9e6, TipoPlaneta.ROCOSO, 3.7),
        Planeta("Venus", 4.8675e24, 6.0518e6, 108.2e6, TipoPlaneta.ROCOSO, 8.87),
        Planeta("Tierra", 5.972e24, 6.371e6, 149.6e6, TipoPlaneta.ROCOSO, 9.81),
        Planeta("Marte", 6.4171e23, 3.3895e6, 227.9e6, TipoPlaneta.ROCOSO, 3.71),
        Planeta("Júpiter", 1.8982e27, 6.9911e7, 778.3e6, TipoPlaneta.GASEOSO, 24.79),
        Planeta("Saturno", 5.6834e26, 5.8232e7, 1427.0e6, TipoPlaneta.GASEOSO, 10.44),
        Planeta("Urano", 8.6810e25, 2.5362e7, 2871.0e6, TipoPlaneta.GASEOSO, 8.69),
        Planeta("Neptuno", 1.02413e26, 2.4622e7, 4495.1e6, TipoPlaneta.GASEOSO, 11.15)
    )

    // Imprimir detalles de los planetas
    for (planeta in planetas) {
        planeta.mostrarDetalles()
        println("----------------------------------")
    }
}*/
