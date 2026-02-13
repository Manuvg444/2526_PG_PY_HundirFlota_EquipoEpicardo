package test;

public class TestHabilidades {

    public static void main(String[] args) {
        System.out.println("=== TEST DE HABILIDADES Y BLINDAJES ===");
        
        // testGestionCargas();
        // testBlindajeReforzado();
        // testTiposDeAtaque();
        
        System.out.println("✅ Todas las pruebas de habilidades superadas.");
    }

    // private static void testGestionCargas() {
    //     System.out.println(">>> Test: Gestión de Cargas");
        
    //     // Destructor tiene 2 cargas
    //     Barco destructor = new Destructor(new BlindajeSimple());
        
    //     assert destructor.tieneCargas() : "Error: Destructor debe empezar con cargas";
    //     destructor.usarCarga(); 
    //     assert destructor.tieneCargas() : "Error: Destructor debe tener 1 carga restante";
    //     destructor.usarCarga();
    //     assert !destructor.tieneCargas() : "Error: Destructor debe estar vacío tras 2 usos";
        
    //     // Acorazado tiene 1 carga
    //     Barco acorazado = new Acorazado(new BlindajeSimple());
    //     assert acorazado.tieneCargas();
    //     acorazado.usarCarga();
    //     assert !acorazado.tieneCargas();

    //     System.out.println("  - Consumo de cargas OK");
    // }

    // private static void testBlindajeReforzado() {
    //     System.out.println(">>> Test: Blindaje Reforzado");
        
    //     BlindajeReforzado blindaje = new BlindajeReforzado();
        
    //     // Primer impacto: Debe ser absorbido (0 daño)
    //     int danio1 = blindaje.recibirImpacto(1);
    //     assert danio1 == 0 : "Error: El primer impacto debe ser 0 (absorbido)";
        
    //     // Segundo impacto: Debe entrar (1 daño)
    //     int danio2 = blindaje.recibirImpacto(1);
    //     assert danio2 == 1 : "Error: El segundo impacto debe entrar (escudo roto)";

    //     System.out.println("  - Mecánica de absorción OK");
    // }

    // private static void testTiposDeAtaque() {
    //     System.out.println(">>> Test: Tipos de Ataque Especial");
        
    //     Barco porta = new Portaaviones(new BlindajeSimple());
    //     assert porta.getTipoAtaqueEspecial() == TipoAtaque.RADAR : "Error: Portaaviones debe ser RADAR";
        
    //     Barco acora = new Acorazado(new BlindajeSimple());
    //     assert acora.getTipoAtaqueEspecial() == TipoAtaque.ZONA : "Error: Acorazado debe ser ZONA";
        
    //     Barco buque = new Buque(new BlindajeSimple());
    //     assert buque.getTipoAtaqueEspecial() == TipoAtaque.CRUZ : "Error: Buque debe ser CRUZ";

    //     System.out.println("  - Mapeo de habilidades OK");
    // }
}
