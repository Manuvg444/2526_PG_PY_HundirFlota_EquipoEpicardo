package main.nave.defensa;

import main.nave.base.IBlindaje;

public class BlindajeSimple implements IBlindaje {

    static int recibirImpacto(int danioEntrante) {
        return danioEntrante;
    }

}
