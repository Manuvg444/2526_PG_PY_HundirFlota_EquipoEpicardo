package test;

/**
 * Suite de pruebas principal que ejecuta todos los tests del proyecto.
 * 
 * IMPORTANTE: Debe ejecutarse con el flag -ea (Enable Assertions) para que las 
 * comprobaciones tengan efecto.
 */
public class TestApp {

    public static void main(String[] args) {
        System.out.println("====================================================");
        System.out.println("🚀 EJECUTANDO SUITE DE PRUEBAS: HUNDIR LA FLOTA POO");
        System.out.println("====================================================\n");

        try {
            // 1. Ejecutar tests de fundamentos (Localización)
            TestLocalizacion.main(args);
            System.out.println();

            // 2. Ejecutar tests de modelos (Barcos y Blindajes)
            TestBarco.main(args);
            System.out.println();

            // 3. Ejecutar tests de lógica de juego (Tablero y Colocación)
            TestColocacion.main(args);
            System.out.println();
            
            TestDisparo.main(args);
            System.out.println();

            TestTablero.main(args);
            System.out.println();

            // 4. Ejecutar tests de entidades y jugadores
            TestJugadores.main(args);
            System.out.println();

            // 5. Ejecutar habilidades si existe el archivo
            TestHabilidades.main(args);
            System.out.println();

            System.out.println("====================================================");
            System.out.println("✨ RESULTADO FINAL: TODOS LOS TESTS SUPERADOS ✨");
            System.out.println("====================================================");

        } catch (AssertionError e) {
            System.err.println("\n❌ ERROR DE VALIDACIÓN: " + e.getMessage());
            System.err.println("Ubicación: " + e.getStackTrace()[0]);
            System.exit(1);
        } catch (Exception e) {
            System.err.println("\n💥 ERROR INESPERADO: " + e.getMessage());
            e.printStackTrace();
            System.exit(1);
        }
    }
}
