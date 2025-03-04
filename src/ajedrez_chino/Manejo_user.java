package ajedrez_chino;

public class Manejo_user implements manejoDatos{
    Info_user [] infoUser;
    
    public Manejo_user(){
        infoUser = new Info_user[10];
    }

    //Contador de usuarios registrados
    
    private int cantUser(int cont, int cant){
        if(cont<infoUser.length){
            if(infoUser[cont]!=null && infoUser[cont].getNombre()!=null){
                return cantUser(cont+1, cant+1);
            }
            return cantUser(cont+1, cant);
        }
        return cant;
    
    }
    
    public int cantUserHelp(){
        return cantUser(0,0);
    }
    
    //buscar usuario por nombre         p         0 1
    private Info_user buscarUser(String name, int cont){
        if(cont>=infoUser.length){
            System.out.println(cont);
            return null;
        }
        
        if(infoUser[cont]!=null && infoUser[cont].getNombre()!=null){
            if(infoUser[cont].getNombre().equals(name)){
                return infoUser[cont];
            }
        }
        
        return buscarUser(name, cont+1);
    }
    
    public Info_user buscarUser(String name){
        return buscarUser(name, 0);
    }
    
    //bucar usuario por nombre y contraseña
    private Info_user buscarUserNC(String name, String contra, int cont){
        if(cont>=infoUser.length){
            return null;
        }
        
        if(infoUser[cont]!=null){
            if(infoUser[cont].getNombre()!=null && infoUser[cont].getContraseña()!=null)
                if(infoUser[cont].getNombre().equals(name) && infoUser[cont].getContraseña().equals(contra)){
                    return infoUser[cont];
                }
        }
        
        return buscarUserNC(name, contra, cont+1);
    }
    
    public Info_user buscarUserNC(String name, String contra){
        return buscarUserNC(name, contra, 0);
    }
    
    //Agregar usuario
    
    private void agregarUser(String name, String contra, int cont){
        name = name.trim().replaceAll("\\s+", " ");
        if(cont>=infoUser.length){
            System.out.println("No hay mas espacio en el arreglo");
            return;
        }
        
        if(infoUser[cont]==null){
            
           infoUser[cont]= new Info_user(name, contra);
           System.out.println("Usuario agregado: " + name);
            System.out.println("Usuario en arreglo: "+ infoUser[cont].getNombre());
           return;
        }
        if(infoUser[cont]!=null){
            agregarUser(name, contra, cont+1);
        }
    }
    
    public void agregarUser(String name, String contra){
        agregarUser(name, contra, 0);
    }
    
    private void eliminarUser(String name, String contra, int cont) {
    if (cont >= infoUser.length) {
        System.out.println("No se encontró el usuario.");
        return;
    }

    if (infoUser[cont] != null && infoUser[cont].getNombre() != null && infoUser[cont].getContraseña() != null) {
        if (infoUser[cont].getNombre().equals(name) && infoUser[cont].getContraseña().equals(contra)) {
            infoUser[cont] = null;
            System.out.println("Usuario eliminado: " + name);
            return;
        }
    }

    eliminarUser(name, contra, cont + 1);
}

public void eliminarUser(String name, String contra) {
    eliminarUser(name, contra, 0);
}
    
    public String rankingJugadores(){
        String ranking="Ranking de jugadores\n\nPuesto - Jugador - Puntos\n";
        Info_user temp;
        
        for (int i = 0; i < cantUserHelp(); i++) {
            for (int j = 1; j < cantUserHelp(); j++) {
                if(infoUser[i]!=null){
                    if(infoUser[j-1].getPuntos()<infoUser[j].getPuntos()){
                        temp=infoUser[j-1];
                        infoUser[j-1]=infoUser[j];
                        infoUser[j]=temp;
                    }
                }
            }
        }
        
        for (int i = 0; i < cantUserHelp(); i++) {
            if(infoUser[i]!=null){
                ranking+="      "+(i+1)+"     -       "+infoUser[i].getNombre()+"     -     "+infoUser[i].getPuntos()+"\n";
                System.out.println(ranking);
            }
        }
        
        return ranking;
    }
    
    public String[] listaContrincantes(String []a, String logUser){
        for (int i = 0; i < infoUser.length; i++) {
            if(infoUser[i]!=null){
               if(!infoUser[i].getNombre().equals(logUser)){
                   a[i]=infoUser[i].getNombre();
               }
            }
        }
        return a;
    }
}
