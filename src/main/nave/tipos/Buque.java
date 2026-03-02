package main.nave.tipos;

import main.nave.base.Barco;
import main.nave.base.IBlindaje;
import main.nave.base.TipoAtaqueEnum;

public class Buque extends Barco {

    public Buque(IBlindaje blindaje) {
        super("Buque", 4, 1, blindaje);

    }

    @Override
    public TipoAtaqueEnum getAtaqueEspecial() {
        return TipoAtaqueEnum.A_CRUZ;
    }

}
