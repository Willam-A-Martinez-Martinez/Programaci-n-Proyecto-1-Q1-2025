package ajedrez_chino;

import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;



public class Pg_AjedrezChino extends Grafico{
    //Libreria swing
    JFrame frame = new JFrame();
    JLabel tituloSuperior = new JLabel();
    JLabel tablero = new JLabel();
    JLabel backgroundForWords = new JLabel();
    JLabel background = new JLabel();
    JButton iniciarSesion = new JButton();
    JButton registrarse = new JButton();
    JButton salir = new JButton();
    JButton [][]tableroBoton = new JButton[10][9];
    
    //Imagenes
    ImageIcon logoXiangqi= new ImageIcon("src/Imagenes/xiangqi.png");
    ImageIcon tableroIcon= new ImageIcon("src/Imagenes/tableroXiangqi.png");
    ImageIcon backgroundI= new ImageIcon("src/Imagenes/Background.gif");
    
    //Info de usuarios
    Manejo_user manejoUser;
    
    String nombre;
    
    public final void generarTablero(JFrame a){
        int inicioX = 451, inicioY = 82, tamaño = 63;
        
        for (int filas = 0; filas <9 ; filas++) {
            for (int columnas = 0; columnas < 8; columnas++) {
                tableroBoton[filas][columnas] = new JButton();
                tableroBoton[filas][columnas].setBounds(inicioX + (columnas * tamaño), inicioY + (filas * tamaño), tamaño, tamaño);
                a.add(tableroBoton[filas][columnas]);
                
                if(filas!=4){
                    tableroBoton[filas][columnas].setContentAreaFilled(false);
                }
            }
        }
        
        for (int columnas = 0; columnas <8; columnas++) {
            tableroBoton[4][columnas].setBorderPainted(false);
            tableroBoton[4][columnas].setEnabled(false);
        }
    }
    
    public Pg_AjedrezChino(){
        
        
        
        manejoUser =new Manejo_user();
        //FRAME
        confFrame(frame, logoXiangqi, "Segmented & Corp", 1300, 1000);
        
        generarTablero(frame);
        frame.add(tituloSuperior);
        frame.add(tablero);
        frame.add(iniciarSesion);
        frame.add(registrarse);
        frame.add(salir);
        frame.add(backgroundForWords);
        frame.add(background);
        frame.setVisible(true);
        
        //BACKGROUND
        fondo(background, 50, 50, backgroundI, frame);

        postBackground(backgroundForWords, 50, 25, 1200, 675, 236, 183, 86, 200, true);

        postBackground(tablero, 450, 40, 950, 650, 171, 49, 19, 220, false);
        tablero.setIcon(tableroIcon);
        //TITULO
        titulo(tituloSuperior, 75, 50, 350, 50, "Dialog", 28, 151, 19, 19, 250, "Ajedrez chino (中国象棋)");

        //BOTON 1 Iniciar sesion
        boton(iniciarSesion, 50, 100, 235, 42, false, false, "Dialog", 28, "Iniciar sesion", 151, 19, 19, 250);

        //BOTON 2 iniciar_Sesion
        boton(registrarse, 50, 150, 235, 42, false, false, "Dialog", 28, "Registrarse", 151, 19, 19, 250);

        //BOTON 3 salir del sistema
        boton(salir, 50, 600, 235, 42, false, false, "Dialog", 28, "Rendirse", 151, 19, 19, 250);
        
        

        iniciarSesion.addActionListener((ActionEvent e) -> {
            
        });
        
        

        registrarse.addActionListener((ActionEvent e) -> {
        });
        
        salir.addActionListener((ActionEvent e) -> {
        });
    }
    
    public static void main(String[] args) {
        new Pg_AjedrezChino();
    }
}
