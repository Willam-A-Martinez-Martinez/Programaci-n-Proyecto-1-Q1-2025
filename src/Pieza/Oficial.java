/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Pieza;

/**
 *
 * @author DELL
 */
public class Oficial extends Pieza{
    private Tablero tablero;

    public Oficial(Tablero tablero, Equipo color) {
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
            if(columnaSiguiente<=5 && columnaSiguiente>=3 && filaSiguiente<=2 
            && (filaInicial+1==filaSiguiente || filaInicial-1==filaSiguiente) 
            && (columnaInicial-1==columnaSiguiente || columnaInicial+1==columnaSiguiente)){
                return true;
            }
        }else if(equipo==Equipo.NEGRO){
            if(columnaSiguiente<=5 && columnaSiguiente>=3 && filaSiguiente>=8 
            && (filaInicial+1==filaSiguiente || filaInicial-1==filaSiguiente) 
            && (columnaInicial-1==columnaSiguiente || columnaInicial+1==columnaSiguiente)){
                return true;
            }
        }
        return false;
    }
}
