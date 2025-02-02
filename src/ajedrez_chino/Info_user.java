package ajedrez_chino;

import java.text.SimpleDateFormat;
import java.util.Calendar;
        
public class Info_user {
    private String contraseña, nombre, fecha;
    private int puntos;
    private boolean activo;
    Log_Partida logPartida[]= new Log_Partida[10];
    
    
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
    
    public String puntos(){
        return nombre+"-"+puntos;
    }
    
    private int cantLogs(int cont, int cant){
        if(cont<logPartida.length){
            if(logPartida[cont]!=null){
                return cantLogs(cont+1, cant+1);
            }
            return cantLogs(cont+1, cant);
        }
        return cant;
    
    }
    
    public int cantLogs(){
        return cantLogs(0,0);
    }
    
    private void agregarLog(String jugador1, String jugador2, String ganador, int cont){
        if(cont>=logPartida.length){
            System.out.println("No hay mas espacio en el arreglo");
            return;
        }
        
        if(logPartida[cont]==null){
            
           logPartida[cont]= new Log_Partida(jugador1, jugador2, ganador);
           return;
        }
        if(logPartida[cont]!=null){
            agregarLog(jugador1, jugador2, ganador, cont+1);
        }
    }
    
    public void agregarLog(String jugador1, String jugador2, String ganador){
        agregarLog(jugador1, jugador2, ganador, 0);
    }
    
    public String imprimirLogsJuegos(){
        String logs="Logs de partidas\n";
        
        for (int i = cantLogs(); i > 0; i--) {
            logs+=logPartida[i].logPartidaImprimir();
        }
        return logs;
    }
    
}
