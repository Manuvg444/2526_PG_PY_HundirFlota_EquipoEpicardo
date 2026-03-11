package main.jugador;

import java.util.Random;

import main.core.InformeDisparo;
import main.core.Tablero;
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
        System.out.println("\nTURNO DE LA MÁQUINA: " + nombre);

        Random r = new Random();

        // 1. Obtener barcos con cargas
        Barco[] barcosCarga = getBarcosConCargas();

        boolean usarEspecial = false;
        Barco barcoElegido = null;

        // 2. Decidir si usa ataque especial
        if (barcosCarga.length > 0) {
            int decision = r.nextInt(2); // 0 o 1
            if (decision == 1) {
                usarEspecial = true;
                // Elegir un barco aleatorio con cargas
                int indice = r.nextInt(barcosCarga.length);
                barcoElegido = barcosCarga[indice];
            }
        }

        // 3. Elegir coordenada válida aleatoria
        int fila;
        int col;
        do {
            fila = r.nextInt(Tablero.TAMAÑO);
            col = r.nextInt(Tablero.TAMAÑO);
        } while (!tableroRival.esCoordenadaValida(col, fila));

        Coordenada objetivo = new Coordenada(col, fila);

        // 4. Ejecutar ataque
        InformeDisparo informe;

        if (!usarEspecial) {
            // Ataque normal
            informe = tableroRival.recibirAtaque(objetivo, TipoAtaqueEnum.DEFECTO);
            System.out.println("La máquina dispara de forma normal en (" + fila + ", " + col + ")");
        } else {
            // Ataque especial
            barcoElegido.usarCarga();
            TipoAtaqueEnum ataque = barcoElegido.getAtaqueEspecial();

            informe = tableroRival.recibirAtaque(objetivo, ataque);

            System.out.println("La máquina usa ataque especial " + ataque +
                    " del barco " + barcoElegido.getNombre() +
                    " en (" + fila + ", " + col + ")");
        }

        // 5. Mostrar resultado
        System.out.println("Celdas afectadas: " + informe.getCoordenadasAfectadas().length);

        if (informe.esHundido()) {
            System.out.println("La máquina ha hundido uno de tus barcos.");
        }
    }

}
