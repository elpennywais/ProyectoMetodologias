
package login;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author tats
 */
public class DBHelper {
    
 Connection connection;
 String error;
 String controller = "com.mysql.jdbc.Driver";
 String database = "jdbc:mysql://localhost/login?serverTimezone=UTC";
 String user = "root";
 String password = "";

    public DBHelper() {
    }
 
 public DBHelper(String controller, String database, String user, String password) {
        this.controller = controller;
        this.database = database;
        this.user = user;
        this.password = password;
    }

public boolean connect() throws SQLException{
    try {
        Class.forName(this.controller);
        
        setConnection(DriverManager.getConnection(this.database,this.user,this.password));
        
    } catch (ClassNotFoundException e) {//Sucede si no se encuentra el driver
        e.printStackTrace();
    }catch (SQLException e){//Sucede si la conexion falla
        e.printStackTrace();
    }
    return true;
}
    public Object execute(String sql, boolean data_manipule){
        
        try {
            Statement sentencia = getConnection().createStatement
        (ResultSet.TYPE_FORWARD_ONLY, ResultSet.CONCUR_READ_ONLY);
            
            if(data_manipule){
                if(sentencia.executeUpdate(sql)>0){
                    sentencia.close();
                    return true;
                }else{
                    sentencia.close();
                    return false;
                }
            }else{
                ResultSet resultado = sentencia.executeQuery(sql);
                return resultado;
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        }
    }
    
    public void disconnect(){
        try {
            getConnection().close();
        } catch (Exception ex) {
          ex.printStackTrace();

        }
    }
    public String getMensajeError(){
        return getError();
    }
    
    public Connection getConnection() {
        return connection;
    }

    public void setConnection(Connection connection) {
        this.connection = connection;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public String getController() {
        return controller;
    }

    public void setController(String controller) {
        this.controller = controller;
    }

    public String getDatabase() {
        return database;
    }

    public void setDatabase(String database) {
        this.database = database;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

 
 
    
}
