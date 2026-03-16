package main.localizacion;

public class Coordenada {

    private Fila fila;
    private Columna columna;

    public Coordenada(String entrada) {
    // 1. Extraer la letra (0) y el número (desde 1 hasta el final)
    // Esto separa la coordenada introducida (ej: "C3") en: "letra" (la letra o columna) , y "resto" (el número o fila)
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

    // Este es otro constructor para coordenada, que recibe directamente columna y fila:
    public Coordenada (int numColumna, int numFila) {
        this.columna = new Columna(numColumna);
        this.fila=new Fila(numFila);
    }

    public int getColumna() {
        return columna.getValue();
    }
    public int getFila() {
        return fila.getValue();
    }

    @Override
    public String toString() {
        return columna.toString() + "-" + fila.toString();
    }


    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Coordenada other = (Coordenada) obj;
        if (fila == null) {
            if (other.fila != null)
                return false;
        } else if (fila.getValue()!=other.fila.getValue())
            return false;
        if (columna == null) {
            if (other.columna != null)
                return false;
        } else if (columna.getValue()!=other.columna.getValue())
            return false;
        return true;
    }
}
