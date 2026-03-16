package main.nave.defensa;

import main.nave.base.IBlindaje;

public class BlindajeSimple implements IBlindaje {

    // EL BLINDAJE ES SIMPLE, ASÍ QUE REBIBE TODO EL DAÑO==>

    @Override
    public int recibirImpacto(int danioEntrante) {
        return danioEntrante;
    }

}
