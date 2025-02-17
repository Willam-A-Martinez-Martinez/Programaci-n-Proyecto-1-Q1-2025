/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ajedrez_chino;

import Pieza.Tablero;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JToggleButton;
import javax.swing.UIManager;

/**
 *
 * @author DELL
 */
public class Pg_Principal extends Grafico{
    //Libreria swing
    public JFrame frame = new JFrame();
    JLabel menuPrincipal = new JLabel();
    JLabel backgroundForWords = new JLabel();
    JLabel background = new JLabel();
    JLabel miniVentana = new JLabel();
    JLabel miCuentaTitulo = new JLabel();
    JLabel nombre = new JLabel();
    JLabel puntos = new JLabel();
    JLabel fecha = new JLabel();
    JLabel activo = new JLabel();
    JLabel tituloMini = new JLabel();
    
    
    
    //botonMiniVentana, nuevaPartida, miCuenta, verMiInformacion, cambiarPassword, cerrarMiCuenta, reportesMenu, rankingJugadores, logsDeJuegos, logOut
    JButton nuevaPartida = new JButton();
    JToggleButton botonCambiarContra= new JToggleButton();
    JToggleButton botonCerrarCuenta= new JToggleButton();
    JToggleButton miCuenta = new JToggleButton();
    JToggleButton verMiInformacion = new JToggleButton();
    JToggleButton cambiarPassword = new JToggleButton();
    JToggleButton cerrarMiCuenta = new JToggleButton();
    JToggleButton reportesMenu = new JToggleButton();
    JToggleButton rankingJugadores = new JToggleButton();
    JToggleButton logsDeJuegos = new JToggleButton();
    JButton logOut = new JButton();
    JPasswordField passwordField = new JPasswordField();
    
    JTextArea contenedorScroll = new JTextArea();
    JScrollPane scrollPane = new JScrollPane(contenedorScroll);
    
    //Imagenes
    ImageIcon logoXiangqi= new ImageIcon("src/Imagenes/xiangqi.png");
    ImageIcon logoRSize = new ImageIcon(new ImageIcon("src/Imagenes/xiangqi.png").getImage().getScaledInstance(50, 50, Image.SCALE_DEFAULT));
    
    ImageIcon backgroundI= new ImageIcon("src/Imagenes/Background.gif");
    
    //Info de usuarios
    Pg_Inicial pgInicial;
    
        
    public Pg_Principal(Pg_Inicial pgInicial){
        this.pgInicial =pgInicial;
        
        
        
        Info_user logUser = pgInicial.manejoUser.buscarUser(pgInicial.nombre);
        
        
        //FRAME
        confFrame(frame, logoXiangqi, "Segmented & Corp", 1300, 1000);
        
        frame.add(tituloMini);
        frame.add(botonCambiarContra);
        frame.add(botonCerrarCuenta);
        frame.add(passwordField);
        frame.add(miCuentaTitulo);
        frame.add(nombre);
        frame.add(puntos);
        frame.add(fecha);
        frame.add(activo);
        frame.add(menuPrincipal);
        frame.add(nuevaPartida);
        frame.add(miCuenta);
        frame.add(miniVentana);
        frame.add(scrollPane);
        frame.add(reportesMenu);
        frame.add(logOut);
        frame.add(verMiInformacion);
        frame.add(cerrarMiCuenta);
        frame.add(cambiarPassword);
        frame.add(rankingJugadores);
        frame.add(logsDeJuegos);
        frame.add(backgroundForWords);
        frame.add(background);
        frame.setVisible(true);
        
        
        
        //BACKGROUND
        fondo(background, 50, 50, backgroundI, frame);

        postBackground(backgroundForWords, 40, 20, 1200, 700, 171, 49, 19, 150, true);

        //Mini ventana
        
        postBackground(miniVentana, 500, 100, 700, 500, 171, 49, 19, 220, false);
        
        //mi cuenta Titulo
        
        titulo(miCuentaTitulo, 800, 125, 300, 50, "Dialog", 24, 237, 235, 130, 250, "");
        miCuentaTitulo.setIcon(logoRSize);//miCuentaTitulo, nombre, puntos, fecha, activo
        miCuentaTitulo.setVisible(false);
        
        //BOTON 2.1.1.1
        toggleButton(botonCambiarContra, 715, 475, 300, 42, false, false, "Dialog", 20, "", 237, 235, 130, 250);
        
        toggleButton(botonCerrarCuenta, 715, 450, 300, 42, false, false, "Dialog", 20, "", 237, 235, 130, 250);
        
        //passwordfield
        passwordfield(passwordField, 775, 400, 170, 30, "Dialog", 20);
        passwordField.setVisible(false);
        
        //Nombre  Nombre: ,Puntos: ,Fecha de ingreso: , Estado de actividad:
        titulo(nombre, 550, 190, 300, 50, "Dialog", 20, 237, 235, 130, 250, "");
        
        //puntos
        titulo(puntos, 550, 260, 300, 50, "Dialog", 20, 237, 235, 130, 250, "");
        
        //fecha
        titulo(fecha, 800, 190, 300, 50, "Dialog", 20, 237, 235, 130, 250, "");
        
        //activo
        titulo(activo, 800, 260, 300, 50, "Dialog", 20, 237, 235, 130, 250, "");
        
        //Password
        titulo(tituloMini, 750, 350, 300, 50, "Dialog", 24, 237, 235, 130, 250, "");
        
        //titulo(tituloMini, 750, 350, 300, 50, "Dialog", 24, 237, 235, 130, 250, "");
        
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
                toggleButton(cambiarPassword, 180, 330, 300, 42, false, false, "Dialog", 28, "", 237, 235, 130, 250);
                cambiarPassword.setEnabled(false);
                
                //BOTON 2.1.2 cerrar mi cuenta
                toggleButton(cerrarMiCuenta, 155, 370, 325, 42, false, false, "Dialog", 28, "", 237, 235, 130, 250);
                cerrarMiCuenta.setEnabled(false);
                
        //BOTON 3 reportesMenu
        toggleButton(reportesMenu, 100, 320, 235, 42, false, false, "Dialog", 28, "Reportes", 237, 235, 130, 250);
        reportesMenu.setSelected(false); 
        
        scrollPane.setVisible(false);
        
        
            
            //BOTON 3.1 Ranking Jugadores
            toggleButton(rankingJugadores, 160, 360, 340, 42, false, false, "Dialog", 28, "", 237, 235, 130, 250);
        
            //BOTON 3.2 Logs de mis últimos juegos
            toggleButton(logsDeJuegos, 150, 400, 270, 42, false, false, "Dialog", 28, "", 237, 235, 130, 250);
        
            rankingJugadores.setEnabled(false);
                logsDeJuegos.setEnabled(false);
            //rankingJugadores, logsDeJuegos
            
        //BOTON 4 log out
        boton(logOut, 90, 390, 235, 42, false, false, "Dialog", 28, "Log out", 237, 235, 130, 250);
        
        

        
        
        nuevaPartida.addActionListener((ActionEvent e) -> {
            if(pgInicial.manejoUser.cantUserHelp()!=1){
                String []listaContrincantes= new String[pgInicial.manejoUser.cantUserHelp()];
                pgInicial.manejoUser.listaContrincantes(listaContrincantes, logUser.getNombre());
                String oponente =(String) JOptionPane.showInputDialog(null, "Seleccione el oponente", "Seleccion de oponente", JOptionPane.OK_OPTION, UIManager.getIcon("OptionPane.questionIcon"), listaContrincantes, listaContrincantes[0]);
                if(oponente==null){
                    JOptionPane.showMessageDialog(null, "Seleccione un oponente existente");
                }else{
                    pgInicial.oponente=oponente;
                    Tablero ajedrezChino = new Tablero(pgInicial);
                    ajedrezChino.frame.setVisible(true);
                    frame.setVisible(false);
                }
                }else{
                    JOptionPane.showMessageDialog(null, "No hay oponentes para jugar");
                }
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
                //miCuentaTitulo, nombre, puntos, fecha, activo
                //Nombre: ,Puntos: ,Fecha de ingreso: , Estado de actividad:
                String activoStr="";
        
                if(logUser.isActivo()){
                    activoStr="Activo";
                }
                miCuentaTitulo.setText("Mi cuenta");
                nombre.setText("Nombre: "+logUser.getNombre());
                puntos.setText("Puntos: "+logUser.getPuntos());
                fecha.setText("Fecha de ingreso: "+logUser.getFecha());
                activo.setText("Estado de actividad: "+activoStr);
                
                miCuentaTitulo.setVisible(true);
                miniVentana.setOpaque(true);
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
                
                miCuentaTitulo.setText("");
                nombre.setText("");
                puntos.setText("");
                fecha.setText("");
                activo.setText("");
                
                passwordField.setVisible(false);
                cambiarPassword.setSelected(false);
                cerrarMiCuenta.setSelected(false);
                miCuentaTitulo.setVisible(false);
                miniVentana.setOpaque(false);
                
                botonCerrarCuenta.setText("");
                tituloMini.setText("");
                botonCambiarContra.setText("");
                botonCerrarCuenta.setText("");
            }
        });
        
        cambiarPassword.addActionListener((ActionEvent e) -> {
            if(cambiarPassword.isSelected()){
                botonCambiarContra.setLocation(715, 475);
                cerrarMiCuenta.setSelected(false);
                passwordField.setVisible(true);
                tituloMini.setText("Ingrese contraseña");
                botonCambiarContra.setText("Cambiar contraseña");
                botonCambiarContra.setEnabled(true);
                botonCerrarCuenta.setText("");
            }else{
                passwordField.setVisible(false);
                botonCambiarContra.setEnabled(false);
                tituloMini.setText("");
                botonCambiarContra.setText("");
                botonCerrarCuenta.setText("");
            }
        });
        
        cerrarMiCuenta.addActionListener((ActionEvent e) -> {
            if(cerrarMiCuenta.isSelected()){
                System.out.println("True cerrarMiCuenta");
                botonCambiarContra.setLocation(0, 0);
                botonCambiarContra.setEnabled(false);
                cambiarPassword.setSelected(false);
                passwordField.setVisible(true);
                tituloMini.setText("Cierre de cuenta");
                botonCerrarCuenta.setText("Cerrar cuenta");
                botonCambiarContra.setText("");
            }else{
                System.out.println("Cerrar mi cuenta toggle button accede aqui");
                botonCambiarContra.setLocation(715, 475);
                botonCambiarContra.setEnabled(true);
                passwordField.setVisible(false);
                tituloMini.setText("");
                botonCerrarCuenta.setText("");
            }
        });
                
        botonCambiarContra.addActionListener((ActionEvent e) -> {
            String contraseña1="", contraseña2="";
            if(botonCambiarContra.isSelected()){
                contraseña1= String.valueOf(passwordField.getPassword());
            }else if(botonCambiarContra.isSelected()==false){
                contraseña2= String.valueOf(passwordField.getPassword());
            }
            System.out.println("Contra 1: "+contraseña1);
            System.out.println("Contra 2: "+contraseña2);
            System.out.println("Estado del boton: "+botonCambiarContra.getSelectedIcon());
            if(pgInicial.manejoUser.buscarUserNC(pgInicial.nombre, contraseña1)!=null && botonCambiarContra.isSelected()){
                nuevaPartida.setEnabled(false);
                miCuenta.setEnabled(false);
                verMiInformacion.setEnabled(false);
                cambiarPassword.setEnabled(false);
                cerrarMiCuenta.setEnabled(false);
                logOut.setEnabled(false);
                JOptionPane.showMessageDialog(null, "Contraseña correcta! ingrese nueva contraseña");
                botonCambiarContra.setText("Nueva contraseña");
                tituloMini.setText("Cambio de contraseña");
                passwordField.setText("");
            }else if(botonCambiarContra.isSelected()==false && contraseña2.length()!=5){
                JOptionPane.showMessageDialog(null, "Ingreso una contraseña mayor a 5 characteres! intentelo denuevo");
                botonCambiarContra.setSelected(true);
                passwordField.setText("");
            }else if(logUser.getContraseña().equals(contraseña2) && botonCambiarContra.isSelected()==false){
                JOptionPane.showMessageDialog(null, "Ingreso la misma contraseña! intentelo denuevo");
                botonCambiarContra.setSelected(true);
                passwordField.setText("");
            }else if(pgInicial.manejoUser.buscarUserNC(pgInicial.nombre, contraseña2)== null && botonCambiarContra.isSelected()==false && contraseña2.length()<=5){
                JOptionPane.showMessageDialog(null, "Contraseña cambiada!");
                logUser.setContraseña(contraseña2);
                cambiarPassword.setSelected(false);
                botonCambiarContra.setSelected(false);
                passwordField.setVisible(false);
                tituloMini.setText("");
                botonCambiarContra.setText("");
                passwordField.setText("");
                
                nuevaPartida.setEnabled(true);
                miCuenta.setEnabled(true);
                verMiInformacion.setEnabled(true);
                cambiarPassword.setEnabled(true);
                cerrarMiCuenta.setEnabled(true);
                logOut.setEnabled(true);
            }else if(botonCambiarContra.isSelected()){
                botonCambiarContra.setSelected(false);
                JOptionPane.showMessageDialog(null, "Contraseña incorrecta!");
                passwordField.setText("");
            }
        });
        
        botonCerrarCuenta.addActionListener((ActionEvent e) -> {
            String contraseña= String.valueOf(passwordField.getPassword());
            if(pgInicial.manejoUser.buscarUserNC(logUser.getNombre(), contraseña)!=null){
                JOptionPane.showMessageDialog(null, "Cuenta eliminada!");
                pgInicial.manejoUser.eliminarUser(logUser.getNombre(), contraseña);
                pgInicial.frame.setVisible(true);
                frame.dispose();
            }
        });
        
        reportesMenu.addActionListener((ActionEvent e) -> {
            if(reportesMenu.isSelected()){
                rankingJugadores.setText("Ranking de jugadores");
                logsDeJuegos.setText("Logs de juegos");
                
                logOut.setLocation(90, 440);
                cerrarMiCuenta.setLocation(0, 0);
                
                rankingJugadores.setEnabled(true);
                logsDeJuegos.setEnabled(true);
                miCuenta.setEnabled(false);
                
            }else{
                miCuentaTitulo.setText("");
                rankingJugadores.setText("");
                logsDeJuegos.setText("");
                
                
                scrollPane.setVisible(false);
                rankingJugadores.setEnabled(false);
                logsDeJuegos.setEnabled(false);
                miCuentaTitulo.setVisible(false);
                miCuenta.setEnabled(true);
                
                rankingJugadores.setSelected(false);
                logsDeJuegos.setSelected(false);
                
                logOut.setLocation(90, 390);
                cerrarMiCuenta.setLocation(155, 370);
                
                miniVentana.setOpaque(false);
            }
        });
        
        rankingJugadores.addActionListener((ActionEvent e) -> {
            if(rankingJugadores.isSelected()){
                
                contenedorScroll.setText(pgInicial.manejoUser.rankingJugadores());
                contenedorScroll.setFont(new Font("Dialog", Font.BOLD, 30));
                contenedorScroll.setForeground(new Color(237, 235, 130, 250));
                contenedorScroll.setEditable(false);
                contenedorScroll.setBackground(new Color(171, 49, 19, 220));

                logsDeJuegos.setSelected(false);
                
                scrollPane.setBounds(600, 200, 500, 350);
                scrollPane.setOpaque(false);
                scrollPane.setVisible(true);
            }else{
                scrollPane.setVisible(false);
            }
        });
        
        logsDeJuegos.addActionListener((ActionEvent e) -> {
            if(logsDeJuegos.isSelected()){
                contenedorScroll.setText(logUser.imprimirLogsJuegos());
                contenedorScroll.setFont(new Font("Dialog", Font.BOLD, 30));
                contenedorScroll.setForeground(new Color(237, 235, 130, 250));
                contenedorScroll.setEditable(false);
                contenedorScroll.setBackground(new Color(171, 49, 19, 220));
                
                rankingJugadores.setSelected(false);
                
                scrollPane.setBounds(600, 200, 500, 350);
                scrollPane.setOpaque(false);
                scrollPane.setVisible(true);
            }else{
                scrollPane.setVisible(false);
            }
        });
        
        logOut.addActionListener((ActionEvent e) -> {
            logUser.setActivo(false);
            pgInicial.frame.setVisible(true);
            frame.dispose();
        });
    }
    
}
