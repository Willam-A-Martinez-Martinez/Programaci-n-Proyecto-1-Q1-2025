package Pieza;

public abstract class Pieza {
    Color color;

    public Pieza(Color color) {
        this.color = color;
    }
    
    public abstract boolean piezaMovimiento(int filaInicial, int columnaInicial, int filaSiguiente, int columenaSiguiente);

    public Color getColor() {
        return color;
    }
}
