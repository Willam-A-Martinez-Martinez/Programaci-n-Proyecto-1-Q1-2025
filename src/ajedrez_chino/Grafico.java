package ajedrez_chino;

import java.awt.Color;
import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JToggleButton;
import javax.swing.JComboBox;
import static javax.swing.WindowConstants.EXIT_ON_CLOSE;


public class Grafico {
    public void confFrame(JFrame frame, ImageIcon icon, String title,int width,int heigth){
        frame.setIconImage(icon.getImage());
        frame.setTitle(title);
        frame.setSize(width, heigth);
        frame.setLocationRelativeTo(null);
        frame.setLayout(null);
        frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
    
    public void fondo(JLabel a, int widthExtra, int heightExtra, ImageIcon icon, JFrame frame){
        a.setBounds(0, 0, (frame.getWidth()+widthExtra), (frame.getHeight()+heightExtra));
        a.setIcon(icon);
    }
    
    public void postBackground(JLabel a, int x, int y, int width, int heigth, int r, int g, int b, int opaque, boolean isOpaque){
        a.setBounds(x, y, width, heigth);
        a.setBackground(new Color(r, g, b, opaque));
        a.setOpaque(isOpaque);
    }
    
    public void titulo(JLabel a, int x, int y, int width, int heigth, String font, 
    int fSize, int r , int g, int b, int opaque, String text){
        a.setBounds(x, y, width, heigth);
        a.setFont(new Font(font, Font.BOLD, fSize));
        a.setForeground(new Color(r, g, b, opaque));
        a.setText(text);
    }
    
    public void textfield(JTextField a, int x, int y, int width, int heigth, String font, int fSize){
        a.setBounds(x, y, width, heigth);
        a.setText("");
        a.setFont(new Font(font, Font.PLAIN, fSize));
    }
    
    public void passwordfield(JPasswordField a, int x, int y, int width, int heigth, String font, int fSize){
        a.setBounds(x, y, width, heigth);
        a.setText("");
        a.setFont(new Font(font, Font.PLAIN, fSize));
    }
    
    public void boton(JButton a,int x, int y, int width, int heigth, boolean setBorderPainted, boolean setContentAreaFilled, String font, int size, String texto, int r , int g, int b, int opaque){
        a.setBounds(x, y, width, heigth);
        a.setBorderPainted(setBorderPainted);
        a.setContentAreaFilled(setContentAreaFilled);
        a.setFont(new Font(font, Font.BOLD, size));
        a.setText(texto);
        a.setForeground(new Color(r, g, b, opaque));
    }
    
    public void toggleButton(JToggleButton a,int x, int y, int width, int heigth, boolean setBorderPainted, boolean setContentAreaFilled, String font, int size, String texto, int r , int g, int b, int opaque){
        a.setBounds(x, y, width, heigth);
        a.setBorderPainted(setBorderPainted);
        a.setContentAreaFilled(setContentAreaFilled);
        a.setFont(new Font(font, Font.BOLD, size));
        a.setText(texto);
        a.setForeground(new Color(r, g, b, opaque));
        
    }
    
    
}
