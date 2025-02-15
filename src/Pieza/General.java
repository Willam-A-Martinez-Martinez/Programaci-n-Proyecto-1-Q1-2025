/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Pieza;

/**
 *
 * @author DELL
 */
public class General extends Pieza{
    private Tablero tablero;

    public General(Tablero tablero, Equipo color) {
        super(color);
        this.tablero = tablero;
    }
    
    public boolean piezaMovimiento(int filaInicial, int columnaInicial, int filaSiguiente, int columnaSiguiente){
        
        if(tablero.getSiguienteCoords(filaSiguiente, columnaSiguiente)!=null){
            if(this.equipo.equals(tablero.getSiguienteCoords(filaSiguiente, columnaSiguiente).equipo)){
                return false;
            }
        }
        
        if(equipo==Equipo.ROJO){
            if(columnaSiguiente<=5 && columnaSiguiente>=3 && filaSiguiente<=2 && 
            ((columnaInicial-1==columnaSiguiente && filaInicial==filaSiguiente) || 
            (columnaInicial+1==columnaSiguiente && filaInicial==filaSiguiente) || 
            (filaInicial-1==filaSiguiente && columnaInicial==columnaSiguiente) || 
            (filaInicial+1==filaSiguiente && columnaInicial==columnaSiguiente))){
                return true;
            }
        }else if(equipo==Equipo.NEGRO){
            if(columnaSiguiente<=5 && columnaSiguiente>=3 && filaSiguiente>=8 && 
            ((columnaInicial-1==columnaSiguiente && filaInicial==filaSiguiente) || 
            (columnaInicial+1==columnaSiguiente && filaInicial==filaSiguiente) || 
            (filaInicial-1==filaSiguiente && columnaInicial==columnaSiguiente) || 
            (filaInicial+1==filaSiguiente && columnaInicial==columnaSiguiente))){
                return true;
            }
        }
        return false;
    }
}