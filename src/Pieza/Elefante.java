/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Pieza;

/**
 *
 * @author DELL
 */
public class Elefante extends Pieza{
    private Tablero tablero;

    public Elefante(Tablero tablero, Equipo color) {
        super(color);
        this.tablero = tablero;
    }
    
    public boolean piezaMovimiento(int filaInicial, int columnaInicial, int filaSiguiente, int columnaSiguiente){
        
        if(tablero.getSiguienteCoords(filaSiguiente, columnaSiguiente)!=null){
            if(equipo.equals(tablero.getSiguienteCoords(filaSiguiente, columnaSiguiente).equipo)){
                return false;
            }
        }
        if(equipo==Equipo.ROJO){
            if((Math.abs(filaInicial-filaSiguiente)==2 && Math.abs(columnaInicial-columnaSiguiente)==2) && filaSiguiente<5){
                int coordMedioF= (filaInicial+filaSiguiente)/2;
                int coordMedioC= (columnaInicial+columnaSiguiente)/2;
                if((!tablero.existePieza(coordMedioF, coordMedioC)) 
                && filaSiguiente<5){
                    return true;
                }
            }
        }
        if(equipo==Equipo.NEGRO){
            if((Math.abs(filaInicial-filaSiguiente)==2 && Math.abs(columnaInicial-columnaSiguiente)==2) && filaSiguiente>5){
                int coordMedioF= (filaInicial+filaSiguiente)/2;
                int coordMedioC= (columnaInicial+columnaSiguiente)/2;
                if((!tablero.existePieza(coordMedioF, coordMedioC)) 
                && filaSiguiente<5){
                    return true;
                }
            }
        }
        return false;
    }
}
