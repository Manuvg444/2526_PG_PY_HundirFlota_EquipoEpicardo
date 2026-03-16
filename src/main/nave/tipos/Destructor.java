
//CLASE DESTRUCTOR QUE HEREDA DE BARCO EL CONSTRUCTOR IBLINDAJE QUE HACE REFERENCIA A 
//EL CONSTRUCTOR PRINCIPAL

package main.nave.tipos;

import main.core.Tablero;
import main.localizacion.Coordenada;
import main.nave.base.Barco;
import main.nave.base.IBlindaje;
import main.nave.base.TipoAtaqueEnum;

public class Destructor extends Barco {

    // CONSTRUCTOR IBLINDAJE QUE HACE REFERENCIA AL ORIGINAL

    public Destructor(IBlindaje blindaje) {
        super("Destructor", 2, 2, blindaje);

    }

    @Override
    public TipoAtaqueEnum getAtaqueEspecial() {

        return TipoAtaqueEnum.D_DOBLE;
    }

    // ACTIVA LA HABILIDAD ESPECIAL DEL BARCO EN UNA COORDENADA DEL TABLERO OBJETIVO

    @Override
    public void activarHabilidadEspecial(Tablero tableroObjetivo, Coordenada coordenada) {
        tableroObjetivo.recibirAtaque(coordenada, getAtaqueEspecial());

    }
}
