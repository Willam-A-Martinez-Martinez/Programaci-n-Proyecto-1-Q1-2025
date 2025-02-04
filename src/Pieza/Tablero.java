/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Pieza;

import javax.swing.JButton;
import javax.swing.JFrame;

/**
 *
 * @author DELL
 */
public class Tablero {
    JButton [][]tableroBoton = new JButton[10][9];
    Color turnoP = Color.ROJO;
    String logUser, oponente;
    
    
    public void generarTablero(JFrame a, JButton [][]tablero){
        int inicioX = 451, inicioY = 82, tamaño = 63;
        
        for (int filas = 0; filas <9 ; filas++) {
            for (int columnas = 0; columnas < 8; columnas++) {
                tablero[filas][columnas] = new JButton();
                tablero[filas][columnas].setBounds(inicioX + (columnas * tamaño), inicioY + (filas * tamaño), tamaño, tamaño);
                a.add(tablero[filas][columnas]);
                
                if(filas!=4){
                    tablero[filas][columnas].setContentAreaFilled(false);
                }
            }
        }
        
        for (int columnas = 0; columnas <8; columnas++) {
            tablero[4][columnas].setBorderPainted(false);
            tablero[4][columnas].setBackground(java.awt.Color.blue);
            tablero[4][columnas].setEnabled(false);
        }
    }
}
