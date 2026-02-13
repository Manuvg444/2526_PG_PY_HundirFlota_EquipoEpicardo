package main.core;

/**
 * PLANTILLA PARA EL ALUMNO.
 * 
 * Esta clase gestiona la cuadrícula de juego y la lógica de combate sobre las casillas.
 */
public class Tablero implements IAtacable {

    public static final int TAMAÑO = 10;
    private Casilla[][] celdas;

    /**
     * Constructor: Inicializa la matriz de casillas.
     */
    public TableroAlumno() {
        // // TODO: Instanciar la matriz 'celdas' con TAMAÑO x TAMAÑO.
        // // TODO: Rellenar cada posición con un nuevo objeto Casilla().
    }

    /**
     * Intenta colocar un barco. Debe verificar límites, solapamientos y vecindad.
     * @return true si se pudo colocar, false en caso contrario.
     */
    public boolean colocarBarco(Barco b, Coordenada inicio, DireccionEnum d) {
        // // TODO:
        // // 1. Obtener tamaño del barco, fila y columna de inicio.
        // // 2. PRIMER BUCLE (Validación): Recorrer las posiciones que ocuparía el barco
        // //    según la dirección y comprobar:
        // //    a) ¿Está dentro del tablero? (usar esCoordenadaValida)
        // //    b) ¿Hay ya otro barco en esa casilla?
        // //    c) ¿Hay barcos en las casillas adyacentes? (regla de no barcos pegados)
        // // 3. Si alguna comprobación falla, retornar false inmediatamente.
        // // 4. SEGUNDO BUCLE (Colocación): Si todo es válido, volver a recorrer y
        // //    llamar a casilla.colocarBarco(b) en cada posición.
        // // 5. Retornar true.
        return false;
    }

    /**
     * Procesa un ataque recibido en una coordenada con un arma específica.
     */
    @Override
    public InformeDisparo recibirAtaque(Coordenada c, TipoAtaqueEnum arma) {
        InformeDisparo informe = new InformeDisparo();

        // // TODO:
        // // 1. Determinar qué coordenadas se ven afectadas según el 'arma' (TipoAtaqueEnum).
        // //    - NORMAL: Solo la coordenada 'c'.
        // //    - RADAR: Zona 3x3 alrededor de 'c'.
        // //    - CRUZ: Toda la fila y toda la columna de 'c'.
        // // 2. Recorrer las coordenadas afectadas:
        // //    - Si la coordenada es válida:
        // //      a) Obtener la casilla correspondiente.
        // //      b) Llamar a casilla.recibirImpacto() (o consultar si es radar).
        // //      c) Añadir el resultado al 'informe' usando informe.agregar(...)
        // //      d) Si un barco se hunde, marcar informe.setHundido(true).
        
        return informe;
    }

    /**
     * Dibuja el tablero en la consola usando ConsoleHelper.
     * @param esModoRadar true para ocultar barcos enemigos, false para ver todo.
     */
    public void imprimirTablero(boolean esModoRadar) {
        // // TODO:
        // // 1. Imprimir cabecera de letras (A B C...).
        // // 2. Recorrer filas y columnas de la matriz 'celdas'.
        // // 3. Para cada casilla:
        // //    - Obtener su EstadoCasillaEnum.
        // //    - Si estamos en modo radar y el estado es BARCO -> Mostrar como AGUA (ocultar).
        // //    - En cualquier otro caso -> Mostrar símbolo y color real según el estado.
        // // 4. Usar ConsoleHelper.write() y ConsoleHelper.cell() para un acabado profesional.
    }

    /**
     * Comprueba si una fila y columna están dentro de los límites (0 a TAMAÑO-1).
     */
    private boolean esCoordenadaValida(int f, int c) {
        // // TODO: Retornar true si f y c están entre 0 y TAMAÑO-1.
        return false;
    }

    /**
     * Verifica si hay algún barco en las 8 casillas que rodean a la posición dada.
     */
    private boolean hayBarcoCerca(int f, int c) {
        // // TODO: Recorrer con dos bucles anidados de -1 a +1 para f y c.
        // // Comprobar si la coordenada vecina es válida y si tiene un barco.
        return false;
    }
}