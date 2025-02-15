package Pieza;

public class Caballo extends Pieza{
    private Tablero tablero;

    public Caballo(Tablero tablero, Equipo color) {
        super(color);
        this.tablero = tablero;
    }
    
    public boolean piezaMovimiento(int filaInicial, int columnaInicial, int filaSiguiente, int columnaSiguiente){
        
        if(tablero.getSiguienteCoords(filaSiguiente, columnaSiguiente)!=null){
            if(this.equipo.equals(tablero.getSiguienteCoords(filaSiguiente, columnaSiguiente).equipo)){
                return false;
            }
        }
        if(((Math.abs(filaInicial-filaSiguiente)==2 && Math.abs(columnaInicial-columnaSiguiente)==1)
           || (Math.abs(columnaInicial-columnaSiguiente)==2 && Math.abs(filaInicial-filaSiguiente)==1)) && filaSiguiente!=5){
            if(Math.abs(filaInicial-filaSiguiente)==2){
                int fila=(filaInicial+filaSiguiente)/2;
                if(!tablero.existePieza(fila, columnaInicial)){
                    return true;
                }
            }else{
                int columna=(columnaInicial+columnaSiguiente)/2;
                if(!tablero.existePieza(filaInicial, columna)){
                    return true;
                }
            }
        }
        
        return false;
    }
}
