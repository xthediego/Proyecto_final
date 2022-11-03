
package CRUD;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import javax.swing.table.DefaultTableModel;

public class proveedores {
    
    private int id_proveedores;
    private String proveedor,nit,direccion,telefono;
    conexion cn;
    
    public proveedores(){}
    public proveedores(int id_proveedores, String proveedor, String nit, String direccion, String telefono) {
        this.id_proveedores = id_proveedores;
        this.proveedor = proveedor;
        this.nit = nit;
        this.direccion = direccion;
        this.telefono = telefono;
    }

    public int getId_proveedores() {
        return id_proveedores;
    }

    public void setId_proveedores(int id_proveedores) {
        this.id_proveedores = id_proveedores;
    }

    public String getProveedor() {
        return proveedor;
    }

    public void setProveedor(String proveedor) {
        this.proveedor = proveedor;
    }

    public String getNit() {
        return nit;
    }

    public void setNit(String nit) {
        this.nit = nit;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }
    
       //AGREGAMOS SQL
    
    public int agregar(){
        int retorno = 0;
        try{
            cn = new conexion();
            
            PreparedStatement parametro;
            String query = "INSERT INTO proveedores(proveedor,nit,direccion,telefono) VALUES(?,?,?,?); "; 
            cn.abrir_conexion();
            parametro = (PreparedStatement) cn.conexionBD.prepareStatement(query);
            
            
            parametro.setString(1,getProveedor());
            parametro.setString(2,getNit());
            parametro.setString(3,getDireccion());           
            parametro.setString(4,getTelefono());
            
            retorno = parametro.executeUpdate();
            cn.close_conexion();
        }catch(SQLException ex){
        
            System.out.println(ex.getMessage());
            retorno=0;
        }
            return retorno;
    }
    
    //SELECC leer
    
    public DefaultTableModel leer(){
        
        DefaultTableModel tabla = new DefaultTableModel();
        
        try{
            cn = new conexion();
            cn.abrir_conexion();
            String query="SELECT id_proveedores as id, proveedor,nit,direccion,telefono FROM proveedores;";
            
            ResultSet consulta = cn.conexionBD.createStatement().executeQuery(query);
            
            String encabezados[]= {"id","proveedor","nit","direccion","telefono"};
            tabla.setColumnIdentifiers(encabezados);
            
            String datos[]= new String[5];
            while(consulta.next()){
                
                datos[0]= consulta.getString("id");
                datos[1]= consulta.getString("proveedor");
                datos[2]= consulta.getString("nit");
                datos[3]= consulta.getString("direccion");
                datos[4]= consulta.getString("telefono");
                

                tabla.addRow(datos);
            }   
            
            cn.close_conexion();
        }catch(SQLException ex){
            System.out.println(ex.getMessage());
        }
        
        return tabla;
    }
    
    
      ////////////////*************************aqui inicia el codigo nuevo 
    
     public int modify(){
         
         int retorno = 0;
     try{
            PreparedStatement parametro;
            
            cn = new conexion();
            cn.abrir_conexion();
            String query = "update proveedores set proveedor=?,nit=?,direccion=?,telefono=? where id_proveedores=?";
            parametro = (PreparedStatement)cn.conexionBD.prepareStatement(query);
            
            parametro.setString(1,getProveedor());
            parametro.setString(2,getNit());
            parametro.setString(3,getDireccion());
            parametro.setString(4,getTelefono());    
            parametro.setInt(5, this.getId_proveedores());
            
           
            int executar = parametro.executeUpdate();
            retorno = executar;
            cn.close_conexion();
        }catch(SQLException ex){
            System.out.println(ex.getMessage());
        } 
         return retorno;
     }
     
     //**********************************codigo de eliminar
       public int delete1(){
         int retorno = 0;
     try{
            PreparedStatement parametro;
            
            cn = new conexion();
            cn.abrir_conexion();
            String query = "delete from proveedores  where id_proveedores=?;";
            parametro = (PreparedStatement)cn.conexionBD.prepareStatement(query);

            parametro.setInt(1, this.getId_proveedores());
            
            int executar = parametro.executeUpdate();
            retorno = executar;
            cn.close_conexion();
        }catch(SQLException ex){
            System.out.println(ex.getMessage());
        }
        return retorno;
    
    }
    
    
}
