package test;

import main.core.EstadoCasillaEnum;
import main.core.InformeDisparo;
import main.core.Tablero;
import main.localizacion.Coordenada;
import main.localizacion.DireccionEnum;
import main.nave.base.Barco;
import main.nave.base.TipoAtaqueEnum;
import main.nave.defensa.BlindajeSimple;
import main.nave.tipos.Portaaviones;

/**
 * Pruebas generales para la clase Tablero, incluyendo la visualización.
 * Ejecutar con -ea
 */
public class TestTablero {

    public static void main(String[] args) {
        System.out.println("=== TEST DE TABLERO ===");
        
        testInicializacionTablero();
        testImprimirTablero();
        testLimitesAtaque();
        
        System.out.println("✅ Todas las pruebas de Tablero superadas.");
    }

    private static void testInicializacionTablero() {
        System.out.println(">>> Test: Inicialización del Tablero");
        
        // Arrange
        // Act
        Tablero t = new Tablero();

        // Assert
        // El tablero debe estar vacío (lleno de Casilla con estado AGUA)
        // Como no tenemos getter directo de la matriz, probamos a disparar a una esquina
        InformeDisparo inf = t.recibirAtaque(new Coordenada(0, 0), TipoAtaqueEnum.DEFECTO);
        assert inf.getEstado(0) == EstadoCasillaEnum.AGUA_DISPARADA : "Error: El tablero nuevo debe tener agua";
        
        System.out.println("  - Estado inicial (Agua) OK");
    }

    private static void testImprimirTablero() {
        System.out.println(">>> Test: Visualización del Tablero (Manual/Ejecución)");
        
        // Arrange
        Tablero t = new Tablero();
        Barco b = new Portaaviones(new BlindajeSimple());
        t.colocarBarco(b, new Coordenada("A1"), DireccionEnum.ESTE);
        
        // Disparar en A1 y A3
        t.recibirAtaque(new Coordenada("A1"), TipoAtaqueEnum.DEFECTO);
        System.out.println(t.celdas[0][0].getEstado());
        t.recibirAtaque(new Coordenada("A3"), TipoAtaqueEnum.DEFECTO);
        // Disparar al agua en B5
        t.recibirAtaque(new Coordenada("B5"), TipoAtaqueEnum.DEFECTO);

        // Act & Assert
        System.out.println("\n  - Vista Propia (Debe mostrar Barcos intactos B, Tocados X y Agua disparada ~ o similar):");
        t.imprimirTablero(false); 

        System.out.println("\n  - Vista Radar (Solo debe mostrar Tocados X y Agua disparada ~, los barcos intactos deben ser .):");
        t.imprimirTablero(true);
        
        System.out.println("\n  Visualización ejecutada sin errores.");
    }

    private static void testLimitesAtaque() {
        System.out.println(">>> Test: Límites de Ataque");
        
        // Arrange
        Tablero t = new Tablero();
        
        // Act & Assert
        // Disparar fuera de límites (esto debería ser gestionado para no lanzar excepción)
        // En un diseño robusto, recibirAtaque podría devolver un informe vacío o ignorar la coordenada fuera.
        try {
            // Intentamos algo que sabemos que está en los bordes
            t.recibirAtaque(new Coordenada(0, 0), TipoAtaqueEnum.DEFECTO);
            t.recibirAtaque(new Coordenada(9, 9), TipoAtaqueEnum.DEFECTO);
            System.out.println("  - Ataque en bordes internos OK");
        } catch (Exception e) {
            assert false : "Error: El tablero ha fallado en las coordenadas límite: " + e.getMessage();
        }
    }
}
