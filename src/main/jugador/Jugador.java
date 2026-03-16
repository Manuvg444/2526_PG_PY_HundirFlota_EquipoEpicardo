package main.jugador;

import java.util.Random;

import main.core.Tablero;
import main.localizacion.Coordenada;
import main.localizacion.DireccionEnum;
import main.nave.base.Barco;

import main.nave.defensa.BlindajeEvasivo;
import main.nave.defensa.BlindajeReforzado;
import main.nave.defensa.BlindajeSimple;
import main.nave.tipos.Acorazado;
import main.nave.tipos.Buque;
import main.nave.tipos.Destructor;
import main.nave.tipos.Portaaviones;
import main.nave.tipos.Submarino;

public abstract class Jugador {

    private final int NUM_BARCOS = 5;
    protected String nombre;
    protected Tablero miTablero;
    protected Tablero tableroRival;
    protected Barco[] flota;

    // EN EL CONSTRUCTOR A LA FLOTA SE LE PONE COMO LONGITUD NUM_BARCOS ==>

    public Jugador(String nombre) {
        this.nombre = nombre;
        this.miTablero = new Tablero();
        this.flota = new Barco[NUM_BARCOS];

    }

    // SE INICIALIZA LA FLOTA Y SE CREAN TODOS LOS BARCOS, SE LES ASIGNA UNA
    // POSICIÓN DE FLOTA ==>

    public void inicializarFlota() {

        flota[0] = new Acorazado(new BlindajeReforzado());
        flota[1] = new Buque(new BlindajeSimple());
        flota[2] = new Destructor(new BlindajeSimple());
        flota[3] = new Portaaviones(new BlindajeEvasivo());
        flota[4] = new Submarino(new BlindajeEvasivo());
    }

    // SE COLOCA TODA LA FLOTA AUTOMÁTICAMENTE (SOLO PARA MÁQUINA)

    public void colocarTodaLaFlota() {
        Random rnd = new Random();
        for (Barco b : flota) {
            boolean colocado = false;
            int intentos = 0;
            while (!colocado && intentos < 1000) {
                int f = rnd.nextInt(Tablero.TAMAÑO);
                int c = rnd.nextInt(Tablero.TAMAÑO);
                DireccionEnum d = DireccionEnum.values()[rnd.nextInt(DireccionEnum.values().length)];
                colocado = miTablero.colocarBarco(b, new Coordenada(f, c), d);
                intentos++;
            }
            if (!colocado) {
                System.err.println("Error: No se pudo colocar el barco " + b.getNombre() + " tras 1000 intentos.");
            }
        }
    }

    // CADA JUGADOR SOBREESCRIBE SU MÉTODO REALIZARTURNO ==>

    public void realizarTurno() {

    }

    // MIENTRAS TENGA BARCOS CON VIDAS, TIENE BARCOS A FLOTE, SI NO, RETORNA FALSO
    // ==>

    public boolean tieneBarcosAFlote() {
        for (Barco b : flota) {
            if (!b.estaHundido()) {
                return true;
            }
        }
        return false;

    }

    // MIENTRAS TENGA CARGAS Y NO ESTÁ HUNDIDO, EL CONTADOR DE BARCOS CON CARGA SUBE
    // LUEGO SE HACE UN ARRAY DE BARCOS CON EL CONTADOR

    public Barco[] getBarcosConCargas() {
        int barcosConCargas = 0;

        for (Barco barco : flota) {
            if (barco.getCargasHabilidad() > 0 && !barco.estaHundido()) {
                barcosConCargas++;
            }
        }

        Barco[] barcosCargas = new Barco[barcosConCargas];
        int indiceArray = 0;
        for (Barco barco : flota) {
            if (barco.getCargasHabilidad() > 0 && !barco.estaHundido()) {
                barcosCargas[indiceArray++] = barco;
            }
        }

        return barcosCargas;

    }

    public Tablero getMiTablero() {
        return miTablero;
    }

    public Tablero getTableroRival() {
        return tableroRival;
    }

    public void setTableroRival(Tablero t) {
        this.tableroRival = t;
    }

}
