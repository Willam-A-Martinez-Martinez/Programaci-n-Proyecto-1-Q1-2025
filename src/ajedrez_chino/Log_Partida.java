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
    String jugador1, jugador2, ganador, perdedor, tipoVictoria;

    public Log_Partida(String jugador1, String jugador2, String ganador, String perdedor, String tipoVictoria) {
        this.jugador1 = jugador1;
        this.jugador2 = jugador2;
        this.ganador = ganador;
        this.perdedor = perdedor;
        this.tipoVictoria = tipoVictoria;
    }

    public String getJugador1() {
        return jugador1;
    }

    public String getJugador2() {
        return jugador2;
    }

    public String getGanador() {
        return ganador;
    }

    public String getPerdedor() {
        return perdedor;
    }

    public String getTipoDeVictoria() {
        return tipoVictoria;
    }
    
    
    
    public String logPartidaImprimir(){
        String tipoV = tipoVictoria.equals("retiro") ? perdedor + " se retiró del juego"
                :ganador + " capturó al rey de " + perdedor;
        String log=("Judador 1: "+jugador1+" VS. Jugador 2: "+jugador2
                +"\nGanador: "+ganador+" | Perdedor: "+perdedor
                +"\nTipo de victoria: \n"+tipoV)+"\n\n";
        return log;
    }
}
