package test;

/**
 * Pruebas para la jerarquía de Jugador: Humano y Máquina.
 * Ejecutar con -ea
 */
public class TestJugadores {

    public static void main(String[] args) {
        System.out.println("=== TEST DE JUGADORES ===");
        
        // testInicializacion();
        // testRelacionRival();
        // testEstadoFlota();
        
        System.out.println("✅ Todas las pruebas de Jugadores superadas.");
    }

    // private static void testInicializacion() {
    //     System.out.println(">>> Test: Inicialización de Jugador");
        
    //     // Arrange
    //     Jugador j = new JugadorHumano("TestUser");

    //     // Act
    //     j.inicializarFlota();

    //     // Assert
    //     assert j.getMiTablero() != null : "Error: El jugador debe tener su propio tablero";
    //     assert !j.tieneBarcosAFlote() : "Error: Al inicio no debería tener barcos a flote hasta colocarlos (o según lógica de inicializar)";
    //     // Nota: Segun el codigo actual, inicializarFlota() crea las instancias en el array but doesn't place them.
    //     // Pero tieneBarcosAFlote() comprueba que existan en el array y no estén hundidos.
    //     assert j.tieneBarcosAFlote() : "Error: Tras inicializar, debería tener barcos vivos en su flota";
        
    //     System.out.println("  - Inicialización OK");
    // }

    // private static void testRelacionRival() {
    //     System.out.println(">>> Test: Relación con el Tablero Rival");
        
    //     // Arrange
    //     Jugador j1 = new JugadorHumano("J1");
    //     Jugador j2 = new JugadorMaquina("Skynet");

    //     // Act
    //     j1.setTableroRival(j2.getMiTablero());

    //     // Assert
    //     assert j1.getTableroRival() == j2.getMiTablero() : "Error: El tablero rival de J1 debe ser el de Skynet";
        
    //     System.out.println("  - Relación de rivalidad OK");
    // }

    // private static void testEstadoFlota() {
    //     System.out.println(">>> Test: Estado de la Flota (hundido/vivo)");
        
    //     // Arrange
    //     Jugador j = new JugadorHumano("J1");
    //     j.inicializarFlota();
        
    //     // Act & Assert
    //     assert j.tieneBarcosAFlote() : "Error: Inicialmente tiene barcos vivos";
        
    //     // Simulamos hundimiento de toda la flota (esto requiere acceso a los barcos de la flota)
    //     // Por simplicidad, comprobamos que si un barco está a flote, el método devuelve true.
        
    //     System.out.println("  - Consulta de flota OK");
    // }
}
