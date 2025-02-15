package Pieza;

public class Cañon extends Pieza{
    private Tablero tablero;

    public Cañon(Tablero tablero, Equipo color) {
        super(color);
        this.tablero = tablero;
    }
    
    public boolean piezaMovimiento(int filaInicial, int columnaInicial, int filaSiguiente, int columnaSiguiente){
        
        if(tablero.getSiguienteCoords(filaSiguiente, columnaSiguiente)!=null){
            if(this.equipo.equals(tablero.getSiguienteCoords(filaSiguiente, columnaSiguiente).equipo)){
                return false;
            }
        }
        
        if((columnaInicial==columnaSiguiente || filaInicial==filaSiguiente) && filaSiguiente!=5){
            if(!tablero.existePieza(filaSiguiente, columnaSiguiente)){
                return !piezaDetener(filaInicial, columnaInicial, filaSiguiente, columnaSiguiente);
            }else{
                return salto(filaInicial, columnaInicial, filaSiguiente, columnaSiguiente);
            }
        }
        return false;
    }
    
    public boolean piezaDetener(int filaInicial, int columnaInicial, int filaSiguiente, int columnaSiguiente){
        
        
        if(columnaInicial==columnaSiguiente){
            int filaMin= Math.min(filaInicial, filaSiguiente);
            int filaMax= Math.max(filaInicial, filaSiguiente);
            
            for (int fil = filaMin+1; fil < filaMax; fil++) {
                if(tablero.existePieza(fil, columnaInicial)){
                    return true;
                }
            }
        }
        if(filaInicial==filaSiguiente){
            int columMin= Math.min(columnaInicial, columnaSiguiente);
            int columMax= Math.max(columnaInicial, columnaSiguiente);
            
            for (int colum = columMin+1; colum < columMax; colum++) {
                if(tablero.existePieza(filaInicial, colum)){
                    return true;
                }
            }
        }
        return false;
    }
    
    public boolean salto(int filaInicial, int columnaInicial, int filaSiguiente, int columnaSiguiente){
        int piezaIntercept =0;
        
        if(columnaInicial==columnaSiguiente){
            int filaMin= Math.min(filaInicial, filaSiguiente);
            int filaMax= Math.max(filaInicial, filaSiguiente);
            
            for (int fil = filaMin+1; fil < filaMax; fil++) {
                if(tablero.existePieza(fil, columnaInicial)){
                    piezaIntercept++;
                }
            }
        }
        if(filaInicial==filaSiguiente){
            int columMin= Math.min(columnaInicial, columnaSiguiente);
            int columMax= Math.max(columnaInicial, columnaSiguiente);
            
            for (int colum = columMin+1; colum < columMax; colum++) {
                if(tablero.existePieza(filaInicial, colum)){
                    piezaIntercept++;
                }
            }
        }
        
        return piezaIntercept==1 && tablero.existePieza(filaSiguiente, columnaSiguiente);
    }
}
