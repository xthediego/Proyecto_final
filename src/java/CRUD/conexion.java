/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package CRUD;
import java.sql.Connection;
import java.sql.DriverManager;
import javax.swing.JOptionPane;
/**
 *
 * @author Diego Sandoval
 */
public class conexion {
    
    
    public Connection conexionBD;
    
    public final String bd = "proyecto";
    public final String urlConexion = String.format("jdbc:mysql://localhost:3308/%s",bd);
    public final String usuario = "proyectof";
    public final String contra = "123";
    public final String jdbc = "com.mysql.cj.jdbc.Driver";
    
    public void abrir_conexion(){
        
        try{
            Class.forName(jdbc);
            conexionBD = DriverManager.getConnection(urlConexion,usuario,contra);
            JOptionPane.showMessageDialog(null,"conexion exitosa","Exito",JOptionPane.INFORMATION_MESSAGE);
            
        }catch(Exception ex){
            System.out.println("error..."+ ex.getMessage());
        }
    }
    
    public void close_conexion(){
        
        try{
            conexionBD.close();
            
        }catch(Exception ex){
            System.out.println("error..."+ ex.getMessage());
        }
    }

    public Connection getConnection() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
    
    
}


