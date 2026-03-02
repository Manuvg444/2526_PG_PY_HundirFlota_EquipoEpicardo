package main.core;

import main.localizacion.Coordenada;

public class InformeDisparo {
    private Coordenada[] coordenadasAfectadas;
    private EstadoCasillaEnum[] estadosResultantes;
    private int numAfectados;
    private boolean hundido;


    public InformeDisparo() {
        coordenadasAfectadas = new Coordenada[20];
        estadosResultantes = new EstadoCasillaEnum[20];
        numAfectados=0;
        hundido=false;
    }

    public void agregar(Coordenada c, EstadoCasillaEnum e) {
        for (int i = 0; i < coordenadasAfectadas.length; i++) {
            if (coordenadasAfectadas[i]==null) {
                coordenadasAfectadas[i]=c;
                estadosResultantes[i]=e;
            }
        }
    }

    public Coordenada[] getCoordenadasAfectadas() {
        return coordenadasAfectadas;
    }

    public EstadoCasillaEnum[] getEstadosResultantes() {
        return estadosResultantes;
    }

    public EstadoCasillaEnum getEstado(int index) {

    }

    public boolean esHundido() {

    }

    public void setEstado(boolean hundido) {
        
    }

}
