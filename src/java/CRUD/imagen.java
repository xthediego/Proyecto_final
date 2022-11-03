

package CRUD;

import java.sql.Blob;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.util.HashMap;
import javax.swing.table.DefaultTableModel;
/**
 *
 * @author Diego Sandoval
 */
public class imagen {
    private int id_imagen;
    private String nombre;
    private String archivo;
    conexion cn;
    
    public imagen(){}

    public imagen(int id_imagen, String nombre, String archivo) {
        this.id_imagen = id_imagen;
        this.nombre = nombre;
        this.archivo = archivo;
    }

    public int getId_imagen() {
        return id_imagen;
    }

    public void setId_imagen(int id_imagen) {
        this.id_imagen = id_imagen;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getArchivo() {
        return archivo;
    }

    public void setArchivo(String archivo) {
        this.archivo = archivo;
    }
    
    //AGREGAMOS SQL
   
    public int agregar(){
    int retorno = 0;
     try{
            PreparedStatement parametro;
            
            cn = new conexion();
            cn.abrir_conexion();
            String query = "INSERT INTO imagen(nombre,archivo) VALUES (?,?)";
            cn.abrir_conexion();
            parametro = (PreparedStatement)cn.conexionBD.prepareStatement(query);
            
            parametro.setString(1,this.getNombre());
            //parametro.setBlob(2,this.getImagen());
            
            
            int executar = parametro.executeUpdate();
            retorno = executar;
            cn.close_conexion();
        }catch(SQLException ex){
            System.out.println(ex.getMessage());
        } 
         
    return retorno;
    }

    

    
    
    
}
