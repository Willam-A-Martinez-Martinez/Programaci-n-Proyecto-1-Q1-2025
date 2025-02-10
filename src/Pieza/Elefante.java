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
        
        if(this.equipo.equals(tablero.getPiezaComer(filaSiguiente, columnaSiguiente).equipo)){
            return false;
        }
        return false;
    }
}
