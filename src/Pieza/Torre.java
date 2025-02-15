/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Pieza;

/**
 *
 * @author DELL
 */
public class Torre extends Pieza{
    private Tablero tablero;

    public Torre(Tablero tablero, Equipo color) {
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
            if(!piezaDetener(filaInicial, columnaInicial, filaSiguiente, columnaSiguiente)){
                return true;
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
}
