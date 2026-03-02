package main.nave.tipos;

import main.nave.base.Barco;
import main.nave.base.IBlindaje;
import main.nave.base.TipoAtaqueEnum;

public class Portaaviones extends Barco {

    public Portaaviones(IBlindaje blindaje) {
        super("Portaaviones", 5, 1, blindaje);
    }

    @Override
    public TipoAtaqueEnum getAtaqueEspecial() {

        return TipoAtaqueEnum.R_AEREO;
    }

}
