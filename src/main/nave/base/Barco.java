package main.nave.base;

import main.core.Tablero;
import main.localizacion.Coordenada;

//RECUERDA BARCO ES UNA CLASE ABSTRACTA

public abstract class Barco {

    // #region Propiedades

    private String nombre;
    private int tamano;
    private int vidas;
    private int cargasHabilidad;
    private IBlindaje blindaje;

    // #endregion

    // ESTE ES EL CONSTRUCTOR PRINCIPAL AL QUE HACE REFERENCIA EL CONSTRUCTOR
    // IBLINDAJE ==>

    public Barco(String nombre, int tamano, int cargasHabilidad, IBlindaje blindaje) {
        this.nombre = nombre;
        this.tamano = tamano;
        this.cargasHabilidad = cargasHabilidad;
        this.blindaje = blindaje;
        this.vidas = tamano;
    }

    // RECUERDA, ES UN MÉTODO ABSTRACT, POR LO QUE SON LAS CLASES HIJAS LAS QUE
    // DEFINEN EL MÉTODO ==>

    public abstract void activarHabilidadEspecial(Tablero tableroObjetivo, Coordenada coordenada);

    /*
     * public Barco(IBlindaje blindaje) {
     * this("SinNombre", 1, 0, blindaje);
     * }
     */

    // MÉTODO RECIBIR IMPACTO, EL DAÑO BASE ES 1, Y EL DAÑO FINAL ES EL BLINDAJE
    // TRAS RECIBIR EL IMPACTO
    // ESE OTRO MÉTODO DE RECIBIR IMPACTO VIENE DE LA INTERFAZ IBLINDAJE PARA QUE
    // LOS BLINDAJES LO PUEDAN UTILIZAR ==>

    public int recibirImpacto() {
        int danioBase = 1;
        int danioFinal = blindaje.recibirImpacto(danioBase);
        this.vidas -= danioFinal;
        return danioFinal;

    }

    // RETORNA FALSE SI THIS.VIDAS SON MAYOR QUE 0, Y RETORNA TRUE SI YA NO LE
    // QUEDAN VIDAS ==>

    public boolean estaHundido() {
        if (this.vidas > 0)
            return false;
        else
            return true;

    }

    // ESTE MÉTODO QUITA UNA CARGA POR TURNO, SI TIENE MÁS DE 0, LE QUITA UNA CARGA,
    // SI NO TIENE CARGAS, SE QUEDA EN 0.

    public int usarCarga() {
        if (this.cargasHabilidad > 0) {
            return this.cargasHabilidad = this.cargasHabilidad - 1;
        } else {
            return this.cargasHabilidad = 0;
        }
    }

    // EL BARCO TIENE CARGAS MIENTRAS LAS CARGAS SEAN MAYOR A 0

    public boolean tieneCargas() {
        if (this.cargasHabilidad > 0)
            return true;
        else
            return false;
    }

    // ESTE MÉTODO ES SOBREESCRITO EN CADA BARCO, ESTO ES POR DEFECTO

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
