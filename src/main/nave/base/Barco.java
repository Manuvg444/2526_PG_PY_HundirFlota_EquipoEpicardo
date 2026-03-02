package main.nave.base;

public class Barco {

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

    public Barco(IBlindaje blindaje) {
        this("SinNombre", 1, 0, blindaje);
    }

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
        return this.cargasHabilidad - 1;
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

    public void setVidas(int vidas) {
        this.vidas = vidas;
    }

}
