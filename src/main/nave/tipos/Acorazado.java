
//CLASE ACORAZADO QUE HEREDA DE BARCO EL CONSTRUCTOR IBLINDAJE QUE HACE REFERENCIA A 
//EL CONSTRUCTOR PRINCIPAL

package main.nave.tipos;

import main.core.Tablero;
import main.localizacion.Coordenada;
import main.nave.base.Barco;
import main.nave.base.IBlindaje;
import main.nave.base.TipoAtaqueEnum;

public class Acorazado extends Barco {

    // CONSTRUCTOR IBLINDAJE QUE HACE REFERENCIA AL ORIGINAL

    public Acorazado(IBlindaje blindaje) {
        super("Acorazado", 4, 1, blindaje);
    }

    @Override
    public TipoAtaqueEnum getAtaqueEspecial() {
        return TipoAtaqueEnum.B_ZONA;
    }

    // ACTIVA LA HABILIDAD ESPECIAL DEL BARCO EN UNA COORDENADA DEL TABLERO OBJETIVO

    @Override
    public void activarHabilidadEspecial(Tablero tableroObjetivo, Coordenada coordenada) {
        tableroObjetivo.recibirAtaque(coordenada, getAtaqueEspecial());
    }

}
