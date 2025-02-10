package Pieza;

public abstract class Pieza {
    protected Equipo equipo;

    public Pieza(Equipo color) {
        this.equipo = color;
    }
    
    public abstract boolean piezaMovimiento(int filaInicial, int columnaInicial, int filaSiguiente, int columenaSiguiente);

    public Equipo getEquipo() {
        return equipo;
    }
}
