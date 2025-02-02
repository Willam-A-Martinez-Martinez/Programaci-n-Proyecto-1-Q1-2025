package ajedrez_chino;

import java.awt.event.ActionEvent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JOptionPane;

public class Pg_Inicial extends Grafico{
    //Libreria swing
    JFrame frame = new JFrame();
    JLabel tituloSuperior = new JLabel();
    JLabel backgroundForWords = new JLabel();
    JLabel background = new JLabel();
    JButton iniciarSesion = new JButton();
    JButton registrarse = new JButton();
    JButton salir = new JButton();
    
    //Imagenes
    ImageIcon logoXiangqi= new ImageIcon("src/Imagenes/xiangqi.png");
    ImageIcon backgroundI= new ImageIcon("src/Imagenes/Background.gif");
    
    //Info de usuarios
    Manejo_user manejoUser;
    
    String nombre;
    
    public Pg_Inicial(){
        manejoUser =new Manejo_user();
        //FRAME
        confFrame(frame, logoXiangqi, "Segmented & Corp", 1300, 1000);

        frame.add(tituloSuperior);
        frame.add(iniciarSesion);
        frame.add(registrarse);
        frame.add(salir);
        frame.add(backgroundForWords);
        frame.add(background);
        frame.setVisible(true);

        //BACKGROUND
        fondo(background, 50, 50, backgroundI, frame);

        postBackground(backgroundForWords, 424, 28, 452, 331, 241, 148, 21, 100, true);

        //TITULO
        titulo(tituloSuperior, 515, 71, 350, 50, "Dialog", 28, 151, 19, 19, 250, "Ajedrez chino (中国象棋)");

        //BOTON 1 Iniciar sesion
        boton(iniciarSesion, 535, 150, 235, 42, false, false, "Dialog", 28, "Iniciar sesion", 151, 19, 19, 250);

        //BOTON 2 iniciar_Sesion
        boton(registrarse, 535, 200, 235, 42, false, false, "Dialog", 28, "Registrarse", 151, 19, 19, 250);

        //BOTON 3 salir del sistema
        boton(salir, 535, 250, 235, 42, false, false, "Dialog", 28, "Salir", 151, 19, 19, 250);

        iniciarSesion.addActionListener((ActionEvent e) -> {
            Iniciar_sesion pgIniciarSesion= new Iniciar_sesion(this);
            pgIniciarSesion.frame.setVisible(true);
            frame.setVisible(false);
            
        });
        
        

        registrarse.addActionListener((ActionEvent e) -> {
            if(manejoUser.cantUserHelp()!=manejoUser.infoUser.length){
                Registrarse pgRegistrarse = new Registrarse(this);
                pgRegistrarse.frame.setVisible(true);
                frame.setVisible(false);
            }else{
                JOptionPane.showConfirmDialog(null, "No se puede registrar mas usuarios", "Segmented & corps", JOptionPane.OK_OPTION, JOptionPane.WARNING_MESSAGE);
            }
        });
        
        salir.addActionListener((ActionEvent e) -> {
            System.exit(0);
        });
    }
    
        
    public static void main(String[] args) {
        new Pg_Inicial();
    }
        
}
