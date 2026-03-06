package main.core;

import main.nave.base.Barco;

public class Casilla {
    private EstadoCasillaEnum estado;
    private Barco barco;

    public Casilla() {
        estado = EstadoCasillaEnum.AGUA;
    }

    public boolean tieneBarco() {
        if (this.barco==null) {
            return false;
        }
        return true;
    }

    public void colocarBarco(Barco barco) {
        this.barco = barco;
        this.estado = EstadoCasillaEnum.BARCO;
    }

    public EstadoCasillaEnum recibirImpacto() {
        if (tieneBarco()) {
            barco.recibirImpacto();
            if (barco.estaHundido()) {
                return estado.HUNDIDO;
            } else {
                return estado.TOCADO;
            }
        }
        return estado.AGUA_DISPARADA;
    }

    // public EstadoCasillaEnum consultarEstadoRadar() {
        
    // }

    public EstadoCasillaEnum getEstado() {
        return estado;
    }
    public Barco getBarco() {
        return barco;
    }
}

