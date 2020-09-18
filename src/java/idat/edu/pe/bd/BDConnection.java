
package idat.edu.pe.bd;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class BDConnection {
    
    private final String url = "jdbc:sqlserver://DESKTOP-VIT2DB8:1433;databaseName=bdnotas";
    private final String user = "sa";
    private final String password ="123456";
    private final String driver = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
    Connection conexion;
    public BDConnection() {
    }
    public Connection conectar(){
        try{
            Class.forName(driver);
            conexion= (Connection)DriverManager.getConnection(url, user, password);
            System.out.println("Se conectó a la BD");
        }catch(ClassNotFoundException|SQLException ex){
            System.out.println(ex.getMessage());
        }
        return conexion;
    }
    public void desconectar(){
        try{
            conexion.close();
        }catch(SQLException ex){
            System.out.println("No se pudo cerrar la conexión.");
        }
    }
}
