package main.localizacion;

public class Columna extends Componente{
    
    public Columna(String letra) {
        this.valor = letra.charAt(0) - 'A';
    }

    public Columna(int valor) {
        this.valor=valor;
    }

    @Override
    public String toString() {
        return String.valueOf((char)('A'+this.valor));
    }
}
