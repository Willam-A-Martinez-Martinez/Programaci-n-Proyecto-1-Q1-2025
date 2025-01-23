/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ajedrez_chino;

import java.awt.Color;
import java.awt.Font;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import static javax.swing.WindowConstants.EXIT_ON_CLOSE;

/**
 *
 * @author DELL
 */
public class Pg_Inicial {
    public static void main(String[] args) {
        JFrame base = new JFrame();
        JLabel tituloSuperior = new JLabel();
        JLabel backgroundWords = new JLabel();
        JLabel background = new JLabel();
        
        JButton IniciarSesion = new JButton();
        JButton Registrarse = new JButton();
        ImageIcon logoXiangqi= new ImageIcon("src/Imagenes/xiangqi.png");
        ImageIcon backgroundI= new ImageIcon("src/Imagenes/Background.gif");
        
        //FRAME
        base.setIconImage(logoXiangqi.getImage());
        base.setTitle("Segmented & Corp");
        base.setSize(1300, 1000);
        base.setLocationRelativeTo(null);
        base.setLayout(null);
        base.setDefaultCloseOperation(EXIT_ON_CLOSE);
        
        base.add(tituloSuperior);
        base.add(IniciarSesion);
        base.add(Registrarse);
        base.add(backgroundWords);
        base.add(background);
        base.setVisible(true);
        
        
        
        //BACKGROUND
        background.setBounds(0, 0, (base.getWidth()+50), (base.getHeight()+50));
        background.setIcon(backgroundI);
        
        //BACKGROUND FOR WORDS
        backgroundWords.setBounds(424, 28, 452, 331);
        backgroundWords.setBackground(new Color(241, 148, 21, 100));
        backgroundWords.setOpaque(true);
        
        //TITULO
        tituloSuperior.setBounds(515, 71, 300, 50);
        tituloSuperior.setFont(new Font("Dialog", Font.BOLD, 28));
        tituloSuperior.setForeground(new Color(151, 19, 19, 250));
        tituloSuperior.setText("Ajedrez chino el juego");
        
        //BOTON 1 Iniciar sesion
        IniciarSesion.setBounds(535, 180, 235, 42);
        IniciarSesion.setBorderPainted(false);
        IniciarSesion.setContentAreaFilled(false);
        IniciarSesion.setFont(new Font("Dialog", Font.BOLD, 28));
        IniciarSesion.setText("Iniciar sesion");
        IniciarSesion.setForeground(new Color(151, 19, 19, 250));
        
        //BOTON 2 registrarse
        Registrarse.setBounds(535, 250, 235, 42);
        Registrarse.setBorderPainted(false);
        Registrarse.setContentAreaFilled(false);
        Registrarse.setFont(new Font("Dialog", Font.BOLD, 28));
        Registrarse.setText("Registrarse");
        Registrarse.setForeground(new Color(151, 19, 19, 250));
        
    }
}
