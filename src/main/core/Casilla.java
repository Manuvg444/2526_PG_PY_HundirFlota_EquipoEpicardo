package main.core;

import main.nave.base.Barco;

public class Casilla {
    private EstadoCasillaEnum estado;
    private Barco barco;

    public Casilla() {
        estado = EstadoCasillaEnum.AGUA;
    }

    public boolean tieneBarco() {
        if (barco!=null) {
            return true;
        }
        return false;
    }

    public void colocarBarco (Barco barco) {
        this.barco = barco;
    }

    public EstadoCasillaEnum recibirImpacto() {
        if (tieneBarco()) {
            if (barco.recibirImpacto()>=barco.getVidas()) {
                return estado.HUNDIDO;
            } else {
                return estado.TOCADO;
            }
        }
        return estado.AGUA;
    }

    public EstadoCasillaEnum consultarEstadoRadar() {
        
    }

    public EstadoCasillaEnum getEstado() {
        return estado;
    }
    public Barco getBarco() {
        return barco;
    }
}

