package Pieza;

import Pieza.Equipo;
import ajedrez_chino.Grafico;
import ajedrez_chino.Info_user;
import ajedrez_chino.Manejo_user;
import java.awt.Color;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;



public class Tablero extends Grafico{
    // Libreria swing
    JFrame frame = new JFrame();
    JLabel jugador1 = new JLabel();
    JLabel jugador2 = new JLabel();
    JLabel logMovimientos = new JLabel();
    JLabel backgroundForWords = new JLabel();
    JLabel background = new JLabel();
    JButton salir = new JButton();
    
    JTextArea contenedorScroll = new JTextArea();
    JScrollPane scrollPane = new JScrollPane(contenedorScroll);
    
    String imagenR = "src/Imagenes/";
    
    // Imagenes
    ImageIcon logoXiangqi= new ImageIcon("src/Imagenes/xiangqi.png");
    ImageIcon backgroundI= new ImageIcon("src/Imagenes/Background.gif");
    
    // Info de usuarios
    Manejo_user manejoUser;
    Equipo turnoP = Equipo.ROJO;
    Info_user logUser, oponente;
    
    String nombre;
    
    JButton[][] tablero = new JButton[11][9];
    Pieza[][] piezas = new Pieza[11][9];
    
    public void generarTablero(JFrame a){
        int inicioX = 300, inicioY = 25, tamaño = 63;
        
        for (int filas = 0; filas <11 ; filas++) {
            for (int columnas = 0; columnas < 9; columnas++) {
                tablero[filas][columnas] = new JButton();
                tablero[filas][columnas].setBounds(inicioX + (columnas * tamaño), inicioY + (filas * tamaño), tamaño, tamaño);
                a.add(tablero[filas][columnas]);
                
                if(filas>=0 && filas<=4 || filas>=6 && filas<=11){
                    tablero[filas][columnas].setBackground(java.awt.Color.WHITE);
                }
                
                if((filas>=0 && filas<=2 || filas>=8 && filas<=10) && columnas>2 && columnas<6){
                    tablero[filas][columnas].setBackground(new Color(207, 207, 207, 250));
                }
                
                if(filas!=4){
                    tablero[filas][columnas].setContentAreaFilled(true);
                }
                
                asignarEquipoPieza(filas, columnas);
            }
        }
        
        for (int columnas = 0; columnas <9; columnas++) {
            tablero[5][columnas].setBorderPainted(false);
            tablero[5][columnas].setBackground(java.awt.Color.blue);
            tablero[5][columnas].setEnabled(false);
        }
    }
    
    private void asignarEquipoPieza(int fila, int columna){     
        if(fila==0 || fila==10){
            if(columna==0 || columna==8){
                piezas[fila][columna] = new Torre(this, fila==0?Equipo.ROJO:Equipo.NEGRO);
            }else if(columna==1 || columna==7){
                piezas[fila][columna]=new Caballo(this, fila==0?Equipo.ROJO:Equipo.NEGRO);
            }else if(columna==2 || columna==6){
                piezas[fila][columna]=new Elefante(this, fila==0?Equipo.ROJO:Equipo.NEGRO);
            }else if(columna==3 || columna==5){
                piezas[fila][columna]=new Oficial(this, fila==0?Equipo.ROJO:Equipo.NEGRO);
            }else if(columna==4){
                piezas[fila][columna]=new General(this, fila==0?Equipo.ROJO:Equipo.NEGRO);
            }
        }
        
        if(fila==2 || fila==8){
            if(columna==1 || columna==7){
                piezas[fila][columna]=new Cañon(this, fila==2?Equipo.ROJO:Equipo.NEGRO);
            }
        }
        
        if((fila==3 || fila==7) && columna%2==0){
            piezas[fila][columna]=new Soldado(this, fila==3?Equipo.ROJO:Equipo.NEGRO);
        }
        
        if (piezas[fila][columna] != null) {
            String imagen = imagenR+obtenerImagePieza(piezas[fila][columna]);
            tablero[fila][columna].setIcon(new ImageIcon(imagen));
        }
    }
    
    private String obtenerImagePieza(Pieza pieza){
        if(pieza instanceof Torre){
            return pieza.getEquipo()==Equipo.ROJO?"TorreR.png":"TorreN.png";
        }if(pieza instanceof Caballo){
            return pieza.getEquipo()==Equipo.ROJO?"caballoR.png":"caballoN.png";
        }if(pieza instanceof Elefante){
            return pieza.getEquipo()==Equipo.ROJO?"elefanteR.png":"elefanteN.png";
        }if(pieza instanceof Oficial){
            return pieza.getEquipo()==Equipo.ROJO?"oficialR.png":"oficialN.png";
        }if(pieza instanceof General){
            return pieza.getEquipo()==Equipo.ROJO?"generalR.png":"generalN.png";
        }if(pieza instanceof Cañon){
            return pieza.getEquipo()==Equipo.ROJO?"cañonR.png":"cañonN.png";
        }if(pieza instanceof Soldado){
            return pieza.getEquipo()==Equipo.ROJO?"espadaR.png":"espadaN.png";
        }
        return "";
    }
    
    public Pieza getPieza(int filaInicial, int columnaInicial){
        return piezas[filaInicial][columnaInicial];
    }
    
    public Pieza getPiezaComer(int filaSiguiente, int columnaSiguiente){
        return piezas[filaSiguiente][columnaSiguiente];
    }
    
    public Tablero(){
        
        manejoUser =new Manejo_user();
        //FRAME
        confFrame(frame, logoXiangqi, "Segmented & Corp", 1300, 1000);
        generarTablero(frame);
        frame.add(scrollPane);
        frame.add(jugador2);
        frame.add(logMovimientos);
        frame.add(jugador1);
        frame.add(salir);
        frame.add(backgroundForWords);
        frame.add(background);
        
        frame.setVisible(true);
        
        
        
        //BACKGROUND
        fondo(background, 50, 50, backgroundI, frame);

        postBackground(backgroundForWords, 50, 25, 1200, 694, 236, 183, 86, 200, true);

//        postBackground(tablero, 450, 40, 950, 650, 171, 49, 19, 220, false);
//        tablero.setIcon(tableroIcon);
        //Titulo de jugador 2
        titulo(jugador2, 100, 50, 235, 42, "Dialog", 24, 151, 19, 19, 250, "Jugador 1");

        //Titulo de jugador 1
        titulo(jugador1, 100, 300, 235, 42, "Dialog", 24, 151, 19, 19, 250, "Jugador 2");

        //Titulo de log de movimientos
        titulo(logMovimientos, 900, 150, 250, 42, "Dialog", 24, 151, 19, 19, 250, "Log de movimientos");
        
        scrollPane.setBounds(895, 200, 250, 300);
        contenedorScroll.setEditable(false);
        scrollPane.setOpaque(false);
        scrollPane.setVisible(true);

        //BOTON 3 salir del sistema
        boton(salir, 50, 600, 235, 42, false, false, "Dialog", 28, "Rendirse", 151, 19, 19, 250);
        
        salir.addActionListener((ActionEvent e) -> {
            
        });
    }
    
    public static void main(String[] args) {
        new Tablero();
    }
}
