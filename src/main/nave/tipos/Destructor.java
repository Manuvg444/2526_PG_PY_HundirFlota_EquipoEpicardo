package main.nave.tipos;

import main.nave.base.Barco;
import main.nave.base.IBlindaje;
import main.nave.base.TipoAtaqueEnum;

public class Destructor extends Barco {

    public Destructor(IBlindaje blindaje) {
        super("Destructor", 2, 2, blindaje);

    }

    @Override
    public TipoAtaqueEnum getAtaqueEspecial() {

        return TipoAtaqueEnum.D_DOBLE;
    }

}
