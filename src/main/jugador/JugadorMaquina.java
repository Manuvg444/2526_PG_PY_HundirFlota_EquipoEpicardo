package main.jugador;

import java.util.Random;

import main.core.InformeDisparo;
import main.localizacion.Coordenada;
import main.localizacion.DireccionEnum;
import main.nave.base.Barco;
import main.nave.base.TipoAtaqueEnum;

public class JugadorMaquina extends Jugador {

    private Random random = new Random();

    public JugadorMaquina(String nombre) {
        super(nombre);
        // TODO Auto-generated constructor stub
    }

    @Override
    public void colocarTodaLaFlota() {
        int limite = miTablero.celdas.length;
        for (Barco b : flota) {
            boolean colocado = false;

            while (!colocado) {
                int fila = random.nextInt(limite);
                int col = random.nextInt(limite);
                DireccionEnum d = DireccionEnum.values()[random.nextInt(DireccionEnum.values().length)];

                Coordenada inicio = new Coordenada(col, fila);
                colocado = miTablero.colocarBarco(b, inicio, d);
            }
        }
        System.out.println("La máquina ha colocado toda su flota.");
    }

    @Override
    public void realizarTurno() {
        int limite = miTablero.celdas.length;

        int fila = random.nextInt(limite);
        int col = random.nextInt(limite);

        Coordenada objetivo = new Coordenada(col, fila);

        InformeDisparo informe = tableroRival.recibirAtaque(objetivo, TipoAtaqueEnum.DEFECTO);

        System.out
                .println(nombre + " dispara a (" + fila + ", " + col + ")" + informe.getCoordenadasAfectadas().length);
    }

}
