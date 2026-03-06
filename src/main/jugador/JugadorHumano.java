package main.jugador;

import java.util.Scanner;

import main.core.Casilla;
import main.core.Tablero;
import main.localizacion.Coordenada;
import main.nave.base.Barco;
import main.nave.base.IBlindaje;
import main.nave.base.TipoAtaqueEnum;
import main.nave.tipos.Acorazado;
import main.nave.tipos.Buque;
import main.nave.tipos.Destructor;
import main.nave.tipos.Portaaviones;
import main.nave.tipos.Submarino;
import main.nave.defensa.BlindajeEvasivo;
import main.nave.defensa.BlindajeReforzado;
import main.nave.defensa.BlindajeSimple;

public class JugadorHumano extends Jugador {

    public JugadorHumano(String nombre) {
        super("Jugador Humano");

    }

    // #region Barcos
    Barco portaviones = new Portaaviones(new BlindajeSimple());
    Barco buque = new Buque(new BlindajeSimple());
    Barco destructor = new Destructor(new BlindajeSimple());
    Barco acorazado = new Acorazado(new BlindajeReforzado());
    Barco submarino = new Submarino(new BlindajeEvasivo());

    Coordenada tarjet = null;
    // #endregion

    @Override
    public void colocarTodaLaFlota() {

        super.colocarTodaLaFlota();
    }

    @Override
    public void realizarTurno() {

        System.out.println("---TABLERO RIVAL---");
        miTablero.imprimirTablero(false);
        tableroRival.imprimirTablero(true);

        Scanner teclado = new Scanner(System.in);

        System.out.println("Turno del jugador humano, te toca");
        System.out.println("---Seleccione una opción---");
        System.out.println("1.Ataque Normal");

        if (portaviones.tieneCargas() || buque.tieneCargas() || destructor.tieneCargas() || acorazado.tieneCargas()
                || submarino.tieneCargas()) {

            System.out.println("2.Ataque Especial");
            System.out.println("Las cargas restantes del portaviones son:" + portaviones.getCargasHabilidad());
            System.out.println("Las cargas restantes del buque son:" + buque.getCargasHabilidad());
            System.out.println("Las cargas restantes del destructor son:" + destructor.getCargasHabilidad());
            System.out.println("Las cargas restantes del acorazado son:" + acorazado.getCargasHabilidad());
            System.out.println("Las cargas restantes del submarino son:" + submarino.getCargasHabilidad());

        } else {

            System.out.println("No se pueden realizar ataques especiales, !!!has agotado las cargas¡¡¡");
        }

        int opcion = teclado.nextInt();

        switch (opcion) {
            case 1:

                System.out.println("¿A qué casilla quieres atacar");
                tarjet = new Coordenada(teclado.nextLine());

                tableroRival.recibirAtaque(tarjet, TipoAtaqueEnum.DEFECTO);

                break;

            case 2:

                break;

            default:
                System.out.println("No has elegido ninguna opción");
                break;
        }

    }

}
