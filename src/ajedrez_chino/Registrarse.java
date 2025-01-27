package ajedrez_chino;

import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Registrarse extends Grafico{

    //Libreria swing
    JFrame frame = new JFrame();
    JLabel tituloSuperior = new JLabel();
    JLabel backgroundForWords = new JLabel();
    JLabel background = new JLabel();
    JButton volver = new JButton();
    JButton registrarse = new JButton();    
    //Imagenes
    ImageIcon logoXiangqi= new ImageIcon("src/Imagenes/xiangqi.png");
    ImageIcon backgroundI= new ImageIcon("src/Imagenes/Background.gif");
    
    //Info de usuarios
    Pg_Inicial pgInicial = new Pg_Inicial();
    
    public Registrarse(){
        //FRAME
        confFrame(frame, logoXiangqi, "Segmented & Corp", 1300, 1000);

        frame.add(tituloSuperior);
        frame.add(volver);
        frame.add(registrarse);
        frame.add(backgroundForWords);
        frame.add(background);
        frame.setVisible(true);
        
        //BACKGROUND
        fondo(background, 50, 50, backgroundI, frame);

        postBackground(backgroundForWords, 400, 28, 550, 450, 241, 148, 21, 100, true);

        //TITULO
        titulo(tituloSuperior, 590, 71, 170, 50, "Dialog", 28, 151, 19, 19, 250, "Registrarse");

        //BOTON 1 Iniciar sesion
        boton(volver, 400, 350, 235, 42, false, false, "Dialog", 28, "Volver", 151, 19, 19, 250);

        //BOTON 2 registrarse
        boton(registrarse, 650, 350, 235, 42, false, false, "Dialog", 28, "Registrarse", 151, 19, 19, 250);


        volver.addActionListener((ActionEvent e) -> {
            System.out.println("O");
        });

        registrarse.addActionListener((ActionEvent e) -> {
            System.out.println("I");
        });
    }
    
    public static void main(String[] args) {
        new Registrarse();
    }
}
