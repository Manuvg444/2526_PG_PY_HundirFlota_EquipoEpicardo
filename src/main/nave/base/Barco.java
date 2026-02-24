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
    }

    public int recibirImpacto() {
    
    }

    public boolean estaHundido() {
        return false;
    }

    public void usarCarga() {

    }

    public boolean tieneCargas() {
        return true;
    }

    public TipoAtaqueEnum getAtaqueEspecial() {

        return;

    }

    public String getNombre() {
        return nombre;
    }

    public int getTamano() {
        return tamano;
    }

    public int getVidas() {
        return vidas;
    }

}
