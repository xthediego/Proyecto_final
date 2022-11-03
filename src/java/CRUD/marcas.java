
package CRUD;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.util.HashMap;
import javax.swing.table.DefaultTableModel;

public class marcas {
    private int id_marca;
    private String marca;
    conexion cn;
    
    public marcas(){}
    public marcas(int id_marca, String marca) {
        this.id_marca = id_marca;
        this.marca = marca;
    }

    public int getId_marca() {
        return id_marca;
    }

    public void setId_marca(int id_marca) {
        this.id_marca = id_marca;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }
    
    
    //AGREGAMOS SQL
    
    public int agregar(){
        int retorno = 0;
        try{
            cn = new conexion();
            
            PreparedStatement parametro;
            String query = "INSERT INTO marcas(marca) VALUES(?); "; 
            cn.abrir_conexion();
            parametro = (PreparedStatement) cn.conexionBD.prepareStatement(query);
            
            
            parametro.setString(1,getMarca());
            
            
            
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
            String query="SELECT id_marca as id, marca FROM marcas;";
            
            ResultSet consulta = cn.conexionBD.createStatement().executeQuery(query);
            
            String encabezados[]= {"id","marca"};
            tabla.setColumnIdentifiers(encabezados);
            
            String datos[]= new String[2];
            while(consulta.next()){
                
                datos[0]= consulta.getString("id");
                datos[1]= consulta.getString("marca");
                
                
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
            String query="SELECT id_marca as id,marca FROM marcas;";
            cn.abrir_conexion();
            ResultSet consulta = cn.conexionBD.createStatement().executeQuery(query);
            
            while(consulta.next()){
                drop.put(consulta.getString("id"), consulta.getString("marca"));
        
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
            String query = "update marcas set marca=? where id_marca=?";
            parametro = (PreparedStatement)cn.conexionBD.prepareStatement(query);
            parametro.setString(1,getMarca());
            parametro.setInt(2, this.getId_marca());
            
           
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
            String query = "delete from marcas  where id_marca=?;";
            parametro = (PreparedStatement)cn.conexionBD.prepareStatement(query);

            parametro.setInt(1,getId_marca());
            int executar = parametro.executeUpdate();
            retorno = executar;
            cn.close_conexion();
        }catch(SQLException ex){
            System.out.println(ex.getMessage());
        }
        return retorno;
    
    }
    
    
}
