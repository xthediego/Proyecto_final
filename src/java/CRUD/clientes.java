
package CRUD;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import javax.swing.table.DefaultTableModel;
/**
 *
 * @author Diego Sandoval
 */
public class clientes {
    private int id_cliente,id_genero;
    private String nombres,apellidos,Nit,telefono,correo_electronico,fechaingreso;
    
       private conexion cn;
       
      public clientes(){}
     public clientes(int id_cliente, int id_genero, String nombres, String apellidos, String Nit, String telefono, String correo_electronico, String fechaingreso) {
        this.id_cliente = id_cliente;
        this.id_genero = id_genero;
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.Nit = Nit;
        this.telefono = telefono;
        this.correo_electronico = correo_electronico;
        this.fechaingreso = fechaingreso;
    }
        public int getId_cliente() {
        return id_cliente;
    }

    public void setId_cliente(int id_cliente) {
        this.id_cliente = id_cliente;
    }

    public int getId_genero() {
        return id_genero;
    }

    public void setId_genero(int id_genero) {
        this.id_genero = id_genero;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getNit() {
        return Nit;
    }

    public void setNit(String Nit) {
        this.Nit = Nit;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getCorreo_electronico() {
        return correo_electronico;
    }

    public void setCorreo_electronico(String correo_electronico) {
        this.correo_electronico = correo_electronico;
    }

    public String getFechaingreso() {
        return fechaingreso;
    }

    public void setFechaingreso(String fechaingreso) {
        this.fechaingreso = fechaingreso;
    }

    //AGREGAMOS SQL
    
    public int agregar(){
        int retorno = 0;
        try{
            cn = new conexion();
            
            PreparedStatement parametro;
            String query = "INSERT INTO clientes(nombres,apellidos,nit,genero,telefono,correo_electronico,fechaingreso) VALUES(?,?,?,?,?,?,?); "; 
            cn.abrir_conexion();
            parametro = (PreparedStatement) cn.conexionBD.prepareStatement(query);
            
            
            parametro.setString(1,getNombres());
            parametro.setString(2,getApellidos());
            parametro.setString(3,getNit());
            parametro.setInt(4,getId_genero());           
            parametro.setString(5,getTelefono());
            parametro.setString(6,getCorreo_electronico());  
            parametro.setString(7,getFechaingreso());
            

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
            String query="SELECT id_cliente as id, nombres,apellidos,nit,genero,telefono,correo_electronico,fechaingreso FROM clientes;";
            
            ResultSet consulta = cn.conexionBD.createStatement().executeQuery(query);
            
            String encabezados[]= {"id","nombres","apellidos","nit","genero","telefono","correo_electronico","fechaingreso"};
            tabla.setColumnIdentifiers(encabezados);
            
            String datos[]= new String[8];
            while(consulta.next()){
                
                datos[0]= consulta.getString("id");
                datos[1]= consulta.getString("nombres");
                datos[2]= consulta.getString("apellidos");
                datos[3]= consulta.getString("nit");
                datos[4]= consulta.getString("genero");
                datos[5]= consulta.getString("telefono");
                datos[6]= consulta.getString("correo_electronico");
                datos[7]= consulta.getString("fechaingreso");

                tabla.addRow(datos);
            }   
            
            cn.close_conexion();
        }catch(SQLException ex){
            System.out.println(ex.getMessage());
        }
        
        return tabla;
    }
    
    
    //imprimer generos select 
    //select para empleados
    
    //private String genero; ya inicializado arriba
    
    public HashMap txt_genero(){
        HashMap<String,String> dropp = new HashMap();
        
        try{
            cn = new conexion();
            String query="SELECT id_genero as id,genero FROM generos;";
            cn.abrir_conexion();
            ResultSet consulta = cn.conexionBD.createStatement().executeQuery(query);
            
            while(consulta.next()){
                dropp.put(consulta.getString("id"), consulta.getString("genero"));
        
            }
            
            cn.close_conexion();
        }catch(SQLException ex){
                System.out.println(ex.getMessage());
        }
        
        
        return dropp;
    }
    
   //////////////////////////////////////////////////////codigo de modificar y eliminar
     public int modify(){
         
         int retorno = 0;
     try{
            PreparedStatement parametro;
            
            cn = new conexion();
            cn.abrir_conexion();
            String query = "update clientes set nombres=?,apellidos=?,nit=?,genero=?,telefono=?,correo_electronico=?,fechaingreso=? where id_cliente=?";
                           
            parametro = (PreparedStatement)cn.conexionBD.prepareStatement(query);
            
            ///////////////////////////////////////////////////////////////////////////////
            parametro.setString(1,this.getNombres());
            parametro.setString(2,this.getApellidos());
            parametro.setString(3,this.getNit());
            parametro.setInt(4,this.getId_genero());
            parametro.setString(5,this.getTelefono());
            parametro.setString(6,this.getCorreo_electronico());
            parametro.setString(7,this.getFechaingreso());
            parametro.setInt(8,this.getId_cliente());
         
            ////////////////////////////////////////////////////////////////////////////////

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
            String query = "delete from clientes  where id_cliente=?;";
            parametro = (PreparedStatement)cn.conexionBD.prepareStatement(query);

            parametro.setInt(1,getId_cliente());
            int executar = parametro.executeUpdate();
            retorno = executar;
            cn.close_conexion();
        }catch(SQLException ex){
            System.out.println(ex.getMessage());
        }
        return retorno;
    
    }
    
    
    //////////////////////////////////////////////////////////////////////
    
   

   
}
