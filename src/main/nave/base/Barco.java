package main.nave.base;

import main.core.Tablero;
import main.localizacion.Coordenada;

public abstract class Barco {

    // #region Propiedades

    private String nombre;
    private int tamano;
    private int vidas;
    private int cargasHabilidad;
    private IBlindaje blindaje;

    // #endregion

    public Barco(String nombre, int tamano, int cargasHabilidad, IBlindaje blindaje) {
        this.nombre = nombre;
        this.tamano = tamano;
        this.cargasHabilidad = cargasHabilidad;
        this.blindaje = blindaje;
        this.vidas = tamano;
    }

    public abstract void activarHabilidadEspecial(Tablero tableroObjetivo, Coordenada coordenada);

    /*
     * public Barco(IBlindaje blindaje) {
     * this("SinNombre", 1, 0, blindaje);
     * }
     */

    public int recibirImpacto() {
        int danioBase = 1;
        int danioFinal = blindaje.recibirImpacto(danioBase);
        this.vidas -= danioFinal;
        return danioFinal;

    }

    public boolean estaHundido() {
        if (this.vidas > 0)
            return false;
        else
            return true;

    }

    public int usarCarga() {
        if (this.cargasHabilidad > 0) {
            return this.cargasHabilidad = this.cargasHabilidad - 1;
        } else {
            return this.cargasHabilidad = 0;
        }
    }

    public boolean tieneCargas() {
        if (this.cargasHabilidad > 0)
            return true;
        else
            return false;
    }

    public TipoAtaqueEnum getAtaqueEspecial() {
        return TipoAtaqueEnum.DEFECTO;

    }

    public String getNombre() {
        return this.nombre;
    }

    public int getTamano() {
        return this.tamano;
    }

    public int getVidas() {
        return this.vidas;
    }

    public int getCargasHabilidad() {
        return this.cargasHabilidad;
    }

    public void setVidas(int vidas) {
        this.vidas = vidas;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Barco other = (Barco) obj;
        if (nombre == null) {
            if (other.nombre != null)
                return false;
        } else if (this.nombre != other.nombre)
            return false;
        return true;
    }

}
