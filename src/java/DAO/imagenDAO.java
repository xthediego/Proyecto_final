
package DAO;

import CRUD.conexion;
import CRUD.imagen;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;


public class imagenDAO {
    Connection con;
    conexion cn;
    PreparedStatement ps;
    ResultSet rs;
    int r=0;
    public int agregar(imagen p){
    cn=new conexion();
    String sql=("insert into imagen(nombre,archivo) values(?,?);");
        try{
            con=cn.getConnection();
            cn.abrir_conexion();
            ps=con.prepareStatement(sql);
            ps.setString(1,p.getNombre());
            ps.setString(2, p.getArchivo());
            ps.executeUpdate();
            
        }catch(Exception ex){
        
        }
        
       return r; 
    }
    
}
