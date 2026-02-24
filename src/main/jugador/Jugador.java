package main.jugador;

import main.core.Tablero;

public class Jugador {

    private int NUM_BARCOS;
    protected String nombre;
    protected Tablero miTablero;
    protected Tablero tableroRival;
    protected Barco[] flota;

    public void Jugador(String nombre) {
    }

    public void inicializarFlota() {
    }

    public void colocarTodaLaFlota() {
    }

    public void realizarTurno() {
    }

    public boolean tieneBarcosAFlote() {
        if (NUM_BARCOS < 0) {
            return false;
        } else {
            return true;
        }
    }

    public Tablero getMiTablero() {
        return miTablero;
    }

    public Tablero getTableroRival() {
        return tableroRival;
    }

    public void setTableroRival(Tablero t) {

    }

}
