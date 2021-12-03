/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Entidades.Cortes;
import login.DBHelper;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Tats5
 */
public class DAOProductosIMP {

    DBHelper DB = new DBHelper();
    String Tabla = "cortes";

    public boolean agregar(Cortes p) {
        boolean rs = false;
        try {
            if (DB.connect()) {
                String query = "INSERT INTO `login`.`Cortes`(`Nombre`,`Precio`) VALUES "
                        + "('" + p.getNombre() + "',"
                        + " '" + p.getPrecio() + "')";
                rs = (boolean) DB.execute(query, true);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DB.disconnect();
        }
        return rs;

    }

    public boolean editar(Cortes p) {

        boolean rs = false;

        try {
            if (DB.connect()) {
                String query = "UPDATE `login`.`Cortes` SET  "
                        + "Nombre='" + p.getNombre() + "',"
                        + " Precio='" + p.getPrecio() + "',"
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
                String query = "DELETE FROM `login`.`Cortes` WHERE Id =" + id;
                resultado = (boolean) DB.execute(query, true);
            }
        } catch (Exception e) {

        } finally {
            DB.disconnect();
        }
        return resultado;
    }

    public Cortes obtenerPorId(int id) {
        Cortes p = new Cortes();
        String query = "SELECT * FROM " + Tabla+" WHERE Id="+id;
        try {
            if (DB.connect()) {
                ResultSet rs = (ResultSet) DB.execute(query, false);
                if (rs.next()) {
                    p.setId(rs.getInt("Id"));
                    p.setNombre(rs.getString("Nombre"));
                    p.setPrecio(rs.getInt("Precio"));
                }
            }
        } catch (Exception e) {

        } finally {
            DB.disconnect();
        }
        return p;
    }

    public List<Cortes> obtenerTodos() {
        List<Cortes> producto = new ArrayList();
        String query = "SELECT * FROM " + Tabla;
        try {
            if (DB.connect()) {
                ResultSet rs = (ResultSet) DB.execute(query, false);
                while (rs.next()) {
                    Cortes p = new Cortes();
                    p.setId(rs.getInt("Id"));
                    p.setNombre(rs.getString("Nombre"));
                    p.setPrecio(rs.getInt("Precio"));
                   
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
