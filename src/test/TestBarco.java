package test;

/**
 * Pruebas para la clase Barco y su interacción con los Blindajes.
 * Ejecutar con -ea
 */
public class TestBarco {

    public static void main(String[] args) {
        System.out.println("=== TEST DE BARCOS ===");
        
        // testVidaInicial();
        // testRecibirImpactoSimple();
        // testBlindajeReforzado();
        // testHundimiento();
        
        System.out.println("✅ Todas las pruebas de Barco superadas.");
    }

    // private static void testVidaInicial() {
    //     System.out.println(">>> Test: Vida Inicial por Tipo");
        
    //     // Arrange
    //     Barco p = new Portaaviones(new BlindajeSimple());
    //     Barco s = new Submarino(new BlindajeSimple());

    //     // Act & Assert
    //     assert p.getVidas() == 5 : "Error: Portaaviones debería tener 5 vidas";
    //     assert s.getVidas() == 3 : "Error: Submarino debería tener 3 vidas";
        
    //     System.out.println("  - Vidas iniciales OK");
    // }

    // private static void testRecibirImpactoSimple() {
    //     System.out.println(">>> Test: Recibir Impacto con Blindaje Simple");
        
    //     // Arrange
    //     Barco b = new Acorazado(new BlindajeSimple());
    //     int vidasIniciales = b.getVidas();

    //     // Act
    //     int danio = b.recibirImpacto();

    //     // Assert
    //     assert danio == 1 : "Error: El daño debería ser 1";
    //     assert b.getVidas() == vidasIniciales - 1 : "Error: Debería haber restado una vida";
        
    //     System.out.println("  - Daño simple OK");
    // }

    // private static void testBlindajeReforzado() {
    //     System.out.println(">>> Test: Blindaje Reforzado");
        
    //     // Arrange
    //     Barco b = new Portaaviones(new BlindajeReforzado());
    //     int vidasIniciales = b.getVidas();

    //     // Act - Primer impacto (debe absorberse)
    //     int danio1 = b.recibirImpacto();
        
    //     // Assert 1
    //     assert danio1 == 0 : "Error: El primer impacto con blindaje reforzado debería ser 0";
    //     assert b.getVidas() == vidasIniciales : "Error: El blindaje reforzado no debe restar vida el primer golpe";

    //     // Act - Segundo impacto (ya no hay blindaje)
    //     int danio2 = b.recibirImpacto();

    //     // Assert 2
    //     assert danio2 == 1 : "Error: El segundo impacto debería ser 1";
    //     assert b.getVidas() == vidasIniciales - 1 : "Error: Debería haber restado una vida tras romperse el blindaje";

    //     System.out.println("  - Blindaje reforzado OK");
    // }

    // private static void testHundimiento() {
    //     System.out.println(">>> Test: Ciclo de vida hasta Hundimiento");
        
    //     // Arrange
    //     Barco d = new Destructor(new BlindajeSimple()); // 2 vidas

    //     // Act
    //     d.recibirImpacto();
    //     assert !d.estaHundido() : "Error: No debería estar hundido con 1 vida restante";
        
    //     d.recibirImpacto();

    //     // Assert
    //     assert d.getVidas() == 0;
    //     assert d.estaHundido() : "Error: Debería estar hundido con 0 vidas";
        
    //     System.out.println("  - Hundimiento OK");
    // }
}
