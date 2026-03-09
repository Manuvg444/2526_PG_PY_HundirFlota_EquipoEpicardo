package main.core;

import main.localizacion.Columna;
import main.localizacion.Coordenada;
import main.localizacion.DireccionEnum;
import main.localizacion.Fila;
import main.nave.base.Barco;
import main.nave.base.TipoAtaqueEnum;
import main.util.ConsoleHelper;

/*
 * Esta clase gestiona la cuadrícula de juego y la lógica de combate sobre las casillas.
 */
public class Tablero implements IAtacable {

    public static final int TAMAÑO = 10;
    public Casilla[][] celdas;

    /**
     * Constructor: Inicializa la matriz de casillas.
     */
    public Tablero() {

        celdas = new Casilla[TAMAÑO][TAMAÑO];

        for (int col = 0; col < TAMAÑO; col++) {
            for (int fila = 0; fila < TAMAÑO; fila++) {
                celdas[col][fila] = new Casilla();
            }
        }
    }

    /**
     * Intenta colocar un barco. Debe verificar límites, solapamientos y vecindad.
     * @return true si se pudo colocar, false en caso contrario.
     */
    public boolean colocarBarco(Barco b, Coordenada inicio, DireccionEnum d) {
        // // TODO:
        // // 1. Obtener tamaño del barco, fila y columna de inicio.
        int tamano = b.getTamano();
        int col = inicio.getColumna();
        int fila = inicio.getFila();

        // // 2. PRIMER BUCLE (Validación): Recorrer las posiciones que ocuparía el barco
        // //    según la dirección y comprobar:
        // //    a) ¿Está dentro del tablero? (usar esCoordenadaValida)
        // //    b) ¿Hay ya otro barco en esa casilla?
        // //    c) ¿Hay barcos en las casillas adyacentes? (regla de no barcos pegados)
        // // 3. Si alguna comprobación falla, retornar false inmediatamente.
        
        switch (d) {
            case NORTE:
                for (int i = 0; i < tamano; i++) {
                    if (esCoordenadaValida(col, fila-i)==false || celdas[col][fila-i].tieneBarco() || hayBarcoCerca(col, fila-i)) {
                        System.out.println("Coordenada no válida");
                        return false;
                    }
                }
                break;
            case SUR:
                for (int i = 0; i < tamano; i++) {
                    if (esCoordenadaValida(col, fila+i)==false || celdas[col][fila+i].tieneBarco() || hayBarcoCerca(col, fila+i)) {
                        System.out.println("Coordenada no válida");
                        return false;
                    }
                }
                break;
            case ESTE:
                for (int i = 0; i < tamano; i++) {
                    if (esCoordenadaValida(col+i, fila)==false || celdas[col+i][fila].tieneBarco() || hayBarcoCerca(col+i, fila)) {
                        System.out.println("Coordenada no válida");
                        return false;
                    }
                }
                break;
            case OESTE:
                for (int i = fila; i < tamano; i++) {
                    if (esCoordenadaValida(col-i, fila)==false || celdas[col-i][fila].tieneBarco() || hayBarcoCerca(col-i, fila)) {
                        System.out.println("Coordenada no válida");
                        return false;
                    }
                }
                break;
            default:
                break;
        }


        // // 4. SEGUNDO BUCLE (Colocación): Si todo es válido, volver a recorrer y
        // //    llamar a casilla.colocarBarco(b) en cada posición.
        switch (d) {
            case NORTE:
                for (int i = 0; i < tamano; i++) {
                    celdas[col][fila-i].colocarBarco(b);
                }
                break;
            case SUR:
                for (int i = 0; i < tamano; i++) {
                     celdas[col][fila+i].colocarBarco(b);
                }
                break;
            case ESTE:
                for (int i = 0; i < tamano; i++) {
                    celdas[col+i][fila].colocarBarco(b);
                }
                break;
            case OESTE:
                for (int i = fila; i < tamano; i++) {
                    celdas[col-i][fila].colocarBarco(b);
                }
                break;
            default:
                break;
        }
        // // 5. Retornar true.
        return true;
    }



    /**
     * Procesa un ataque recibido en una coordenada con un arma específica.
     * 
     * Un jugador hace un disparo, el jugador rival activa esta función recibirAtaque, 
     * y con el informe creado, se actualizará el tablero que visualiza el jugador que disparó.
     */

    public InformeDisparo recibirAtaque(Coordenada c, TipoAtaqueEnum arma) {
        InformeDisparo informe = new InformeDisparo();
        int col = c.getColumna();
        int fila = c.getFila();
        Casilla casilla = celdas[col][fila];

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

        if (esCoordenadaValida(col, fila)) {
            switch (arma) {
                case DEFECTO:
                case D_DOBLE:

                    procesarImpacto(c, informe);

                    break;
                case R_AEREO:
                    for (int co = col-1; co <= col+1; co++) {
                        for (int fi = fila-1; fi <= fila+1; fi++) {
                            if (esCoordenadaValida(co, fi)) {
                                procesarImpacto(new Coordenada(co, fi), informe);
                            } 
                        }       
                    }   
                    break;

                case A_CRUZ:
                    for (int co = 0; co < TAMAÑO; co++) {
                        procesarImpacto(new Coordenada(co, fila), informe);
                    }
                    for (int fi = 0; fi < TAMAÑO; fi++) {
                        procesarImpacto(new Coordenada(col, fi), informe);
                    }
                    break;

                case B_ZONA:
                    if (esCoordenadaValida(col-1, fila)) {
                        procesarImpacto(new Coordenada(col-1, fila), informe);
                    }
                    if (esCoordenadaValida(col+1, fila)) {
                        procesarImpacto(new Coordenada(col+1, fila), informe);
                    }
                    if (esCoordenadaValida(col-1, fila-1)) {
                        procesarImpacto(new Coordenada(col, fila-1), informe);
                    }
                    if (esCoordenadaValida(col-1, fila+1)) {
                        procesarImpacto(new Coordenada(col, fila+1), informe);
                    }
                    break;

                default:
                    break;
            }
            if (casilla.recibirImpacto()==EstadoCasillaEnum.HUNDIDO) {
                informe.setHundido();
            }
        }
        
        return informe;
    }


    public void procesarImpacto(Coordenada c, InformeDisparo informe) {
        int col = c.getColumna();
        int fila = c.getFila();
        Casilla casilla = celdas[col][fila];
        Barco b;

        if (casilla.tieneBarco()) {
            b = casilla.getBarco();

            informe.agregar(c, casilla.recibirImpacto());

            if (casilla.getEstado()==EstadoCasillaEnum.HUNDIDO) {
                // Recorrer tablero y cambiar a hundido el resto de casillas de este barco.
                for (int co = 0; co < TAMAÑO; co++) {
                    for (int fi = 0; fi < TAMAÑO; fi++) {
                        if (celdas[co][fi].getBarco().equals(b)) {
                            casilla.setEstado(EstadoCasillaEnum.HUNDIDO);
                            informe.agregar(new Coordenada(co, fi), casilla.getEstado());
                        }
                    }
                }
            }
        } else {
            informe.agregar(c, casilla.recibirImpacto());
        }
        

    }


    /**
     * Dibuja el tablero en la consola usando ConsoleHelper.
     * @param esModoRadar true para ocultar barcos enemigos, false para ver todo.
     */
    public void imprimirTablero(boolean esModoRadar) {
        ConsoleHelper.write("   ");
        for (int c = 0; c < TAMAÑO; c++) {
            ConsoleHelper.writeColor("  " + (char) ('A' + c) + " ", ConsoleHelper.CYAN);
        }
        ConsoleHelper.writeLn("");

        for (int f = 0; f < TAMAÑO; f++) {
            ConsoleHelper.writeColor(String.format("%2d ", f + 1), ConsoleHelper.CYAN);
            for (int c = 0; c < TAMAÑO; c++) {
                EstadoCasillaEnum estado = celdas[c][f].getEstado();
                String simbolo;

                if (esModoRadar && estado == EstadoCasillaEnum.BARCO) {
                    simbolo = EstadoCasillaEnum.AGUA.getSimbolo(true);
                } else {
                    simbolo = estado.getSimbolo(true);
                }
                ConsoleHelper.write("[" + simbolo + "]");
            }
            ConsoleHelper.writeLn("");
        }
    }

    /**
     * Comprueba si una fila y columna están dentro de los límites (0 a TAMAÑO-1).
     */
    private boolean esCoordenadaValida(int c, int f) {
        // // TODO: Retornar true si f y c están entre 0 y TAMAÑO-1.
        if (c>=0 && f>=0 && c<TAMAÑO && f<TAMAÑO) {
            return true;
        }
        return false;
    }

    /**
     * Verifica si hay algún barco en las 8 casillas que rodean a la posición dada.
     */
    private boolean hayBarcoCerca(int c, int f) {
        // // TODO: Recorrer con dos bucles anidados de -1 a +1 para f y c.
        // // Comprobar si la coordenada vecina es válida y si tiene un barco.
        for (int col = c-1; col <= c+1; col++) {
            for (int fila = f-1; fila <= f+1; fila++) {
                if (esCoordenadaValida(col, fila)) {
                    if (celdas[col][fila].tieneBarco()) {
                        return true;
                    }
                }
            }
        }
        return false;
    }
}