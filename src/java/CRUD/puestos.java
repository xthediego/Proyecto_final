/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CRUD;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.util.HashMap;
import javax.swing.table.DefaultTableModel;
/**
 *
 * @author Diego Sandoval
 */
public class puestos {
    private int id_puesto;
    private String puesto;
    
    conexion cn;
    
    public puestos(){}
    public puestos(int id_puesto, String puesto) {
        this.id_puesto = id_puesto;
        this.puesto = puesto;
    }
    
    public int getId_puesto() {
        return id_puesto;
    }

    public void setId_puesto(int id_puesto) {
        this.id_puesto = id_puesto;
    }

    public String getPuesto() {
        return puesto;
    }

    public void setPuesto(String puesto) {
        this.puesto = puesto;
    }


    
    //AGREGAMOS SQL
   
        public int agregar(){
    int retorno = 0;
     try{
            PreparedStatement parametro;
            
            cn = new conexion();
            cn.abrir_conexion();
            String query = "INSERT INTO puestos (puesto) VALUES (?)";
            cn.abrir_conexion();
            parametro = (PreparedStatement)cn.conexionBD.prepareStatement(query);
            parametro.setString(1,this.getPuesto());
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
            String query="SELECT id_puesto as id, puesto FROM puestos;";
            
            ResultSet consulta = cn.conexionBD.createStatement().executeQuery(query);
            
            String encabezados[]= {"id","puesto"};
            tabla.setColumnIdentifiers(encabezados);
            
            String datos[]= new String[2];
            while(consulta.next()){
                
                datos[0]= consulta.getString("id");
                datos[1]= consulta.getString("puesto");
                
                
                tabla.addRow(datos);
            }   
            
            cn.close_conexion();
        }catch(SQLException ex){
            System.out.println(ex.getMessage());
        }
        
        return tabla;
    }
    
   
    //select para empleados
    
    public HashMap txt_id_puesto(){
        HashMap<String,String> drop = new HashMap();
        
        try{
            cn = new conexion();
            String query="SELECT id_puesto as id,puesto FROM puestos;";
            cn.abrir_conexion();
            ResultSet consulta = cn.conexionBD.createStatement().executeQuery(query);
            
            while(consulta.next()){
                drop.put(consulta.getString("id"), consulta.getString("puesto"));
        
            }
            
            cn.close_conexion();
        }catch(SQLException ex){
                System.out.println(ex.getMessage());
        }
        
        
        return drop;
    }
    
   ////////////////*************************aqui inicia el codigo nuevo 
    
     public int modify(){
         
         int retorno = 0;
     try{
            PreparedStatement parametro;
            
            cn = new conexion();
            cn.abrir_conexion();
            String query = "update puestos set puesto=? where id_puesto=?";
            parametro = (PreparedStatement)cn.conexionBD.prepareStatement(query);
            parametro.setString(1,getPuesto());
            parametro.setInt(2, this.getId_puesto());
            
           
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
            String query = "delete from puestos  where id_puesto=?;";
            parametro = (PreparedStatement)cn.conexionBD.prepareStatement(query);

            parametro.setInt(1,getId_puesto());
            int executar = parametro.executeUpdate();
            retorno = executar;
            cn.close_conexion();
        }catch(SQLException ex){
            System.out.println(ex.getMessage());
        }
        return retorno;
    
    }

}//llave final 