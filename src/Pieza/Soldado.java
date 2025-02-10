package Pieza;

public class Soldado extends Pieza{
    
    private Tablero tablero;

    public Soldado(Tablero tablero, Equipo equipo) {
        super(equipo);
        this.tablero = tablero;
    }
    
    
    
    
    public boolean piezaMovimiento(int filaInicial, int columnaInicial, int filaSiguiente, int columnaSiguiente){
        
        
        if(equipo==Equipo.ROJO){
            if(filaInicial+1==filaSiguiente && columnaInicial==columnaSiguiente){
                return true;
            
            }
        }
        
        return false;
    
    }
}
