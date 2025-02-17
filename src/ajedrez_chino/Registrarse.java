package ajedrez_chino;

import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class Registrarse extends Grafico{

    //Libreria swing
    JFrame frame = new JFrame();
    JLabel tituloSuperior = new JLabel();
    JLabel backgroundForWords = new JLabel();
    JLabel background = new JLabel();
    JLabel nombreTxt = new JLabel();
    JLabel contraseñaTxt = new JLabel();
    JButton volver = new JButton();
    JButton registrarse = new JButton();   
    JTextField nombreTxtF = new JTextField();
    JPasswordField contraseñaTxtF = new JPasswordField();
    
    //Imagenes
    ImageIcon logoXiangqi= new ImageIcon("src/Imagenes/xiangqi.png");
    ImageIcon backgroundI= new ImageIcon("src/Imagenes/Background.gif");
    
    //Info de usuarios
    Pg_Inicial pgInicial;
    
    public Registrarse(Pg_Inicial pgInicial){
        this.pgInicial =pgInicial;
        
        //FRAME
        confFrame(frame, logoXiangqi, "Segmented & Corp", 1300, 1000);

        frame.add(tituloSuperior);
        frame.add(nombreTxtF);
        frame.add(contraseñaTxtF);
        frame.add(nombreTxt);
        frame.add(contraseñaTxt);
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

        //Sub titulo 1
        titulo(nombreTxt, 590, 128, 170, 50, "Dialog", 28, 151, 19, 19, 250, "Nombre:");
        
        //Textfield 1
        textfield(nombreTxtF, 585, 175, 170, 30, "Dialog", 20);
        
        //Sub titulo 2
        titulo(contraseñaTxt, 590, 235, 170, 50, "Dialog", 28, 151, 19, 19, 250, "Contraseña:");
        
        //Textfield 2
        passwordfield(contraseñaTxtF, 585, 275, 170, 30, "Dialog", 20);
        
        //BOTON 1 Iniciar sesion
        boton(volver, 420, 350, 235, 42, false, false, "Dialog", 28, "Volver", 151, 19, 19, 250);

        //BOTON 2 registrarse
        boton(registrarse, 660, 350, 235, 42, false, false, "Dialog", 28, "Registrarse", 151, 19, 19, 250);


        volver.addActionListener((ActionEvent e) -> {
            pgInicial.frame.setVisible(true);
            frame.dispose();
        });

        registrarse.addActionListener((ActionEvent e) -> {
            String nombre=nombreTxtF.getText(), contraseña=String.valueOf(contraseñaTxtF.getPassword());
            
            if(pgInicial.manejoUser.buscarUser(nombre)==null){
                System.out.println("si reconoce que no hay usuarios");
                System.out.println(contraseña.length());
                System.out.println(contraseña);
                System.out.println(pgInicial.manejoUser.cantUserHelp());
                
            }if(pgInicial.manejoUser.buscarUser(nombre)!=null){
                System.out.println(pgInicial.manejoUser.buscarUser(nombre).getNombre());
            }
            
            if(contraseña.length()==5 && pgInicial.manejoUser.buscarUser(nombre)==null){
                JOptionPane.showMessageDialog(null, "Se ha registrado exitosamente!", "Confirmación", JOptionPane.INFORMATION_MESSAGE);
                pgInicial.manejoUser.agregarUser(nombre, contraseña);
                pgInicial.nombre=nombre.trim().replaceAll("\\s+", " ");
                Pg_Principal pgPrincipal= new Pg_Principal(pgInicial);
                pgPrincipal.frame.setVisible(true);
                frame.dispose();
            }else if(pgInicial.manejoUser.buscarUser(nombre)!=null){
                JOptionPane.showMessageDialog(null, "Ya existe un usuario con el mismo nombre.", "Confirmacion", JOptionPane.INFORMATION_MESSAGE);
            }else{
                JOptionPane.showMessageDialog(null, "Ingreso una contraseña que no es exactamente 5 letras!", "Confirmacion", JOptionPane.ERROR_MESSAGE);
            }
            
            
        });
    }
}
