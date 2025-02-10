package Pieza;

public class Cañon extends Pieza{
    private Tablero tablero;

    public Cañon(Tablero tablero, Equipo color) {
        super(color);
        this.tablero = tablero;
    }
    
    public boolean piezaMovimiento(int filaInicial, int columnaInicial, int filaSiguiente, int columnaSiguiente){
        
        if(this.equipo.equals(tablero.getPiezaComer(filaSiguiente, columnaSiguiente).equipo)){
            return false;
        }
        return false;
    }
}
