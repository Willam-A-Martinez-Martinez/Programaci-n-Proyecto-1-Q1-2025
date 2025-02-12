package Pieza;

public class Caballo extends Pieza{
    private Tablero tablero;

    public Caballo(Tablero tablero, Equipo color) {
        super(color);
        this.tablero = tablero;
    }
    
    public boolean piezaMovimiento(int filaInicial, int columnaInicial, int filaSiguiente, int columnaSiguiente){
        
        if(this.equipo.equals(tablero.getSiguienteCoords(filaSiguiente, columnaSiguiente).equipo)){
            return false;
        }
        return false;
    }
}
