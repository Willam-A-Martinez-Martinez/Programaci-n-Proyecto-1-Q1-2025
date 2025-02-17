/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package ajedrez_chino;

/**
 *
 * @author DELL
 */
public interface manejoLog {
    void agregarLog(String jugador1, String jugador2, String ganador, String perdedor, String tipoVictoria);
    int cantLogs();
    String imprimirLogsJuegos();
}
