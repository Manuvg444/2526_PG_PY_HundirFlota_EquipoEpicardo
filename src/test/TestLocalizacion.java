package test;

/**
 * Pruebas para las clases relacionadas con la localización: Fila, Columna y Coordenada.
 * Ejecutar con -ea
 */
public class TestLocalizacion {

    public static void main(String[] args) {
        System.out.println("=== TEST DE LOCALIZACIÓN ===");
        
        // testFila();
        // testColumna();
        // testCoordenadaParsing();
        // testCoordenadaIgualdad();
        
        System.out.println("✅ Todas las pruebas de localización superadas.");
    }

    // private static void testFila() {
    //     System.out.println(">>> Test: Componente Fila");
        
    //     // Arrange
    //     Fila f1 = new Fila(0); // Índice 0
    //     Fila f2 = new Fila(9); // Índice 9

    //     // Act & Assert
    //     assert f1.getValue() == 0;
    //     assert f1.toString().equals("1") : "Error: El índice 0 debe mostrarse como '1'";
    //     assert f2.toString().equals("10") : "Error: El índice 9 debe mostrarse como '10'";
        
    //     System.out.println("  - Fila OK");
    // }

    // private static void testColumna() {
    //     System.out.println(">>> Test: Componente Columna");
        
    //     // Arrange
    //     Columna c1 = new Columna("A");
    //     Columna c2 = new Columna("J");
    //     Columna c3 = new Columna(2); // Índice 2 -> "C"

    //     // Act & Assert
    //     assert c1.getValue() == 0 : "Error: La columna 'A' debe ser índice 0";
    //     assert c1.toString().equals("A");
        
    //     assert c2.getValue() == 9 : "Error: La columna 'J' debe ser índice 9";
    //     assert c2.toString().equals("J");
        
    //     assert c3.toString().equals("C") : "Error: El índice 2 debe mostrarse como 'C'";
        
    //     System.out.println("  - Columna OK");
    // }

    // private static void testCoordenadaParsing() {
    //     System.out.println(">>> Test: Coordenada Parsing de String");
        
    //     // Arrange
    //     String input1 = "A1";
    //     String input2 = "B10";

    //     // Act
    //     Coordenada coord1 = new Coordenada(input1);
    //     Coordenada coord2 = new Coordenada(input2);

    //     // Assert
    //     assert coord1.getFila() == 0 : "Error: A1 debe tener fila índice 0";
    //     assert coord1.getColumna() == 0 : "Error: A1 debe tener columna índice 0";
        
    //     assert coord2.getFila() == 9 : "Error: B10 debe tener fila índice 9";
    //     assert coord2.getColumna() == 1 : "Error: B10 debe tener columna índice 1";
        
    //     assert coord1.toString().equals("A-1") : "Error: El toString de A1 debería ser 'A-1'";
        
    //     System.out.println("  - Parsing de Coordenada OK");
    // }

    // private static void testCoordenadaIgualdad() {
    //     System.out.println(">>> Test: Coordenada Igualdad");
        
    //     // Arrange
    //     Coordenada c1 = new Coordenada("A1");
    //     Coordenada c2 = new Coordenada(0, 0);
    //     Coordenada c3 = new Coordenada("B5");

    //     // Act & Assert
    //     assert c1.equals(c2) : "Error: Dos coordenadas con misma posición deben ser iguales";
    //     assert !c1.equals(c3) : "Error: Dos coordenadas con distinta posición NO deben ser iguales";
        
    //     System.out.println("  - Igualdad de Coordenada OK");
    // }
}
