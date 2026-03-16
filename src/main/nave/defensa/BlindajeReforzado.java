package main.nave.defensa;

import main.nave.base.IBlindaje;

public class BlindajeReforzado implements IBlindaje {

    // SE CREA UN BOLEANO ABSORBIDO ==>

    private boolean absorbido;

    // SE CREA UN CONSTRUCTOR DONDE POR DEFECTO ABSORBIDO ES FALSE ==>

    public BlindajeReforzado() {
        absorbido = false;
    }

    // SI NO ESTÁ ABSORBIDO, EL DAÑO ES 0
    // Y SI NO, EL DAÑO RECIBIDO ES TODO ==>

    @Override
    public int recibirImpacto(int danioEntrante) {

        if (!absorbido) {
            absorbido = true;
            return 0;
        }

        return danioEntrante;

    }

}
