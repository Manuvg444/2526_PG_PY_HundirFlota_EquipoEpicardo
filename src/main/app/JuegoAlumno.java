package main.app;

import java.util.Scanner;

import main.util.ConsoleHelper;

public class JuegoAlumno {

    private static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        // Inicialización de la consola
        ConsoleHelper.init();
        
        presentarBienvenida();

        // 1. Inicialización de jugadores
        Jugador humano = new JugadorHumano("Almirante");
        Jugador maquina = new JugadorMaquina("Skynet");

        // 2. Configuración inicial
        configurarRivalidad(humano, maquina);
        prepararFlotas(humano, maquina);

        // 3. Bucle principal de la partida
        Jugador turnoActual = humano;
        while (humano.tieneBarcosAFlote() && maquina.tieneBarcosAFlote()) {
            
            gestionarTurno(turnoActual, humano);

            // Alternancia de turno
            turnoActual = (turnoActual == humano) ? maquina : humano;
        }

        // 4. Finalización
        finalizarPartida(humano);
    }

    /**
     * TODO: Mostrar un mensaje de bienvenida usando ConsoleHelper.
     */
    private static void presentarBienvenida() {
        // // TODO: Imprimir encabezado artístico con writeColorLn
    }

    /**
     * TODO: Conectar los tableros de los rivales.
     */
    private static void configurarRivalidad(Jugador p1, Jugador p2) {
        // // TODO: p1 debe conocer el tablero de p2 y viceversa.
        // // Usa los métodos setTableroRival() y getMiTablero().
    }

    /**
     * TODO: Inicializar y colocar los barcos en ambos jugadores.
     */
    private static void prepararFlotas(Jugador p1, Jugador p2) {
        // // TODO: Llamar a inicializarFlota() y colocarTodaLaFlota() para cada jugador.
    }

    /**
     * TODO: Decidir qué lógica ejecutar dependiendo de quién tiene el turno.
     */
    private static void gestionarTurno(Jugador actual, Jugador humanoReferencia) {
        // // TODO: Si 'actual' es el humano:
        // // 1. Visualizar estado (radar/propio)
        // // 2. Ejecutar lógica de entrada para el disparo
        // // Si es la máquina:
        // // 1. Simplemente llamar a actual.realizarTurno()
    }

    /**
     * TODO: Mostrar el radar enemigo (modo radar) y el tablero propio (modo normal).
     */
    private static void visualizarEstadoParaHumano(Jugador h) {
        // // TODO: Usar h.getTableroRival().imprimirTablero(true)
        // // Usar h.getMiTablero().imprimirTablero(false)
    }

    /**
     * TODO: Orquestar el disparo del humano: elegir habilidad y elegir coordenada.
     */
    private static void logicaEntradaHumano(Jugador h) {
        // // TODO: 
        // // 1. Obtener el TipoAtaque consultando al usuario.
        // // 2. Obtener una Coordenada válida.
        // // 3. Llamar a h.getTableroRival().recibirAtaque(coordenada, tipo)
        // // 4. Informar por pantalla del resultado (hundido o no).
    }

    /**
     * TODO: Preguntar al usuario si desea usar habilidad especial y devolver el TipoAtaque.
     */
    private static TipoAtaque consultarUsoHabilidad() {
        // // TODO: Leer del scanner si quiere usar habilidad.
        // // Si dice sí: Mostrar opciones (1-4) y devolver el TipoAtaqueEnum correspondiente.
        // // Si dice no: Devolver TipoAtaque.NORMAL.
        return TipoAtaque.NORMAL; 
    }

    /**
     * TODO: Pedir una coordenada (ej: B5) y validarla contra errores (Scanner + Try/Catch).
     */
    private static Coordenada capturarCoordenadaValida() {
        // // TODO: Bucle infinito (while true) que pida el string al usuario.
        // // Intentar crear una new Coordenada(input).
        // // Si falla (excepción), mostrar mensaje de error y seguir en el bucle.
        // // Si tiene éxito, retornar la coordenada.
        return null; 
    }

    /**
     * TODO: Mostrar mensaje de victoria o derrota final.
     */
    private static void finalizarPartida(Jugador humano) {
        // // TODO: Comprobar humano.tieneBarcosAFlote() para saber si ganó o perdió.
        // // Usar ConsoleHelper para dar un acabado épico con colores.
    }
