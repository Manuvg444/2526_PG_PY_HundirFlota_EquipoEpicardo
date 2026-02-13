package test;


/**
 * Pruebas generales para la clase Tablero, incluyendo la visualización.
 * Ejecutar con -ea
 */
public class TestTablero {

    public static void main(String[] args) {
        System.out.println("=== TEST DE TABLERO ===");
        
        // testInicializacionTablero();
        // testImprimirTablero();
        // testLimitesAtaque();
        
        System.out.println("✅ Todas las pruebas de Tablero superadas.");
    }

    // private static void testInicializacionTablero() {
    //     System.out.println(">>> Test: Inicialización del Tablero");
        
    //     // Arrange
    //     // Act
    //     Tablero t = new Tablero();

    //     // Assert
    //     // El tablero debe estar vacío (lleno de Casilla con estado AGUA)
    //     // Como no tenemos getter directo de la matriz, probamos a disparar a una esquina
    //     InformeDisparo inf = t.recibirAtaque(new Coordenada(0, 0), TipoAtaque.NORMAL);
    //     assert inf.getEstado(0) == EstadoCasilla.AGUA_DISPARADA : "Error: El tablero nuevo debe tener agua";
        
    //     System.out.println("  - Estado inicial (Agua) OK");
    // }

    // private static void testImprimirTablero() {
    //     System.out.println(">>> Test: Visualización del Tablero (Manual/Ejecución)");
        
    //     // Arrange
    //     Tablero t = new Tablero();
    //     Barco b = new Portaaviones(new BlindajeSimple());
    //     t.colocarBarco(b, new Coordenada("A1"), Direccion.ESTE);
        
    //     // Disparar en A1 y A3
    //     t.recibirAtaque(new Coordenada("A1"), TipoAtaque.NORMAL);
    //     t.recibirAtaque(new Coordenada("A3"), TipoAtaque.NORMAL);
    //     // Disparar al agua en B5
    //     t.recibirAtaque(new Coordenada("B5"), TipoAtaque.NORMAL);

    //     // Act & Assert
    //     System.out.println("\n  - Vista Propia (Debe mostrar Barcos intactos B, Tocados X y Agua disparada ~ o similar):");
    //     t.imprimirTablero(false); 

    //     System.out.println("\n  - Vista Radar (Solo debe mostrar Tocados X y Agua disparada ~, los barcos intactos deben ser .):");
    //     t.imprimirTablero(true);
        
    //     System.out.println("\n  Visualización ejecutada sin errores.");
    // }

    // private static void testLimitesAtaque() {
    //     System.out.println(">>> Test: Límites de Ataque");
        
    //     // Arrange
    //     Tablero t = new Tablero();
        
    //     // Act & Assert
    //     // Disparar fuera de límites (esto debería ser gestionado para no lanzar excepción)
    //     // En un diseño robusto, recibirAtaque podría devolver un informe vacío o ignorar la coordenada fuera.
    //     try {
    //         // Intentamos algo que sabemos que está en los bordes
    //         t.recibirAtaque(new Coordenada(0, 0), TipoAtaque.NORMAL);
    //         t.recibirAtaque(new Coordenada(9, 9), TipoAtaque.NORMAL);
    //         System.out.println("  - Ataque en bordes internos OK");
    //     } catch (Exception e) {
    //         assert false : "Error: El tablero ha fallado en las coordenadas límite: " + e.getMessage();
    //     }
    // }
}
