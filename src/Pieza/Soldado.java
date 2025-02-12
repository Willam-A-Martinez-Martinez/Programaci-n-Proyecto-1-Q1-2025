package Pieza;

public class Soldado extends Pieza{
    
    private Tablero tablero;

    public Soldado(Tablero tablero, Equipo equipo) {
        super(equipo);
        this.tablero = tablero;
    }
    
    
    
    
    public boolean piezaMovimiento(int filaInicial, int columnaInicial, int filaSiguiente, int columnaSiguiente){
        
        if(tablero.getSiguienteCoords(filaSiguiente, columnaSiguiente)!=null){
            if(this.equipo.equals(tablero.getSiguienteCoords(filaSiguiente, columnaSiguiente).equipo)){
                return false;
            }
        }
        if(equipo==Equipo.ROJO){
            
            if(filaInicial>=0 && filaInicial<4){
                if(filaInicial+1==filaSiguiente && columnaInicial==columnaSiguiente){
                    return true;
                }
            }else if(filaInicial==4){
                if(filaInicial+2==filaSiguiente && columnaInicial==columnaSiguiente){
                    return true;
                }
            }else if(filaInicial>=6 && filaInicial<=10){
                if((filaInicial+1==filaSiguiente && columnaInicial==columnaSiguiente) || (filaInicial==filaSiguiente && (columnaInicial+1==columnaSiguiente || columnaInicial-1==columnaSiguiente))){
                    return true;
                }
            }
        }else if(equipo==Equipo.NEGRO){
            if(filaInicial>6 && filaInicial<=10){
                if(filaInicial-1==filaSiguiente && columnaInicial==columnaSiguiente){
                    return true;
                }
            }else if(filaInicial==6){
                if(filaInicial-2==filaSiguiente && columnaInicial==columnaSiguiente){
                    return true;
                }
            }else if(filaInicial>=0 && filaInicial<=4){
                if((filaInicial-1==filaSiguiente && columnaInicial==columnaSiguiente) || (filaInicial==filaSiguiente && (columnaInicial-1==columnaSiguiente || columnaInicial+1==columnaSiguiente))){
                    return true;
                }
            }
        }
        return false;
    }
}
