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
                System.out.println("Colocando: " + b);

                System.out.print("Fila inicial: ");
                int fila = teclado.nextInt();

                System.out.print("Columna inicial: ");
                int col = teclado.nextInt();

                System.out.print("Dirección (NORTE/SUR/ESTE/OESTE): ");
                String dir = teclado.next().toUpperCase();

                Coordenada inicio = new Coordenada(col, fila);
                DireccionEnum d = DireccionEnum.valueOf(dir);

                colocado = miTablero.colocarBarco(b, inicio, d);

                if (!colocado) {
                    System.out.println("No se pudo colocar el barco. Intenta de nuevo.");
                }

            }

        }
    }

    @Override
    public void realizarTurno() {

        System.out.println(nombre + ", elige dónde disparar.");

        System.out.print("Fila: ");
        int fila = teclado.nextInt();

        System.out.print("Columna: ");
        int col = teclado.nextInt();

        Coordenada objetivo = new Coordenada(col, fila);

        InformeDisparo informe = tableroRival.recibirAtaque(objetivo, TipoAtaqueEnum.DEFECTO);

        System.out.println("Disparo realizado. Celdas afectadas: " + informe.getCoordenadasAfectadas().length);
    }
}
