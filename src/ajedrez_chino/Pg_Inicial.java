package ajedrez_chino;

import java.awt.event.ActionEvent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JButton;

public class Pg_Inicial extends Grafico{
    //Libreria swing
    JFrame frame = new JFrame();
    JLabel tituloSuperior = new JLabel();
    JLabel backgroundForWords = new JLabel();
    JLabel background = new JLabel();
    JButton iniciarSesion = new JButton();
    JButton registrarse = new JButton();
    
    //Imagenes
    ImageIcon logoXiangqi= new ImageIcon("src/Imagenes/xiangqi.png");
    ImageIcon backgroundI= new ImageIcon("src/Imagenes/Background.gif");
    
    //Info de usuarios
    Manejo_user manejoUser =new Manejo_user();
        
    public Pg_Inicial(){
        //FRAME
        confFrame(frame, logoXiangqi, "Segmented & Corp", 1300, 1000);

        frame.add(tituloSuperior);
        frame.add(iniciarSesion);
        frame.add(registrarse);
        frame.add(backgroundForWords);
        frame.add(background);
        frame.setVisible(true);

        //BACKGROUND
        fondo(background, 50, 50, backgroundI, frame);

        postBackground(backgroundForWords, 424, 28, 452, 331, 241, 148, 21, 100, true);

        //TITULO
        titulo(tituloSuperior, 515, 71, 300, 50, "Dialog", 28, 151, 19, 19, 250, "Ajedrez chino el juego");

        //BOTON 1 Iniciar sesion
        boton(iniciarSesion, 535, 180, 235, 42, false, false, "Dialog", 28, "Iniciar sesion", 151, 19, 19, 250);

        //BOTON 2 registrarse
        boton(registrarse, 535, 250, 235, 42, false, false, "Dialog", 28, "Registrarse", 151, 19, 19, 250);


        iniciarSesion.addActionListener((ActionEvent e) -> {
            System.out.println("O");
        });
        
        

        registrarse.addActionListener((ActionEvent e) -> {
            System.out.println("I");
        });
    }
    
        
    public static void main(String[] args) {
        new Pg_Inicial();
    }
        
}
