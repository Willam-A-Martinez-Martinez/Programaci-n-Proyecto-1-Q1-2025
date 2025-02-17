/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package ajedrez_chino;

/**
 *
 * @author DELL
 */
public interface manejoDatos {
    void agregarUser(String name, String contra);
    Info_user buscarUser(String name);
    Info_user buscarUserNC(String name, String contra);
    void eliminarUser(String name, String contra);
    int cantUserHelp();
}
