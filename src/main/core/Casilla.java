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
                this.estado=EstadoCasillaEnum.HUNDIDO;
                return this.estado;
            } else {
                this.estado=EstadoCasillaEnum.TOCADO;
                return this.estado;
            }
        }
        this.estado=EstadoCasillaEnum.AGUA_DISPARADA;
        return this.estado;
    }

    public EstadoCasillaEnum consultarEstadoRadar() {
        if (this.estado==EstadoCasillaEnum.BARCO) {
            return EstadoCasillaEnum.AGUA;
        }
        return estado;
    }

    public EstadoCasillaEnum getEstado() {
        return estado;
    }
    public Barco getBarco() {
        return barco;
    }

    public void setEstado(EstadoCasillaEnum estado) {
        this.estado = estado;
    }
}

