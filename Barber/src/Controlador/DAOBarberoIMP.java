/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Entidades.Barbero;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import login.DBHelper;

/**
 *
 * @author Tats5
 */
public class DAOBarberoIMP {

    DBHelper DB = new DBHelper();
    String Tabla = "barbero";

    public boolean agregar(Barbero p) {
        boolean rs = false;
        try {
            if (DB.connect()) {
                String query = "INSERT INTO `login`.`tipo_usuario`(`Nombre`) VALUES "
                        + "('" + p.getNombre() + "')";
                rs = (boolean) DB.execute(query, true);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DB.disconnect();
        }
        return rs;

    }

    public boolean editar(Barbero p) {

        boolean rs = false;

        try {
            if (DB.connect()) {
                String query = "UPDATE `login`.`tipo_usuario` SET  "
                        + "Nombre='" + p.getNombre() + "',"
                        
                        + " WHERE Id = " + p.getId();
                rs = (boolean) DB.execute(query, true);
                System.out.println(query);
            }
        } catch (Exception e) {
            System.out.println(e);
        } finally {
            DB.disconnect();
        }
        return rs;
    }

    public boolean eliminar(int id) {
        boolean resultado = false;

        try {
            if (DB.connect()) {
                String query = "DELETE FROM `login`.`tipo_usuario` WHERE Id =" + id;
                resultado = (boolean) DB.execute(query, true);
            }
        } catch (Exception e) {

        } finally {
            DB.disconnect();
        }
        return resultado;
    }

    public Barbero obtenerPorId(int id) {
        Barbero b = new Barbero();
        String query = "SELECT * FROM " + Tabla+" WHERE Id="+id;
        try {
            if (DB.connect()) {
                ResultSet rs = (ResultSet) DB.execute(query, false);
                if (rs.next()) {
                    b.setId(rs.getInt("Id"));
                    b.setNombre(rs.getString("Nombre"));
                   
                   
                }
            }
        } catch (Exception e) {

        } finally {
            DB.disconnect();
        }
        return b;
    }

    public List<Barbero> obtenerTodos() {
        List<Barbero> producto = new ArrayList();
        String query = "SELECT * FROM " + Tabla;
        try {
            if (DB.connect()) {
                ResultSet rs = (ResultSet) DB.execute(query, false);
                while (rs.next()) {
                    Barbero p = new Barbero();
                    p.setId(rs.getInt("Id"));
                    p.setNombre(rs.getString("Nombre"));
                  
                    producto.add(p);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DB.disconnect();
        }
        return producto;

    }

}
