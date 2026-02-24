package main.nave.defensa;

import java.util.Random;

import main.nave.base.IBlindaje;

public class BlindajeEvasivo implements IBlindaje {

    /* BlindajeEvasivo: Tiene probabilidad (ej. 20%) de esquivar el disparo. */

    Random rnd = new Random();

    public double prob = rnd.nextDouble();

    @Override
    public int recibirImpacto(int danioEntrante) {
        if (prob < 0.20) {
            return danioEntrante = 0;
        } else {
            return danioEntrante;
        }
    }

}
