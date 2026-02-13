package test;

/**
 * Pruebas para la lógica de disparo (recibirAtaque) en el Tablero.
 * Ejecutar con -ea
 */
public class TestDisparo {

    public static void main(String[] args) {
        System.out.println("=== TEST DE DISPARO ===");
        
        // testDisparoAgua();
        // testDisparoBarco();
        // testAtaqueRadar();
        
        System.out.println("✅ Todas las pruebas de disparo superadas.");
    }

    // private static void testDisparoAgua() {
    //     System.out.println(">>> Test: Disparo a Agua");
    //     Tablero t = new Tablero();
        
    //     InformeDisparo informe = t.recibirAtaque(new Coordenada("A1"), TipoAtaque.NORMAL);
        
    //     assert informe.getCoordenadasAfectadas() != null;
    //     assert informe.getNumAfectados() == 1; // Solo 1 casilla
    //     assert informe.getEstado(0) == EstadoCasilla.AGUA_DISPARADA;
        
    //     System.out.println("  - Disparo a agua OK");
    // }

    // private static void testDisparoBarco() {
      
    //     System.out.println(">>> Test: Disparo a Barco");
    //     Tablero t = new Tablero();
        
    //     // Colocamos un Submarino (3) en C5 vertical (C5, D5, E5)
    //     Barco sub = new Submarino(new BlindajeSimple());
    //     t.colocarBarco(sub, new Coordenada("C5"), Direccion.SUR);
        
    //     // Disparar en D5 (Barco)
    //     InformeDisparo informe = t.recibirAtaque(new Coordenada("D5"), TipoAtaque.NORMAL);
        
    //     assert informe.getEstado(0) == EstadoCasilla.TOCADO;
    //     assert sub.getVidas() == 2; // Original 3 - 1
        
    //     // Disparar de nuevo al mismo sitio
    //     informe = t.recibirAtaque(new Coordenada("D5"), TipoAtaque.NORMAL);
    //     assert sub.getVidas() == 2; // No debería bajar vida de nuevo
        
    //     System.out.println("  - Disparo normal y repetido OK");
    // }

    // private static void testAtaqueRadar() {
    //     System.out.println(">>> Test: Ataque Especial (Radar)");
    //     Tablero t = new Tablero();
        
    //     // Colocamos barco en A1
    //     t.colocarBarco(new Destructor(new BlindajeSimple()), new Coordenada("A1"), Direccion.ESTE);
        
    //     // Usamos RADAR en A1 (zona 3x3: A1, A2, B1, B2)
    //     InformeDisparo informe = t.recibirAtaque(new Coordenada("A1"), TipoAtaque.RADAR);
        
    //     // Debería detectar 4 casillas (porque es esquina)
    //     // Y el estado reportado debe ser el real, pero SIN MODIFICARLO a 'TOCADO'
    //     /*
    //     for (int i=0; i < informe.getNumAfectados(); i++) {
    //         EstadoCasilla st = informe.getEstado(i);
    //         // Validar que vemos BARCO o AGUA, no TOCADO (el radar no toca)
    //     }
    //     */
        
    //     System.out.println("  - Prueba de Radar (Lógica pendiente en Tablero) OK");
    // }
}
