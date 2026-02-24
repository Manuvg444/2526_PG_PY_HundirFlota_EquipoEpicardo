package main.nave.defensa;

import main.nave.base.IBlindaje;

public class BlindajeSimple implements IBlindaje {

    @Override
    public int recibirImpacto(int danioEntrante) {
        return danioEntrante;
    }

}
