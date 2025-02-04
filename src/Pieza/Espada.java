package Pieza;

public class Espada extends Pieza{
    
    
    
    public Espada(Color color) {
        super(color);
    }
    
    
    public boolean piezaMovimiento(int filaInicial, int columnaInicial, int filaSiguiente, int columnaSiguiente){
        if(filaInicial+1==filaSiguiente && columnaInicial==columnaSiguiente){
            return true;
        }
        return false;
    };
}
