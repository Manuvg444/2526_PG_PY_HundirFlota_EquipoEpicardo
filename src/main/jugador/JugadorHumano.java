package main.jugador;

import java.util.Scanner;
import main.core.InformeDisparo;
import main.localizacion.Coordenada;
import main.localizacion.DireccionEnum;
import main.nave.base.Barco;
import main.nave.base.TipoAtaqueEnum;

public class JugadorHumano extends Jugador {

    public JugadorHumano(String nombre) {
        super(nombre);

    }

    Scanner teclado = new Scanner(System.in);

    @Override

    public void colocarTodaLaFlota() {
        System.out.println("Colocando barcos para " + nombre);

        for (Barco b : flota) {
            boolean colocado = false;

            while (!colocado) {
                System.out.println("Colocando: " + b.getNombre());

                System.out.print("Introduce la coordenada: ");
                Coordenada c = new Coordenada(teclado.next());

                int fila = c.getFila();

                int col = c.getColumna();

                System.out.print("Dirección (NORTE/SUR/ESTE/OESTE): ");
                String dir = teclado.next().toUpperCase();

                Coordenada inicio = new Coordenada(col, fila);
                DireccionEnum d = DireccionEnum.valueOf(dir);

                colocado = miTablero.colocarBarco(b, inicio, d);

                miTablero.imprimirTablero(false);

                if (!colocado) {
                    System.out.println("No se pudo colocar el barco. Intenta de nuevo.");
                }

            }

        }
    }

    @Override
    public void realizarTurno() {
        System.out.printf("\nTURNO DE %s\n", this.nombre);

        System.out.println("\nTU TABLERO:");
        miTablero.imprimirTablero(false);

        System.out.println("\nTABLERO RIVAL:");
        tableroRival.imprimirTablero(true);

        // Mostrar menú
        System.out.println("\nSelecciona acción:");
        System.out.println("1. Disparo normal");

        Barco[] barcosCarga = getBarcosConCargas();
        for (int i = 0; i < barcosCarga.length; i++) {
            Barco b = barcosCarga[i];
            System.out.println((i + 2) + ". Ataque especial del barco " + b.getNombre()
                    + " || Tipo: " + b.getAtaqueEspecial()
                    + " || Vidas: " + b.getVidas()
                    + " || Cargas: " + b.getCargasHabilidad());
        }

        // Pedir opción válida
        int opcion = -1;
        int maxOpcion = barcosCarga.length + 1;

        do {
            System.out.print("\nElige opción: ");
            opcion = teclado.nextInt();
        } while (opcion < 1 || opcion > maxOpcion);

        // Pedir coordenada válida usando el método del tablero
        int fila, col;
        do {
            System.out.print("Introduce la coordenada: ");
            Coordenada c = new Coordenada(teclado.next());

            fila = c.getFila();

            col = c.getColumna();

            if (!tableroRival.esCoordenadaValida(col, fila)) {
                System.out.println("Coordenada no valida");
            }

        } while (!tableroRival.esCoordenadaValida(col, fila));

        Coordenada objetivo = new Coordenada(fila, col);

        InformeDisparo informe;

        // Ejecutar acción
        if (opcion == 1) {
            // Disparo normal
            informe = tableroRival.recibirAtaque(objetivo, TipoAtaqueEnum.DEFECTO);

        } else {
            // Ataque especial
            Barco barcoElegido = barcosCarga[opcion - 2];

            if (barcoElegido.getCargasHabilidad() <= 0) {
                System.out.println("Ese barco no tiene cargas. Se realiza disparo normal.");
                informe = tableroRival.recibirAtaque(objetivo, TipoAtaqueEnum.DEFECTO);
            } else {
                barcoElegido.usarCarga();
                TipoAtaqueEnum ataque = barcoElegido.getAtaqueEspecial();
                informe = tableroRival.recibirAtaque(objetivo, ataque);
            }
        }

        // Mostrar resultado
        System.out.println("\nDisparo realizado.");
        System.out.println("Celdas afectadas: " + informe.getNumAfectados());

        if (informe.esHundido()) {
            System.out.println("¡Has hundido un barco enemigo!");
        }
    }

}
