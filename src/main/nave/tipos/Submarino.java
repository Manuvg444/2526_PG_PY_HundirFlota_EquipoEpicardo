
//CLASE SUBMARINO QUE HEREDA DE BARCO EL CONSTRUCTOR IBLINDAJE QUE HACE REFERENCIA A 
//EL CONSTRUCTOR PRINCIPAL
package main.nave.tipos;

import main.core.Tablero;
import main.localizacion.Coordenada;
import main.nave.base.Barco;
import main.nave.base.IBlindaje;
import main.nave.base.TipoAtaqueEnum;

public class Submarino extends Barco {

    // CONSTRUCTOR IBLINDAJE QUE HACE REFERENCIA AL ORIGINAL

    public Submarino(IBlindaje blindaje) {
        super("Submarino", 3, 1, blindaje);

    }

    @Override
    public TipoAtaqueEnum getAtaqueEspecial() {

        return TipoAtaqueEnum.INMERSION;
    }

    // ACTIVA LA HABILIDAD ESPECIAL DEL BARCO EN UNA COORDENADA DEL TABLERO OBJETIVO

    @Override
    public void activarHabilidadEspecial(Tablero tableroObjetivo, Coordenada coordenada) {
        tableroObjetivo.recibirAtaque(coordenada, getAtaqueEspecial());
    }

}
