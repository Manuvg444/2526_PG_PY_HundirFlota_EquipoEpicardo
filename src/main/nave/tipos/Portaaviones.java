//CLASE POORTAVIONES QUE HEREDA DE BARCO EL CONSTRUCTOR IBLINDAJE QUE HACE REFERENCIA A 
//EL CONSTRUCTOR PRINCIPAL
package main.nave.tipos;

import main.core.Tablero;
import main.localizacion.Coordenada;
import main.nave.base.Barco;
import main.nave.base.IBlindaje;
import main.nave.base.TipoAtaqueEnum;

public class Portaaviones extends Barco {

    // CONSTRUCTOR IBLINDAJE QUE HACE REFERENCIA AL ORIGINAL

    public Portaaviones(IBlindaje blindaje) {
        super("Portaaviones", 5, 1, blindaje);
    }

    @Override
    public TipoAtaqueEnum getAtaqueEspecial() {

        return TipoAtaqueEnum.R_AEREO;
    }

    // ACTIVA LA HABILIDAD ESPECIAL DEL BARCO EN UNA COORDENADA DEL TABLERO OBJETIVO

    @Override
    public void activarHabilidadEspecial(Tablero tableroObjetivo, Coordenada coordenada) {
        tableroObjetivo.recibirAtaque(coordenada, getAtaqueEspecial());
    }

}
