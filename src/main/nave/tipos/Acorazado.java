package main.nave.tipos;

import main.nave.base.Barco;
import main.nave.base.IBlindaje;
import main.nave.base.TipoAtaqueEnum;

public class Acorazado extends Barco {

    public Acorazado(IBlindaje blindaje) {
        super("Acorazado", 4, 1, blindaje);
    }

    @Override
    public TipoAtaqueEnum getAtaqueEspecial() {
        return TipoAtaqueEnum.B_ZONA;
    }

}
