package main.nave.defensa;

import main.nave.base.IBlindaje;

public class BlindajeReforzado implements IBlindaje {

    private boolean absorbido;

    public BlindajeReforzado() {
        absorbido = false;
    }

    @Override
    public int recibirImpacto(int danioEntrante) {

        if (!absorbido) {
            absorbido = true;
            return 0;
        }

        return danioEntrante;

    }

}
