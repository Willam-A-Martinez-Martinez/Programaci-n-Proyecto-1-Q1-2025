package ajedrez_chino;

import java.text.SimpleDateFormat;
import java.util.Calendar;
        
public class Info_user {
    private String contraseña, nombre, fecha;
    private int puntos;
    private boolean activo;
    
    
    public Info_user(String nombre, String contraseña){
        this.contraseña = contraseña;
        this.nombre = nombre;
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/YYYY");
        fecha = dateFormat.format(Calendar.getInstance().getTime());
        puntos=0;
        activo=true;
    }

    public String getContraseña() {
        return contraseña;
    }

    public String getNombre() {
        return nombre;
    }
    public String getFecha() {
        return fecha;
    }

    public int getPuntos() {
        return puntos;
    }

    public boolean isActivo() {
        return activo;
    }

    public void setPuntos(int puntos) {
        this.puntos = puntos;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }
    
    
    
}
