package main.nave.defensa;

import java.util.Random;

import main.nave.base.IBlindaje;

public class BlindajeEvasivo implements IBlindaje {

    /* BlindajeEvasivo: Tiene probabilidad (ej. 20%) de esquivar el disparo. */

    // SE HACE UN RANDOM QUE CREA UN NÚMERO DECIMAL DE 0 AL 1 ==>

    Random rnd = new Random();

    public double prob = rnd.nextDouble();

    // SI ESE RANDOM ES MAYOR QUE LA PROBABILIDAD (20% DE PROBABILIDAD) NO RECIBE
    // DAÑO
    // SI EL RANDOM ES MAYOR, EL BARCO RECIBE TODO EL DAÑO RECIBIDO ==>

    @Override
    public int recibirImpacto(int danioEntrante) {
        prob = rnd.nextDouble();
        if (prob < 0.20) {
            return danioEntrante = 0;
        } else {
            return danioEntrante;
        }
    }

}
