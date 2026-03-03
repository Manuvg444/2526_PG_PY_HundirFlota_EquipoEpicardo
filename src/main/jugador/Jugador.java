package main.jugador;

import main.core.Tablero;
import main.nave.base.Barco;
import main.nave.base.IBlindaje;
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

    public void Jugador(String nombre) {
        this.nombre = nombre;
        this.miTablero = new Tablero();
        this.flota = new Barco[NUM_BARCOS];

    }

    public void inicializarFlota() {
        flota[0] = new Acorazado(new BlindajeReforzado());
        flota[1] = new Buque(new BlindajeSimple());
        flota[2] = new Destructor(new BlindajeSimple());
        flota[3] = new Portaaviones(new BlindajeEvasivo());
        flota[4] = new Submarino(new BlindajeEvasivo());
    }

    public void colocarTodaLaFlota() {
    }

    public void realizarTurno() {

    }

    public boolean tieneBarcosAFlote() {
        for (Barco b : flota) {
            if (!b.estaHundido()) {
                return true;
            }
        }
        return false;

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
