
package CRUD;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import javax.swing.table.DefaultTableModel;


public class productos {
    private int id_producto, idmarca, precio_costo, precio_venta, existencia;
    private String producto,descripcion,imagen,fecha_ingreso;

    conexion cn;
    
    public productos(){}
    public productos(int id_producto, int idmarca, int precio_costo, int precio_venta, int existencia, String producto, String descripcion, String imagen, String fecha_ingreso) {
        this.id_producto = id_producto;
        this.idmarca = idmarca;
        this.precio_costo = precio_costo;
        this.precio_venta = precio_venta;
        this.existencia = existencia;
        this.producto = producto;
        this.descripcion = descripcion;
        this.imagen = imagen;
        this.fecha_ingreso = fecha_ingreso;
    }

    public int getId_producto() {
        return id_producto;
    }

    public void setId_producto(int id_producto) {
        this.id_producto = id_producto;
    }

    public int getIdmarca() {
        return idmarca;
    }

    public void setIdmarca(int idmarca) {
        this.idmarca = idmarca;
    }

    public int getPrecio_costo() {
        return precio_costo;
    }

    public void setPrecio_costo(int precio_costo) {
        this.precio_costo = precio_costo;
    }

    public int getPrecio_venta() {
        return precio_venta;
    }

    public void setPrecio_venta(int precio_venta) {
        this.precio_venta = precio_venta;
    }

    public int getExistencia() {
        return existencia;
    }

    public void setExistencia(int existencia) {
        this.existencia = existencia;
    }

    public String getProducto() {
        return producto;
    }

    public void setProducto(String producto) {
        this.producto = producto;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    public String getFecha_ingreso() {
        return fecha_ingreso;
    }

    public void setFecha_ingreso(String fecha_ingreso) {
        this.fecha_ingreso = fecha_ingreso;
    }
    
    
    //AGREGAMOS SQL
    
    public int agregar(){
        int retorno = 0;
        try{
            cn = new conexion();
            
            PreparedStatement parametro;
            String query = "INSERT INTO productos(producto,idmarca,descripcion,imagen,precio_costo,precio_venta,existencia,fecha_ingreso) VALUES(?,?,?,?,?,?,?,?); "; 
            cn.abrir_conexion();
            parametro = (PreparedStatement) cn.conexionBD.prepareStatement(query);
            
            
            parametro.setString(1,getProducto());
            parametro.setInt(2,getIdmarca());
            parametro.setString(3,getDescripcion());
            parametro.setString(4,getImagen());
            parametro.setInt(5,getPrecio_costo());
            parametro.setInt(6,getPrecio_venta());
            parametro.setInt(7,getExistencia());
            parametro.setString(8,getFecha_ingreso());
           
            
            
            
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
            String query="SELECT id_producto as id, producto,idmarca,descripcion,imagen,precio_costo,precio_venta,existencia,fecha_ingreso FROM productos;";
            
            ResultSet consulta = cn.conexionBD.createStatement().executeQuery(query);
            
            String encabezados[]= {"id","producto","idmarca","descripcion","imagen","precio_costo","precio_venta","existencia","fecha_ingreso" };
            tabla.setColumnIdentifiers(encabezados);
            
            String datos[]= new String[9];
            while(consulta.next()){
                
                datos[0]= consulta.getString("id");
                datos[1]= consulta.getString("producto");
                datos[2]= consulta.getString("idmarca");
                datos[3]= consulta.getString("descripcion");
                datos[4]= consulta.getString("imagen");
                datos[5]= consulta.getString("precio_costo");
                datos[6]= consulta.getString("precio_venta");
                datos[7]= consulta.getString("existencia");
                datos[8]= consulta.getString("fecha_ingreso");
                
                
                tabla.addRow(datos);
            }   
            
            cn.close_conexion();
        }catch(SQLException ex){
            System.out.println(ex.getMessage());
        }
        
        return tabla;
    }
    
    
    //imprimer generos select 
    //select para marcas
    private String marca;
    //private String genero; ya inicializado arriba
    
    public HashMap txt_idmarca(){
        HashMap<String,String> dropp = new HashMap();
        
        try{
            cn = new conexion();
            String query="SELECT id_marca as id,marca FROM marcas;";
            cn.abrir_conexion();
            ResultSet consulta = cn.conexionBD.createStatement().executeQuery(query);
            
            while(consulta.next()){
                dropp.put(consulta.getString("id"), consulta.getString("marca"));
        
            }
            
            cn.close_conexion();
        }catch(SQLException ex){
                System.out.println(ex.getMessage());
        }
        
        
        return dropp;
    }
    
    
       ////////////////*************************aqui inicia el codigo nuevo 
    
     public int modify(){
         
         int retorno = 0;
     try{
            PreparedStatement parametro;
            
            cn = new conexion();
            cn.abrir_conexion();
            String query = "update productos set producto=?,idmarca=?,descripcion=?,imagen=?,precio_costo=?,precio_venta=?,existencia=?,fecha_ingreso=? where id_producto=?";
            parametro = (PreparedStatement)cn.conexionBD.prepareStatement(query);
            parametro.setString(1,getProducto());
            parametro.setInt(2,getIdmarca());
            parametro.setString(3,getDescripcion());
            parametro.setString(4,getImagen());
            parametro.setInt(5,getPrecio_costo());
            parametro.setInt(6,getPrecio_venta());
            parametro.setInt(7,getExistencia());
            parametro.setString(8,getFecha_ingreso());       
            parametro.setInt(9, this.getId_producto());
            
           
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
            String query = "delete from productos  where id_producto=?;";
            parametro = (PreparedStatement)cn.conexionBD.prepareStatement(query);

            parametro.setInt(1,getId_producto());
            int executar = parametro.executeUpdate();
            retorno = executar;
            cn.close_conexion();
        }catch(SQLException ex){
            System.out.println(ex.getMessage());
        }
        return retorno;
    
    }
    
    
   public HashMap txt_producto(){
        HashMap<String,String> droppa = new HashMap();
        
        try{
            cn = new conexion();
            String query="SELECT id_producto as id,producto FROM productos;";
            cn.abrir_conexion();
            ResultSet consulta = cn.conexionBD.createStatement().executeQuery(query);
            
            while(consulta.next()){
                droppa.put(consulta.getString("id"), consulta.getString("producto"));
        
            }
            
            cn.close_conexion();
        }catch(SQLException ex){
                System.out.println(ex.getMessage());
        }
        
        
        return droppa;
    }    
       
       
}
