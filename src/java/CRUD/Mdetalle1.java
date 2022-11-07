
package CRUD;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import javax.swing.table.DefaultTableModel;


public class Mdetalle1 {
    private int id_ventas, nofactura, id_cliente, id_empleado;
    private String serie, fechafactura, fechaingreso;
    
    private int id_venta_detalle, id_venta, id_producto, precio_unitario,cantidad;
    

    conexion cn;
    
    public Mdetalle1(){}


    public int getId_ventas() {
        return id_ventas;
    }

    public void setId_ventas(int id_ventas) {
        this.id_ventas = id_ventas;
    }

    public int getNofactura() {
        return nofactura;
    }

    public void setNofactura(int nofactura) {
        this.nofactura = nofactura;
    }

    public int getId_cliente() {
        return id_cliente;
    }

    public void setId_cliente(int id_cliente) {
        this.id_cliente = id_cliente;
    }

    public int getId_empleado() {
        return id_empleado;
    }

    public void setId_empleado(int id_empleado) {
        this.id_empleado = id_empleado;
    }

    public String getSerie() {
        return serie;
    }

    public void setSerie(String serie) {
        this.serie = serie;
    }

    public String getFechafactura() {
        return fechafactura;
    }

    public void setFechafactura(String fechafactura) {
        this.fechafactura = fechafactura;
    }

    public String getFechaingreso() {
        return fechaingreso;
    }

    public void setFechaingreso(String fechaingreso) {
        this.fechaingreso = fechaingreso;
    }

    public int getId_venta_detalle() {
        return id_venta_detalle;
    }

    public void setId_venta_detalle(int id_venta_detalle) {
        this.id_venta_detalle = id_venta_detalle;
    }

    public int getId_venta() {
        return id_venta;
    }

    public void setId_venta(int id_venta) {
        this.id_venta = id_venta;
    }

    public int getId_producto() {
        return id_producto;
    }

    public void setId_producto(int id_producto) {
        this.id_producto = id_producto;
    }

    public int getPrecio_unitario() {
        return precio_unitario;
    }

    public void setPrecio_unitario(int precio_unitario) {
        this.precio_unitario = precio_unitario;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public Mdetalle1(int id_ventas, int nofactura, int id_cliente, int id_empleado, String serie, String fechafactura, String fechaingreso) {
        this.id_ventas = id_ventas;
        this.nofactura = nofactura;
        this.id_cliente = id_cliente;
        this.id_empleado = id_empleado;
        this.serie = serie;
        this.fechafactura = fechafactura;
        this.fechaingreso = fechaingreso;
    }

     public int agregar(){
        int retorno = 0;
        try{
            cn = new conexion();
            
            PreparedStatement parametro;
            String query = "INSERT INTO ventas(nofactura,serie,fechafactura,id_cliente,id_empleado,fechaingreso)VALUES(?,?,?,?,?,?); "; 
            cn.abrir_conexion();
            parametro = (PreparedStatement) cn.conexionBD.prepareStatement(query);
            
            
            parametro.setInt(1,getNofactura());
            parametro.setString(2,getSerie());
            parametro.setString(3,getFechafactura());
            parametro.setInt(4,getId_cliente());
            parametro.setInt(5,getId_empleado());
            parametro.setString(6,getFechaingreso());
            
            
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
            String query = "update ventas set nofactura=?,serie=?,fechafactura=?,id_cliente=?,id_empleado=?,fechaingreso=? where id_ventas=?";
            parametro = (PreparedStatement)cn.conexionBD.prepareStatement(query);
            
            parametro.setInt(1,getNofactura());
            parametro.setString(2,getSerie());
            parametro.setString(3,getFechafactura());
            parametro.setInt(4,getId_cliente());
            parametro.setInt(5,getId_empleado());
            parametro.setString(6,getFechaingreso());    
            parametro.setInt(7, this.getId_ventas());
            
           
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
            String query = "delete from ventas  where id_ventas=?;";
            parametro = (PreparedStatement)cn.conexionBD.prepareStatement(query);

            parametro.setInt(1,getId_ventas());
            int executar = parametro.executeUpdate();
            retorno = executar;
            cn.close_conexion();
        }catch(SQLException ex){
            System.out.println(ex.getMessage());
        }
        return retorno;
    
    } 
     
     
     
     
     
     
     
    public Mdetalle1(int id_venta_detalle, int id_ventas, int id_producto, int precio_unitario, int cantidad) {
        this.id_ventas = id_ventas;
        this.id_producto = id_producto;
        this.precio_unitario = precio_unitario;
        this.cantidad = cantidad;
        this.id_venta_detalle= id_venta_detalle;
    }
    

     public int agregar1(){
        int retorno = 0;
        try{
            cn = new conexion();
            
            PreparedStatement parametro;
            String query = "INSERT INTO venta_detalle(id_ventas,id_producto,cantidad,precio_unitario) VALUE(?,?,?,?); "; 
            cn.abrir_conexion();
            parametro = (PreparedStatement) cn.conexionBD.prepareStatement(query);
            
            
            parametro.setInt(1,getId_ventas());
            parametro.setInt(2,getId_producto());
            parametro.setInt(3,getCantidad());
            parametro.setInt(4,getPrecio_unitario());
            
            
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
            String query = "update venta_detalle set id_ventas=?,id_producto=?,cantidad=?,precio_unitario=? where id_venta_detalle=?";
            parametro = (PreparedStatement)cn.conexionBD.prepareStatement(query);
            
            parametro.setInt(1,getId_ventas());
            parametro.setInt(2,getId_producto());
            parametro.setInt(3,getCantidad());
            parametro.setInt(4,getPrecio_unitario());        
            parametro.setInt(5, this.getId_venta_detalle());
            
           
            int executar = parametro.executeUpdate();
            retorno = executar;
            cn.close_conexion();
        }catch(SQLException ex){
            System.out.println(ex.getMessage());
        } 
         return retorno;
     }
     
      public int delete1(){
         int retorno = 0;
     try{
            PreparedStatement parametro;
            
            cn = new conexion();
            cn.abrir_conexion();
            String query = "delete from venta_detalle  where id_venta_detalle=?;";
            parametro = (PreparedStatement)cn.conexionBD.prepareStatement(query);

            parametro.setInt(1,getId_ventas());
            int executar = parametro.executeUpdate();
            retorno = executar;
            cn.close_conexion();
        }catch(SQLException ex){
            System.out.println(ex.getMessage());
        }
        return retorno;
    
    } 
    
    
      
      
    
     public HashMap txt_clientes(){
        HashMap<String,String> dropp = new HashMap();
        
        try{
            cn = new conexion();
            String query="SELECT id_cliente as id,nombres FROM clientes;";
            cn.abrir_conexion();
            ResultSet consulta = cn.conexionBD.createStatement().executeQuery(query);
            
            while(consulta.next()){
                dropp.put(consulta.getString("id"), consulta.getString("nombres"));
        
            }
            
            cn.close_conexion();
        }catch(SQLException ex){
                System.out.println(ex.getMessage());
        }
        
        
        return dropp;
    }
     
     
     

     
     
     
     
     
    //SELECC leer
    
    public DefaultTableModel leer(){
        DefaultTableModel tabla = new DefaultTableModel();
        
        try{
            cn = new conexion();
            cn.abrir_conexion();
            String query=" SELECT v.id_ventas,v.nofactura, v.serie,v.fechafactura,v.id_cliente,v.id_empleado,v.fechaingreso,t.id_venta_detalle, t.id_ventas,t.id_producto,t.cantidad,t.precio_unitario FROM  ventas as v,  venta_detalle as t where v.id_ventas = t.id_ventas; ";
            
            
            ResultSet consulta = cn.conexionBD.createStatement().executeQuery(query);
            
            
            String encabezados[]= {"id_ventas","nofactura","serie","fechafactura","id_cliente","id_empleado","fechaingreso","id_venta_detalle","id_venta","id_producto","cantidad","precio_unitario"};
            tabla.setColumnIdentifiers(encabezados);
            
            String datos[]= new String[12];
            while(consulta.next()){
                
                datos[0]= consulta.getString("v.id_ventas");
                datos[1]= consulta.getString("v.nofactura");
                datos[2]= consulta.getString("v.serie");
                datos[3]= consulta.getString("v.fechafactura");
                datos[4]= consulta.getString("v.id_cliente");
                datos[5]= consulta.getString("v.id_empleado");
                datos[6]= consulta.getString("v.fechaingreso");
                
                datos[7]= consulta.getString("t.id_venta_detalle");
                datos[8]= consulta.getString("t.id_ventas");
                datos[9]= consulta.getString("t.id_producto");
                datos[10]= consulta.getString("t.cantidad");
                datos[11]= consulta.getString("t.precio_unitario");
                
             
                
                tabla.addRow(datos);
            }   
            
            cn.close_conexion();
        }catch(SQLException ex){
            System.out.println(ex.getMessage());
        }
        
        return tabla;
    }
     
    
    
}
