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
        
        if(this.equipo.equals(tablero.getSiguienteCoords(filaSiguiente, columnaSiguiente).equipo)){
            return false;
        }
        
        if(equipo==Equipo.ROJO){
            if(((filaInicial>filaSiguiente || filaInicial<filaSiguiente) && columnaInicial==columnaSiguiente) || 
                    ((columnaInicial>columnaSiguiente || columnaInicial<columnaSiguiente) && filaInicial==filaSiguiente)){
                return true;
            }
        }else if(equipo==Equipo.NEGRO){
            
        }
        return false;
    }
}
