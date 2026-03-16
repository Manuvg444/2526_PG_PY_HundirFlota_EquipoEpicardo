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

                Coordenada c;
                do {
                    System.out.print("Introduce la coordenada: ");
                    String entrada=teclado.next();
                    if (Coordenada.esValida(entrada)) {
                        c = new Coordenada(entrada);
                        break;
                    }
                    System.out.println("Coordenada mal introducida, vuelve a introducirla");
                } while (true);

                int fila = c.getFila();

                int col = c.getColumna();


                String dir;
                do {
                    System.out.print("Dirección (NORTE/SUR/ESTE/OESTE): ");
                    dir = teclado.next().toUpperCase();
                    if (dir.equals("NORTE") || dir.equals("SUR") || dir.equals("ESTE") || dir.equals("OESTE")) {
                        break;
                    }
                    System.out.println("Dirección mal introducida, vuelve a introducirla");
                } while (true);
              


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
        boolean opcionValida;
        do {
            System.out.print("\nElige opción: ");
            String entrada = teclado.next();
            
                try {
                    Integer.parseInt(entrada);
                    opcionValida=true;
                    opcion=Integer.parseInt(entrada);
                } catch (NumberFormatException e) {
                    System.out.println("Opción introducida incorrectamente");
                    opcionValida=false;
                }
        } while (opcion < 1 || opcion > maxOpcion || !opcionValida);


        // Pedir coordenada válida usando el método del tablero
        int fila, col;
        Coordenada c;
        do {
            do {
                System.out.print("Introduce la coordenada: ");
                String entrada=teclado.next();
                if (Coordenada.esValida(entrada)) {
                    c = new Coordenada(entrada);
                    break;
                }
                System.out.println("Coordenada mal introducida, vuelve a introducirla");
            } while (true);

            fila = c.getFila();

            col = c.getColumna();

            if (!tableroRival.esCoordenadaValida(col, fila)) {
                System.out.println("Coordenada no valida");
            }
        } while (!tableroRival.esCoordenadaValida(col, fila));

        Coordenada objetivo = new Coordenada(col, fila);

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
