package ajedrez_chino;

public class Manejo_user {
    Info_user [] infoUser = new Info_user[10];
    

    //Contador de usuarios registrados
    
    private int cantUser(int cont, int cant){
        if(cont<infoUser.length){
            if(infoUser[cont]!=null){
                return cantUser(cont+1, cant+1);
            }
            return cantUser(cont+1, cant);
        }
        return cant;
    
    }
    
    public int cantUserHelp(){
        return cantUser(0,0);
    }
    
    //buscar usuario por nombre
    private boolean buscarUser(String name, int cont){
        if(cont>=infoUser.length){
            return false;
        }
        
        if(infoUser[cont].getNombre().equals(name) && infoUser[cont].getNombre()!=null){
           return true;
        }
        
        return buscarUser(name, cont+1);
    }
    
    public boolean buscarUser(String name){
        return buscarUser(name, 0);
    }
    
    //bucar usuario por nombre y contraseña
    private boolean buscarUserNC(String name, String contra, int cont){
        if(cont>=infoUser.length){
            return false;
        }
        
        if(infoUser[cont].getNombre().equals(name) && infoUser[cont].getContraseña().equals(contra) && infoUser[cont].getNombre()!=null){
           return true;
        }
        
        return buscarUserNC(name, contra, cont+1);
    }
    
    public boolean buscarUserNC(String name, String contra){
        return buscarUserNC(name, contra, 0);
    }
    
    //Agregar usuario
    
    private void agregarUser(String name, String contra, int cont){
        if(cont>=infoUser.length){
            System.out.println("No hay mas espacio en el arreglo");
            return;
        }
        
        if(infoUser[cont]==null){
           infoUser[cont]= new Info_user(name, contra);
           return;
        }
        if(infoUser[cont]!=null){
            agregarUser(name, contra, cont+1);
        }
    }
    
    public void agregarUser(String name, String contra){
        agregarUser(name, contra, 0);
    }
}
