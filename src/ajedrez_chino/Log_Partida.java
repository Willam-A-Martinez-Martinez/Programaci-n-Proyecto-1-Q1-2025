/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ajedrez_chino;

/**
 *
 * @author DELL
 */
public class Log_Partida {
    String jugador1, jugador2, ganador;

    public Log_Partida(String usuario, String contrincante, String ganador) {
        this.jugador1 = usuario;
        this.jugador2 = contrincante;
        this.ganador = ganador;
    }

    public String getJugador1() {
        return jugador1;
    }

    public void setJugador1(String jugador1) {
        this.jugador1 = jugador1;
    }

    public String getJugador2() {
        return jugador2;
    }

    public void setJugador2(String jugador2) {
        this.jugador2 = jugador2;
    }

    public String getGanador() {
        return ganador;
    }

    public void setGanador(String ganador) {
        this.ganador = ganador;
    }
    
    
    
    public String logPartida(){
        return "Judador 1: "+jugador1+"| Jugador 2: "+jugador2+"\nGanador: "+ganador;
    }
}
