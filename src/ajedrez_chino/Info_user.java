/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ajedrez_chino;

import java.text.SimpleDateFormat;
import java.util.Calendar;
        
public class Info_user {
    private String contraseña, nombre, fecha;
    private int puntos, partidasG, partidasP;

    
    
    public Info_user(String contraseña, String nombre){
        this.contraseña = contraseña;
        this.nombre = nombre;
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
        fecha = dateFormat.format(Calendar.getInstance().getTime());
        this.partidasG = 0;
        this.partidasP = 0;
        puntos=0;
    }

    public String getContraseña() {
        return contraseña;
    }

    public String getNombre() {
        return nombre;
    }

    public int getPartidasG() {
        return partidasG;
    }

    public int getPartidasP() {
        return partidasP;
    }

    public String getFecha() {
        return fecha;
    }

    public int getPuntos() {
        return puntos;
    }

    public void setPuntos(int puntos) {
        this.puntos = puntos;
    }

    public void setPartidasG(int partidasG) {
        this.partidasG = partidasG;
    }

    public void setPartidasP(int partidasP) {
        this.partidasP = partidasP;
    }
    
    
    
}
