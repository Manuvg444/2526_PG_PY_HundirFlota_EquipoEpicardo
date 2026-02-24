package main.localizacion;

public class Coordenada {

    private Fila fila;
    private Columna columna;

    public Coordenada(String entrada) {
    // 1. Extraer la letra (0) y el número (desde 1 hasta el final)
    char letra = entrada.toUpperCase().charAt(0);
    String resto = entrada.substring(1);
    
    // 2. Convertir letra a índice (A=0, B=1...) Esto se hace así porque en ASCII la A es el 65, la B el 66...
    // B-A = 66-65 = 1
    int colIndex = letra - 'A';
    
    // 3. Convertir número a índice (1=0, 2=1...)
    int filaIndex = Integer.parseInt(resto) - 1;
    
    // 4. Instanciar componentes
    this.fila = new Fila(filaIndex);
    this.columna = new Columna(colIndex);
    }

    public Coordenada (int numColumna, int numFila) {
        this.columna = new Columna(numColumna);
        this.fila=new Fila(numFila);
    }

    public Columna getColumna() {
        return columna;
    }
    public Fila getFila() {
        return fila;
    }
}
