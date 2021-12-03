/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidades;

/**
 *
 * @author Tats5
 */
public class Cortes {

    
    private int id;
    private String Nombre;
    private int Precio;
   
    public Cortes() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre(){
    return Nombre;
    }

    public String setNombre(String Nombre){
    this.Nombre = Nombre;
        return null;
    }
    
    public int getPrecio() {
        return Precio;
    }

    public void setPrecio(int Precio) {
        this.Precio = Precio;
    }

    
    
    
}
