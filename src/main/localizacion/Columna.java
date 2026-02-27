package main.localizacion;

public class Columna extends Componente{
    
    public Columna(char letra) {
        this.valor = letra - 'A';
    }

    public Columna(int valor) {
        this.valor=valor;
    }
}
