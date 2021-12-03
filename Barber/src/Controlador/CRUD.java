/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import java.util.List;

/**
 *
 * @author Tats5
 */
public interface CRUD<A> {
    
    public boolean agregar(A c);
    public boolean editar(A c);
    public boolean eliminar(int id);
    public List<A> obtenerTodos();
    public A obtenerPorId(int id);
    
    
}
