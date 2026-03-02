package main.localizacion;

public class Fila extends Componente {
    public Fila(int numero) {
        this.valor = numero;
    }

    @Override
    public String toString() {
        return Integer.toString(this.valor+1);
    }

}
