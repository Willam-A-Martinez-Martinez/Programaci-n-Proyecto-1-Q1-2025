/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ajedrez_chino;

import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JToggleButton;

/**
 *
 * @author DELL
 */
public class Pg_Principal extends Grafico{
    //Libreria swing
    JFrame frame = new JFrame();
    JLabel menuPrincipal = new JLabel();
    JLabel backgroundForWords = new JLabel();
    JLabel background = new JLabel();
    JLabel miniVentana = new JLabel();
    JButton nuevaPartida = new JButton();
    JToggleButton miCuenta = new JToggleButton();
    JToggleButton verMiInformacion = new JToggleButton();
    JButton cambiarPassword = new JButton();
    JButton cerrarMiCuenta = new JButton();
    JToggleButton reportesMenu = new JToggleButton();
    JButton rankingJugadores = new JButton();
    JButton logsDeJuegos = new JButton();
    JButton logOut = new JButton();
    

    
    //Imagenes
    ImageIcon logoXiangqi= new ImageIcon("src/Imagenes/xiangqi.png");
    ImageIcon backgroundI= new ImageIcon("src/Imagenes/Background.gif");
    
    //Info de usuarios
    Pg_Inicial pgInicial;
    
        
    public Pg_Principal(Pg_Inicial pgInicial){
        this.pgInicial =pgInicial;
        
        //FRAME
        confFrame(frame, logoXiangqi, "Segmented & Corp", 1300, 1000);

        frame.add(menuPrincipal);
        frame.add(nuevaPartida);
        frame.add(miCuenta);
        frame.add(miniVentana);
        frame.add(reportesMenu);
        frame.add(logOut);
        frame.add(verMiInformacion);
        frame.add(cambiarPassword);
        frame.add(cerrarMiCuenta);
        frame.add(rankingJugadores);
        frame.add(logsDeJuegos);
        frame.add(backgroundForWords);
        frame.add(background);
        frame.setVisible(true);
        
        //BACKGROUND
        fondo(background, 50, 50, backgroundI, frame);

        postBackground(backgroundForWords, 40, 20, 1200, 700, 171, 49, 19, 150, true);

        //Mini ventana
        
        postBackground(miniVentana, 500, 100, 700, 500, 171, 49, 19, 220, true);
        
        //TITULO
        titulo(menuPrincipal, 150, 71, 300, 50, "Dialog", 28, 237, 235, 130, 250, "Menu principal");

        //BOTON 1 Nueva partida
        boton(nuevaPartida, 132, 180, 235, 42, false, false, "Dialog", 28, "Nueva partida", 237, 235, 130, 250);

        //BOTON 2 miCuenta
        toggleButton(miCuenta, 105, 250, 235, 42, false, false, "Dialog", 28, "Mi cuenta", 237, 235, 130, 250);
        miCuenta.setSelected(false); 
        
            //BOTON 2.1 Ver Mi Información
            toggleButton(verMiInformacion, 130, 290, 360, 42, false, false, "Dialog", 28, "", 237, 235, 130, 250);
            verMiInformacion.setEnabled(false);

                //Ver Mi Información, Cambiar Password, Cerrar mi Cuenta

                //BOTON 2.1.1 Cambiar password
                boton(cambiarPassword, 180, 330, 300, 42, false, false, "Dialog", 28, "", 237, 235, 130, 250);
                cambiarPassword.setEnabled(false);
                
                //BOTON 2.1.2 cerrar mi cuenta
                boton(cerrarMiCuenta, 155, 370, 325, 42, false, false, "Dialog", 28, "", 237, 235, 130, 250);
                cerrarMiCuenta.setEnabled(false);
                
        //BOTON 3 reportesMenu
        toggleButton(reportesMenu, 100, 320, 235, 42, false, false, "Dialog", 28, "Reportes", 237, 235, 130, 250);
        reportesMenu.setSelected(false); 
        
            //BOTON 3.1 Ranking Jugadores
            boton(rankingJugadores, 160, 360, 340, 42, false, false, "Dialog", 28, "", 237, 235, 130, 250);
        
            //BOTON 3.2 Logs de mis últimos juegos
            boton(logsDeJuegos, 150, 400, 270, 42, false, false, "Dialog", 28, "", 237, 235, 130, 250);
        
            //rankingJugadores, logsDeJuegos
        //BOTON 4 log out
        boton(logOut, 90, 390, 235, 42, false, false, "Dialog", 28, "Log out", 237, 235, 130, 250);

        
        
        nuevaPartida.addActionListener((ActionEvent e) -> {
            
            
            
        });

        miCuenta.addActionListener((ActionEvent e) -> {
            if(miCuenta.isSelected()){
                verMiInformacion.setText("Ver Mi Información");
                cambiarPassword.setText("Cambiar Password");
                cerrarMiCuenta.setText("Cerrar mi Cuenta");
                
                verMiInformacion.setEnabled(true);
                cambiarPassword.setEnabled(true);
                cerrarMiCuenta.setEnabled(true);
                
                reportesMenu.setLocation(100, 410);
                logOut.setLocation(90, 480);
                reportesMenu.setEnabled(false);
            }else{
                verMiInformacion.setText("");
                cambiarPassword.setText("");
                cerrarMiCuenta.setText("");
                
                verMiInformacion.setEnabled(false);
                cambiarPassword.setEnabled(false);
                cerrarMiCuenta.setEnabled(false);
                
                reportesMenu.setEnabled(true);
                
                reportesMenu.setLocation(100, 320);
                logOut.setLocation(90, 390);
            }
        });
        
        reportesMenu.addActionListener((ActionEvent e) -> {
            if(reportesMenu.isSelected()){
                rankingJugadores.setText("Ranking de jugadores");
                logsDeJuegos.setText("Logs de juegos");
                
                logOut.setLocation(90, 440);
                
                rankingJugadores.setEnabled(true);
                logsDeJuegos.setEnabled(true);
                miCuenta.setEnabled(false);
                
            }else{
                rankingJugadores.setText("");
                logsDeJuegos.setText("");
                
                rankingJugadores.setEnabled(false);
                logsDeJuegos.setEnabled(false);
                
                miCuenta.setEnabled(true);
                logOut.setLocation(90, 390);
            }
        });
        
        logOut.addActionListener((ActionEvent e) -> {
            pgInicial.frame.setVisible(true);
            frame.dispose();
        });
    }
    
}
