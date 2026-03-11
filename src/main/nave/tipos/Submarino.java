package main.nave.tipos;

import main.core.Tablero;
import main.localizacion.Coordenada;
import main.nave.base.Barco;
import main.nave.base.IBlindaje;
import main.nave.base.TipoAtaqueEnum;

public class Submarino extends Barco {

    public Submarino(IBlindaje blindaje) {
        super("Submarino", 3, 1, blindaje);

    }

    @Override
    public TipoAtaqueEnum getAtaqueEspecial() {

        return TipoAtaqueEnum.INMERSION;
    }

    @Override
    public void activarHabilidadEspecial(Tablero tableroObjetivo, Coordenada coordenada) {
        tableroObjetivo.recibirAtaque(coordenada, getAtaqueEspecial());
    }

}
