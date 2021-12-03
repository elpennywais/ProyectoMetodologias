
package Controlador;

import Entidades.Usuario;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import login.DBHelper;

/**
 *
 * @author Tats5
 */
public class DAOUsuarioIMP implements DAOUsuario{
    
      DBHelper DB = new DBHelper();
    String Tabla ="usuario";
    
    public boolean agregar(Usuario c) {
          boolean rs= false;
          try {
            if (DB.connect()) {
            String query ="INSERT INTO `login`.`usuario`(`Nombre`,`Correo`,`Password`) VALUES " 
                        + "('" + c.getNombre() +"',"
                        + " '" + c.getCorreo() + "',"
                        + " '" + c.getPassword() + "')" ;
                    rs=(boolean) DB.execute(query, true);
            
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally{
          DB.disconnect();
          }
        return rs;
    }

    public boolean editar(Usuario c) {
     boolean rs= false;
        
        try {
            if(DB.connect()){
            String query = "UPDATE `login`.`usuario` SET"
                   + "`Nombre` = `" + c.getNombre() + "`, "
                    +"`"+c.getCorreo()+ "`, "
                    +"`"+c.getPassword()+ ")"
                     + " WHERE(`id` = `" +c.getId() + "`)";
                     rs=(boolean)DB.execute(query,true);
            }
        } catch (Exception e) {
             System.out.println(e);
        }finally{
        DB.disconnect();
        }
return rs;
    }

    public boolean eliminar(int id) {
  boolean rs= false;
        try {
            if(DB.connect()) {
                String query ="DELETE FROM `login`.`usuario` WHERE `id`='"+id+"'";
                rs = (boolean) DB.execute(query, true);
            }
        } catch (Exception e) {
        }finally{
        DB.disconnect();
        }
        return rs;
    }

    public List<Usuario> obtenerTodos() {
         List<Usuario> usuario = new ArrayList();
         String query = "SELECT * FROM " +Tabla;
         try {
             if (DB.connect()) {
                 ResultSet rs = (ResultSet) DB.execute(query, false);
                 while (rs.next()) {
                 Usuario us = new Usuario();
                 us.setId(rs.getInt("id"));
                 us.setNombre(rs.getString("Nombre"));
                 us.setCorreo(rs.getString("Correo"));
                 us.setPassword(rs.getString("Password"));
                 usuario.add(us);
                 }
             }             
        } catch (Exception e) {
           e.printStackTrace();
        }finally{
         DB.disconnect();
         }
       return usuario; 
    }

    public Usuario obtenerPorId(int id) {
        Usuario cli = new Usuario();
        
        try {
         String query = "SELECT * FROM " +Tabla+"WHERE id = "+ id;
         ResultSet rs = (ResultSet) DB.execute(query, false);
         
         if (rs.next()) {
            cli.setId(rs.getInt("id"));
            cli.setNombre(rs.getString("Nombre"));
            cli.setCorreo(rs.getString("Correo"));
            cli.setPassword(rs.getString("Password"));
            
        }
        } catch (Exception e) {
            e.printStackTrace();
        }finally{
        DB.disconnect();
        }
         return cli;

    }
    
    public List<Usuario> obtenerPorNombre(String nombre) {
      List<Usuario> us = new ArrayList();
      
          try {
              if (DB.connect()) {
                  String query = "SELECT * FROM " +Tabla+"WHERE Nombre LIKE `%"+ nombre+"%`";
                   ResultSet rs = (ResultSet) DB.execute(query, false);
                   while (rs.next()) {
                   Usuario user = new Usuario();
                   user.setId(rs.getInt("id"));
                   user.setNombre(rs.getString("Nombre"));
                   user.setCorreo(rs.getString("Correo"));
                   user.setPassword(rs.getString("Direccion"));
                   us.add(user);
          }
              }       
          } catch (Exception e) {
              e.printStackTrace();
          }finally{
          DB.disconnect();
          }     
 return us;
    }  
    
      public Usuario login(String Correo, String Password){
         Usuario u = new Usuario();
        
        try {
            
            if(DB.connect()){
                StringBuilder sql = new StringBuilder();
                
                sql.append("SELECT * FROM usuario ")
                   .append(" WHERE Correo LIKE '").append(Correo).append("' ")
                   .append(" AND Password LIKE MD5('").append(Password).append("')");
                
                ResultSet rs = (ResultSet) DB.execute(sql.toString(), false);
                
                if(rs.next()){
                    
                    u.setId(rs.getInt("Id"));
                    u.setNombre(rs.getString("Usuario"));
                    u.setCorreo(rs.getString("Correo"));
                    u.setPassword(rs.getString("Password"));
                   
                }
                
            }else{
                System.out.println("exploto: "+DB.getError());
            }
            
        } catch (Exception e) {
            System.out.println("exploto: "+e.getMessage());
        }finally{
            DB.disconnect();
        }
        return u;
    }
   
}