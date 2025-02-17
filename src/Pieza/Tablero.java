package Pieza;

//import ajedrez_chino.*;
import ajedrez_chino.Grafico;
import ajedrez_chino.Info_user;
import ajedrez_chino.Pg_Inicial;
import ajedrez_chino.Pg_Principal;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;



public class Tablero extends Grafico{
    // Libreria swing
    public JFrame frame = new JFrame();
    JLabel jugador1 = new JLabel();
    JLabel jugador2 = new JLabel();
    JLabel logMovimientos = new JLabel();
    JLabel backgroundForWords = new JLabel();
    JLabel background = new JLabel();
    JLabel indicadorTurno = new JLabel();
    JLabel filaTxt[] = new JLabel[11];
    JLabel columnaTxt[] = new JLabel[9];
    JPanel capturasJugador1= new JPanel();
    JPanel capturasJugador2= new JPanel();
    JButton rendirse = new JButton();
    
    JTextArea contenedorScroll = new JTextArea();
    JScrollPane scrollPane = new JScrollPane(contenedorScroll);
    
    String imagenR = "src/Imagenes/", logMovTxt="";
    
    // Imagenes
    ImageIcon logoXiangqi= new ImageIcon("src/Imagenes/xiangqi.png");
    ImageIcon backgroundI= new ImageIcon("src/Imagenes/Background.gif");
    
    // Info de usuarios
    Pg_Inicial pgInicial ;
    Equipo turnoP = Equipo.ROJO;
    Info_user logUser, oponente;
    
    
    JButton[][] tablero = new JButton[11][9];
    Pieza[][] pieza = new Pieza[11][9];
    
    int fSelect = -1, cSelect= -1;
    
    public Tablero(Pg_Inicial pgInicial){
        this.pgInicial= pgInicial;
        logUser=pgInicial.manejoUser.buscarUser(pgInicial.nombre);
        oponente=pgInicial.manejoUser.buscarUser(pgInicial.oponente);
        //FRAME
        confFrame(frame, logoXiangqi, "Segmented & Corp", 1300, 1000);
        
        int inicioX = 360, inicioY = 25, tamaño = 59, tamañoFont=28;
        
        for (int filas = 0; filas <11 ; filas++) {
            filaTxt[filas]= new JLabel();
            filaTxt[filas].setBounds(inicioX-tamaño+35, inicioY+(filas*tamaño), tamaño-30, tamaño);
            switch(filas){
                case 0:
                    filaTxt[filas].setText("J");
                    filaTxt[filas].setFont(new Font("Dialog", Font.BOLD, tamañoFont));
                    filaTxt[filas].setForeground(new Color(151, 19, 19, 250));
                    break;
                case 1:
                    filaTxt[filas].setText("I");
                    filaTxt[filas].setFont(new Font("Dialog", Font.BOLD, tamañoFont));
                    filaTxt[filas].setForeground(new Color(151, 19, 19, 250));
                    break;
                case 2:
                    filaTxt[filas].setText("H");
                    filaTxt[filas].setFont(new Font("Dialog", Font.BOLD, tamañoFont));
                    filaTxt[filas].setForeground(new Color(151, 19, 19, 250));
                    break;
                case 3:
                    filaTxt[filas].setText("G");
                    filaTxt[filas].setFont(new Font("Dialog", Font.BOLD, tamañoFont));
                    filaTxt[filas].setForeground(new Color(151, 19, 19, 250));
                    break;
                case 4:
                    filaTxt[filas].setText("F");
                    filaTxt[filas].setFont(new Font("Dialog", Font.BOLD, tamañoFont));
                    filaTxt[filas].setForeground(new Color(151, 19, 19, 250));
                    break;
                case 5:
                    filaTxt[filas].setText("");
                    break;
                case 6:
                    filaTxt[filas].setText("E");
                    filaTxt[filas].setFont(new Font("Dialog", Font.BOLD, tamañoFont));
                    filaTxt[filas].setForeground(new Color(151, 19, 19, 250));
                    break;
                case 7:
                    filaTxt[filas].setText("D");
                    filaTxt[filas].setFont(new Font("Dialog", Font.BOLD, tamañoFont));
                    filaTxt[filas].setForeground(new Color(151, 19, 19, 250));
                    break;
                case 8:
                    filaTxt[filas].setText("C");
                    filaTxt[filas].setFont(new Font("Dialog", Font.BOLD, tamañoFont));
                    filaTxt[filas].setForeground(new Color(151, 19, 19, 250));
                    break;
                case 9:
                    filaTxt[filas].setText("B");
                    filaTxt[filas].setFont(new Font("Dialog", Font.BOLD, tamañoFont));
                    filaTxt[filas].setForeground(new Color(151, 19, 19, 250));
                    break;
                case 10:
                    filaTxt[filas].setText("A");
                    filaTxt[filas].setFont(new Font("Dialog", Font.BOLD, tamañoFont));
                    filaTxt[filas].setForeground(new Color(151, 19, 19, 250));
                    break;
                default:
                    break;
            }
            frame.add(filaTxt[filas]);
            for (int columnas = 0; columnas < 9; columnas++) {
                tablero[filas][columnas] = new JButton();
                tablero[filas][columnas].setBounds(inicioX + (columnas * tamaño), inicioY + (filas * tamaño), tamaño, tamaño);
                frame.add(tablero[filas][columnas]);
                
                if(filas>=0 && filas<=4 || filas>=6 && filas<=11){
                    tablero[filas][columnas].setBackground(new Color(252, 175, 62, 250));
                }
                                            
                if((filas>=0 && filas<=2 || filas>=8 && filas<=10) && columnas>2 && columnas<6){
                    tablero[filas][columnas].setBackground(new Color(203, 147, 65 , 250));
                }
                
                if(filas!=5){
                    tablero[filas][columnas].setContentAreaFilled(true);
                    tablero[filas][columnas].setBorderPainted(true);
                    tablero[filas][columnas].setBorder(new LineBorder(Color.BLACK));
                }
                
                if(filas==10){
                    columnaTxt[columnas] = new JLabel();
                    columnaTxt[columnas].setBounds(inicioX + (columnas * tamaño), inicioY + (filas * tamaño) + 52, tamaño, tamaño - 15);
                    columnaTxt[columnas].setFont(new Font("Dialog", Font.BOLD, tamañoFont));
                    columnaTxt[columnas].setForeground(new Color(151, 19, 19, 250));

                    columnaTxt[columnas].setText(String.valueOf(columnas + 1));
                    columnaTxt[columnas].setHorizontalAlignment(SwingConstants.CENTER);
                    
                    frame.add(columnaTxt[columnas]);
                }
                
                asignarEquipoPieza(filas, columnas, tamaño);
                
                final int f=filas;
                final int c=columnas;
                
                tablero[f][c].addActionListener((ActionEvent e) -> {click(f, c, tamaño);});
            }
        }
        
        for (int columnas = 0; columnas <9; columnas++) {
            tablero[5][columnas].setBorderPainted(false);
            tablero[5][columnas].setBackground(new Color(64, 164, 223 , 200));
            tablero[5][columnas].setEnabled(false);
        }
        frame.add(indicadorTurno);
        frame.add(capturasJugador1);
        frame.add(capturasJugador2);
        frame.add(scrollPane);
        frame.add(jugador2);
        frame.add(logMovimientos);
        frame.add(jugador1);
        frame.add(rendirse);
        frame.add(backgroundForWords);
        frame.add(background);
        
        
        frame.setVisible(true);
        
        
        
        //BACKGROUND
        fondo(background, 50, 50, backgroundI, frame);

        postBackground(backgroundForWords, 50, 25, 1200, 694, 236, 183, 86, 200, true);

        
        //Paneles para imagenes de piezas capturadas
        jPanel(capturasJugador1, 100, 100, 210, 195, 151, 19, 19, 100);
        
        jPanel(capturasJugador2, 100, 350, 210, 195, 151, 19, 19, 100);
        //Titulo de jugador 2
        titulo(jugador1, 100, 50, 235, 42, "Dialog", 24, 151, 19, 19, 250, "Capturas de "+logUser.getNombre());

        //Titulo de jugador 1
        titulo(jugador2, 100, 300, 235, 42, "Dialog", 24, 151, 19, 19, 250, "Capturas de "+oponente.getNombre());

        //Indicador de turno
        titulo(indicadorTurno, 950, 50, 250, 42, "Dialog", 24, 151, 19, 19, 250, "Turno de: "+((turnoP==Equipo.ROJO)?logUser.getNombre()+" (Rojo)":oponente.getNombre()+" (Negro)"));
        
        //Titulo de log de movimientos
        titulo(logMovimientos, 950, 150, 250, 42, "Dialog", 24, 151, 19, 19, 250, "Log de movimientos");
        
        scrollPane.setBounds(925, 200, 300, 300);
        contenedorScroll.setEditable(false);
        contenedorScroll.setBackground(new Color(151, 19, 19, 100));
        contenedorScroll.setForeground(new Color(236, 183, 86, 250));
        contenedorScroll.setFont(new Font("Dialog", Font.BOLD, 27));
        scrollPane.setOpaque(false);
        scrollPane.setVisible(true);

        //BOTON 3 rendirse del sistema
        boton(rendirse, 50, 600, 235, 42, false, false, "Dialog", 28, "Rendirse", 151, 19, 19, 250);
        
        
        
        rendirse.addActionListener((ActionEvent e) -> {
            int opc = JOptionPane.showConfirmDialog(null, "Seguro que desea rendirse?", "Confirmacion", JOptionPane.YES_OPTION);
            if(opc==0){
            String ganador = (turnoP==Equipo.ROJO) ? oponente.getNombre() : logUser.getNombre();
            String perdedor = (turnoP==Equipo.ROJO) ? logUser.getNombre() : oponente.getNombre();
            String tipoVictoria="retiro";
            JOptionPane.showMessageDialog(null, "JUGADOR "+perdedor+" SE HA RETIRADO, FELICIDADES JUGADOR "+ganador+", HAS GANADO 3 PUNTOS", "Partida terminada", JOptionPane.YES_OPTION);

            pgInicial.manejoUser.buscarUser(ganador).sumarPuntos();
            pgInicial.manejoUser.buscarUser(ganador).agregarLog(logUser.getNombre(), oponente.getNombre(), ganador, perdedor, tipoVictoria);
            
            pgInicial.manejoUser.buscarUser(perdedor).agregarLog(logUser.getNombre(), oponente.getNombre(), ganador, perdedor, tipoVictoria);
            Pg_Principal pgPrincipal = new Pg_Principal(pgInicial);
            pgPrincipal.frame.setVisible(true);
            frame.setVisible(false);
            }
        });
    }
    
    private void asignarEquipoPieza(int fila, int columna, int tamaño){     
        if(fila==0 || fila==10){
            if(columna==0 || columna==8){
                pieza[fila][columna] = new Torre(this, fila==0?Equipo.ROJO:Equipo.NEGRO);
            }else if(columna==1 || columna==7){
                pieza[fila][columna]=new Caballo(this, fila==0?Equipo.ROJO:Equipo.NEGRO);
            }else if(columna==2 || columna==6){
                pieza[fila][columna]=new Elefante(this, fila==0?Equipo.ROJO:Equipo.NEGRO);
            }else if(columna==3 || columna==5){
                pieza[fila][columna]=new Oficial(this, fila==0?Equipo.ROJO:Equipo.NEGRO);
            }else if(columna==4){
                pieza[fila][columna]=new General(this, fila==0?Equipo.ROJO:Equipo.NEGRO);
            }
        }
        
        if(fila==2 || fila==8){
            if(columna==1 || columna==7){
                pieza[fila][columna]=new Cañon(this, fila==2?Equipo.ROJO:Equipo.NEGRO);
            }
        }
        
        if((fila==3 || fila==7) && columna%2==0){
            pieza[fila][columna]=new Soldado(this, fila==3?Equipo.ROJO:Equipo.NEGRO);
        }
        
        if (pieza[fila][columna] != null) {
            
            String imgPath = imagenR + obtenerImagePieza(pieza[fila][columna]);
            ImageIcon icon = new ImageIcon(imgPath);
            
            Image image = icon.getImage();
            Image newImg = image.getScaledInstance(tamaño, tamaño, Image.SCALE_SMOOTH);
            tablero[fila][columna].setIcon(new ImageIcon(newImg));
            
            
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
    
    public void agregarCapturaImg(Pieza pieza){
        if(pieza!=null){    
            JLabel piezaCap = new JLabel();
            piezaCap.setSize(40, 40);

            String imgPath = imagenR + obtenerImagePieza(pieza);
            ImageIcon icon = new ImageIcon(imgPath);
            
            Image image = icon.getImage();
            Image newImg = image.getScaledInstance(40, 40, Image.SCALE_SMOOTH);
            piezaCap.setIcon(new ImageIcon(newImg));
            if(turnoP== Equipo.ROJO){
                capturasJugador1.add(piezaCap);
            }if(turnoP== Equipo.NEGRO){
                capturasJugador2.add(piezaCap);
            }
        }
    }
    
    public Pieza getPieza(int filaInicial, int columnaInicial){
        return pieza[filaInicial][columnaInicial];
    }
    
    public Pieza getSiguienteCoords(int filaSiguiente, int columnaSiguiente){
        return pieza[filaSiguiente][columnaSiguiente];
    }
    
    public boolean existePieza(int fila, int columna){
        if(pieza[fila][columna]!=null){
            return true;
        }
        return false;
    }
    
    public void click(int f, int c, int tamaño){
        if(fSelect == -1 && cSelect == -1){
            if(pieza[f][c]!=null && pieza[f][c].getEquipo().equals(turnoP)){
                fSelect=f;
                cSelect=c;
                System.out.println("Logro acceder a la ficha");
                posiblesPosiciones(f, c);
                //que se muestre posibles posiciones \ Solo necesita la pieza y dos fors que recorran el arreglo
            }
        }else {
            mover(fSelect, cSelect, f, c, tamaño);
            //Funcion que mueve la ficha
            System.out.println("Accedio a moverse");
            resetColorTablero();
            //Restaura colores que cambiaron por la funcion que cambia posibles posiciones
            fSelect=-1;
            cSelect=-1;
        }
    }
    
    public void mover(int fInicial, int cInicial, int fSiguiente, int cSiguiente, int tamaño){
        Pieza piezaI = pieza[fInicial][cInicial];
        Pieza piezaC = pieza[fSiguiente][cSiguiente];

        if (pieza[fInicial][cInicial] != null) {
            if (piezaI.piezaMovimiento(fInicial, cInicial, fSiguiente, cSiguiente)) {
                pieza[fSiguiente][cSiguiente] = piezaI;
                pieza[fInicial][cInicial] = null;
                
                if (!reyesCantSee()) {
                    pieza[fInicial][cInicial] = piezaI;
                    pieza[fSiguiente][cSiguiente] = piezaC;

                    JOptionPane.showMessageDialog(null, "Ingreso un movimiento invalido", "Movimiento invalido", JOptionPane.ERROR_MESSAGE);
                    return;
                }
                
                contenedorScroll.setText(logMov(fInicial, cInicial, fSiguiente, cSiguiente, piezaC, piezaI));
                
                agregarCapturaImg(piezaC);
                
                if (piezaC instanceof General) {
                    comerRey(piezaC);
                    return;
                }
                
                
                
                String imgPath = imagenR + (obtenerImagePieza(pieza[fSiguiente][cSiguiente]).equals("generalN.png") ? "" : obtenerImagePieza(pieza[fSiguiente][cSiguiente]));
                ImageIcon icon = new ImageIcon(imgPath);
                Image image = icon.getImage();
                Image newImg = image.getScaledInstance(tamaño, tamaño, Image.SCALE_SMOOTH);
                tablero[fSiguiente][cSiguiente].setIcon(new ImageIcon(newImg));
                tablero[fInicial][cInicial].setIcon(null);
                
                turnoP = (turnoP == Equipo.ROJO) ? Equipo.NEGRO : Equipo.ROJO;
                indicadorTurno.setText("Turno de: " + ((turnoP == Equipo.ROJO) ? logUser.getNombre() + " (Rojo)" : oponente.getNombre() + " (Negro)"));
            }
        }
    }
    
    public void posiblesPosiciones(int f, int c){
        if(pieza[f][c]!=null){
            for (int fila = 0; fila < 11; fila++) {
                for (int colum = 0; colum < 9; colum++) {
                    Pieza piezaTemp = pieza[f][c];
                    if(piezaTemp.piezaMovimiento(f, c, fila, colum)){
                        tablero[fila][colum].setBackground(Color.red);
                    }
                }
            }
        }
    }
    
    public void resetColorTablero(){
        for (int filas = 0; filas < 11; filas++) {
            for (int columnas = 0; columnas < 9; columnas++) {
                if(filas>=0 && filas<=4 || filas>=6 && filas<=11){
                    tablero[filas][columnas].setBackground(new Color(252, 175, 62, 250));
                }
                if((filas>=0 && filas<=2 || filas>=8 && filas<=10) && columnas>2 && columnas<6){
                    tablero[filas][columnas].setBackground(new Color(203, 147, 65 , 250));
                }
            }
        }
    }
    
    public boolean reyesCantSee(){
        int f1=0, c1=0, f2=0, c2=0;
        
        for (int i = 0; i < 11; i++) {
            for (int j = 0; j < 9; j++) {
                if(pieza[i][j] instanceof General){
                    if(pieza[i][j].equipo.equals(Equipo.ROJO)){
                        f1=i;
                        c1=j;
                    }if(pieza[i][j].equipo.equals(Equipo.NEGRO)){
                        f2=i;
                        c2=j;
                    }
                }
            }
        }
        
        if(c1!=c2){
            return true;
        }
        
        for (int fila = Math.min(f1, f2)+1; fila < Math.max(f1, f2); fila++) {
            if(pieza[fila][c1]!=null){
                return true;
            }
        }
        
        return false;
    }
    
    public void comerRey(Pieza pieza){
        String ganador = (pieza.equipo==Equipo.NEGRO) ? logUser.getNombre() : oponente.getNombre();
        String perdedor = (pieza.equipo==Equipo.NEGRO) ? oponente.getNombre() : logUser.getNombre();
        String tipoVictoria="capturo al general";
        JOptionPane.showMessageDialog(null, "JUGADOR "+ganador+" A VENCIDO A JUGADOR "+perdedor+
        "\n FELICIDADES JUGADOR "+ganador+" HAS GANADO 3 PUNTOS", "Partida terminada", JOptionPane.YES_OPTION);
        
        pgInicial.manejoUser.buscarUser(ganador).sumarPuntos();
        pgInicial.manejoUser.buscarUser(ganador).agregarLog(logUser.getNombre(), oponente.getNombre(), ganador, perdedor, tipoVictoria);
        
        pgInicial.manejoUser.buscarUser(perdedor).agregarLog(logUser.getNombre(), oponente.getNombre(), ganador, perdedor, tipoVictoria);
        Pg_Principal pgPrincipal = new Pg_Principal(pgInicial);
        pgPrincipal.frame.setVisible(true);
        frame.setVisible(false);
        
    }
    
    public String logMov(int fInicial, int cInicial, int fSiguiente, int cSiguiente, Pieza piezaCapturada, Pieza piezaOrigen){
        
        String piezaOrigenStr = piezaNotacion(piezaOrigen);
        String piezaObjetivo = piezaNotacion(piezaCapturada);
        
        String action="";
        if(turnoP==Equipo.ROJO){
            if(!piezaObjetivo.equals("")) action= "x"+piezaObjetivo;
            else if (fSiguiente > fInicial) action = "+";
            else if (fSiguiente < fInicial) action = "-";
            else action = "=";
        }if(turnoP==Equipo.NEGRO){
            if(!piezaObjetivo.equals("")) action= "x"+piezaObjetivo;
            else if (fSiguiente > fInicial) action = "-";
            else if (fSiguiente < fInicial) action = "+";
            else action = "=";
        }
            String movimiento = piezaOrigenStr + (cInicial + 1) + action + (cSiguiente + 1);
        
            if (turnoP == Equipo.ROJO) {
            logMovTxt += movimiento;
        } else if (turnoP == Equipo.NEGRO) {
            logMovTxt += " - "+movimiento + "\n";
        }

        return logMovTxt;
    }
    
    public String piezaNotacion(Pieza pieza){
        if(pieza instanceof Caballo)return "C";
        else if(pieza instanceof Elefante)return "E";
        else if(pieza instanceof Cañon)return "Cn";
        else if(pieza instanceof Oficial)return "O";
        else if(pieza instanceof Torre)return "T";
        else if(pieza instanceof General)return "G";
        else if (pieza instanceof Soldado) return "S"; 
        return "";
    }
}
