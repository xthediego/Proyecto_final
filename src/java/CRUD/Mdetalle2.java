
package CRUD;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import javax.swing.table.DefaultTableModel;

public class Mdetalle2 {
   private int id_compra, no_orden_compra,id_proveedores;
   private String fecha_orden,fecha_ingreso;
   
   private int id_compra_detalle,id_compraa,id_producto,cantidad,precio_costo_unitario;
   

   conexion cn;

    public Mdetalle2() {
    }



    public int getId_compra() {
        return id_compra;
    }

    public void setId_compra(int id_compra) {
        this.id_compra = id_compra;
    }

    public int getNo_orden_compra() {
        return no_orden_compra;
    }

    public void setNo_orden_compra(int no_orden_compra) {
        this.no_orden_compra = no_orden_compra;
    }

    public int getId_proveedores() {
        return id_proveedores;
    }

    public void setId_proveedores(int id_proveedores) {
        this.id_proveedores = id_proveedores;
    }

    public String getFecha_orden() {
        return fecha_orden;
    }

    public void setFecha_orden(String fecha_orden) {
        this.fecha_orden = fecha_orden;
    }

    public String getFecha_ingreso() {
        return fecha_ingreso;
    }

    public void setFecha_ingreso(String fecha_ingreso) {
        this.fecha_ingreso = fecha_ingreso;
    }

    public int getId_compra_detalle() {
        return id_compra_detalle;
    }

    public void setId_compra_detalle(int id_compra_detalle) {
        this.id_compra_detalle = id_compra_detalle;
    }

    public int getId_compraa() {
        return id_compraa;
    }

    public void setId_compraa(int id_compraa) {
        this.id_compraa = id_compraa;
    }

    public int getId_producto() {
        return id_producto;
    }

    public void setId_producto(int id_producto) {
        this.id_producto = id_producto;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public int getPrecio_costo_unitario() {
        return precio_costo_unitario;
    }

    public void setPrecio_costo_unitario(int precio_costo_unitario) {
        this.precio_costo_unitario = precio_costo_unitario;
    }
    
    
    
    public Mdetalle2(int id_compra, int no_orden_compra, int id_proveedores, String fecha_orden, String fecha_ingreso) {
        this.id_compra = id_compra;
        this.no_orden_compra = no_orden_compra;
        this.id_proveedores = id_proveedores;
        this.fecha_orden = fecha_orden;
        this.fecha_ingreso = fecha_ingreso;
    }
    
    
    public int agregar(){
        int retorno = 0;
        try{
            cn = new conexion();
            
            PreparedStatement parametro;
            String query = "INSERT INTO compras(no_orden_compra,id_proveedores,fecha_orden,fecha_ingreso)VALUES(?,?,?,?); "; 
            cn.abrir_conexion();
            parametro = (PreparedStatement) cn.conexionBD.prepareStatement(query);
            
            
            parametro.setInt(1,getNo_orden_compra());
            parametro.setInt(2,getId_proveedores());
            parametro.setString(3,getFecha_orden());
            parametro.setString(4,getFecha_ingreso());
            
            
            retorno = parametro.executeUpdate();
            cn.close_conexion();
        }catch(SQLException ex){
        
            System.out.println(ex.getMessage());
            retorno=0;
        }
            return retorno;
    }

     
      public int modify(){
         
         int retorno = 0;
     try{
            PreparedStatement parametro;
            
            cn = new conexion();
            cn.abrir_conexion();
            String query = "update compras set no_orden_compra=?,id_proveedores=?,fecha_orden=?,fecha_ingreso=? where id_compra=?";
            parametro = (PreparedStatement)cn.conexionBD.prepareStatement(query);
            
            parametro.setInt(1,getNo_orden_compra());
            parametro.setInt(2,getId_proveedores());
            parametro.setString(3,getFecha_orden());
            parametro.setString(4,getFecha_ingreso()); 
            
            parametro.setInt(5, getId_compra());
            
           
            int executar = parametro.executeUpdate();
            retorno = executar;
            cn.close_conexion();
        }catch(SQLException ex){
            System.out.println(ex.getMessage());
        } 
         return retorno;
     }
      
      //**********************************codigo de eliminar
       public int delete(){
         int retorno = 0;
        try{
            PreparedStatement parametro;
            
            cn = new conexion();
            cn.abrir_conexion();
            String query = "delete from compras  where id_compra=?;";
            parametro = (PreparedStatement)cn.conexionBD.prepareStatement(query);

            parametro.setInt(1,getId_compra());
            int executar = parametro.executeUpdate();
            retorno = executar;
            cn.close_conexion();
        }catch(SQLException ex){
            System.out.println(ex.getMessage());
        }
        return retorno;
    
    } 
      
    
    
    
    
    
    
    public Mdetalle2(int id_compra_detalle, int id_compraa, int id_producto, int cantidad, int precio_costo_unitario) {
        this.id_compra_detalle = id_compra_detalle;
        this.id_compraa = id_compraa;
        this.id_producto = id_producto;
        this.cantidad = cantidad;
        this.precio_costo_unitario = precio_costo_unitario;
    }
    
    
    public int agregar1(){
        int retorno = 0;
        try{
            cn = new conexion();
            
            PreparedStatement parametro;
            String query = "INSERT INTO compras_detalle(id_compra,id_producto,cantidad,precio_costo_unitario)VALUES(?,?,?,?); "; 
            cn.abrir_conexion();
            parametro = (PreparedStatement) cn.conexionBD.prepareStatement(query);
            
            
            parametro.setInt(1,getId_compraa());
            parametro.setInt(2,getId_producto());
            parametro.setInt(3,getCantidad());
            parametro.setInt(4,getPrecio_costo_unitario());
            
            
            retorno = parametro.executeUpdate();
            cn.close_conexion();
        }catch(SQLException ex){
        
            System.out.println(ex.getMessage());
            retorno=0;
        }
            return retorno;
    }

     
      public int modify1(){
         
         int retorno = 0;
     try{
            PreparedStatement parametro;
            
            cn = new conexion();
            cn.abrir_conexion();
            String query = "update compras_detalle set id_compra=?,id_producto=?,cantidad=?,precio_costo_unitario=? where id_compra_detalle=?";
            parametro = (PreparedStatement)cn.conexionBD.prepareStatement(query);
            
            parametro.setInt(1,getId_compra());
            parametro.setInt(2,getId_producto());
            parametro.setInt(3,getCantidad());
            parametro.setInt(4,getPrecio_costo_unitario());    
            parametro.setInt(5, getId_compra_detalle());
            
           
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
            String query = "delete from compras_detalle  where id_compra_detalle=?;";
            parametro = (PreparedStatement)cn.conexionBD.prepareStatement(query);

            parametro.setInt(1,getId_compra_detalle());
            int executar = parametro.executeUpdate();
            retorno = executar;
            cn.close_conexion();
        }catch(SQLException ex){
            System.out.println(ex.getMessage());
        }
        return retorno;
    
    } 
      
      
      
    
      //SELECC leer
    
    public DefaultTableModel leer(){
        DefaultTableModel tabla = new DefaultTableModel();
        
        try{
            cn = new conexion();
            cn.abrir_conexion();
            String query=" SELECT v.id_compra,v.no_orden_compra, v.id_proveedores,v.fecha_orden,v.fecha_ingreso,t.id_compra_detalle, t.id_compra,t.id_producto,t.cantidad,t.precio_costo_unitario FROM  compras as v,  compras_detalle as t where v.id_compra = t.id_compra; ";
            
            
            ResultSet consulta = cn.conexionBD.createStatement().executeQuery(query);
            
            
            String encabezados[]= {"id_compra","no_orden_compra","id_proveedores","fecha_orden","fecha_ingreso","id_compra_detalle","id_compras","id_producto","cantidad","precio_costo_unitario"};
            tabla.setColumnIdentifiers(encabezados);
            
            String datos[]= new String[10];
            while(consulta.next()){
                
                datos[0]= consulta.getString("v.id_compra");
                datos[1]= consulta.getString("v.no_orden_compra");
                datos[2]= consulta.getString("v.id_proveedores");
                datos[3]= consulta.getString("v.fecha_orden");
                datos[4]= consulta.getString("v.fecha_ingreso");
                
                datos[5]= consulta.getString("t.id_compra_detalle");
                datos[6]= consulta.getString("t.id_compra");
                datos[7]= consulta.getString("t.id_producto");
                datos[8]= consulta.getString("t.cantidad");
                datos[9]= consulta.getString("t.precio_costo_unitario");
                
                
             
                
                tabla.addRow(datos);
            }   
            
            cn.close_conexion();
        }catch(SQLException ex){
            System.out.println(ex.getMessage());
        }
        
        return tabla;
    }
      
      
}
